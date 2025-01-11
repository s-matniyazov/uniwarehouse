package org.uniteam.uniwarehouse.service;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.uniteam.uniwarehouse.domain.entity.Resource;
import org.uniteam.uniwarehouse.repository.ResourceRepository;
import org.uniteam.uniwarehouse.service.base.BaseService;
import org.uniteam.uniwarehouse.util.exceptions.NotFoundException;
import org.uniteam.uniwarehouse.util.helper.Helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static org.uniteam.uniwarehouse.util.constants.Constants.FILE_PATH;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 07 янв. 2025
 **/
@Service
public class ResourceService extends BaseService {
    private final ResourceRepository repository;

    public ResourceService(ResourceRepository repository) {
        this.repository = repository;
    }

    public void get(String token, HttpServletResponse response) {
        try {
            Resource resource = repository.findByToken(token).orElseThrow(IOException::new);

            File file = new File(String.format("%s/%s/%s.%s", FILE_PATH, resource.getPath(), resource.getAccessName(), resource.getExtension()));

            response.setContentType(resource.getContentType());

            FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
        } catch (IOException e) {
            throw new NotFoundException(mSourceBundle.apply("file.not_found"));
        }
    }

    @Transactional
    public Resource save(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new RuntimeException();
        }

        String[] fileName = Objects.requireNonNull(file.getOriginalFilename()).split("\\.");

        Resource resource = repository.save(new Resource(
                fileName[0],
                file.getContentType(),
                fileName[fileName.length - 1],
                file.getSize(),
                Helpers.token(),
                Helpers.path(),
                String.valueOf(System.currentTimeMillis())
        ));

        Path path = Paths.get(FILE_PATH + resource.getPath() + resource.getAccessName()+"."+resource.getExtension());
        try {
            Files.copy(file.getInputStream(), path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return resource;
    }
}
