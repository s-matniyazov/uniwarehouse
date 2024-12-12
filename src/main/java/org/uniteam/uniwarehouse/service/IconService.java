package org.uniteam.uniwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uniteam.uniwarehouse.domain.entity.Icon;
import org.uniteam.uniwarehouse.repository.IconRepository;

import java.util.List;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 22 нояб. 2024
 **/
@Service
public class IconService {
    private final IconRepository repository;

    @Autowired
    public IconService(IconRepository repository) {
        this.repository = repository;
    }

    public List<Icon> get() {
        return repository.findAll();
    }

    public Icon save(Icon data) {
        Icon icon = new Icon(data.getContent());
        if (data.getCode() != null) icon.setCode(data.getCode());
        return repository.save(icon);
    }
}
