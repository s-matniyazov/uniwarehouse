package org.uniteam.uniwarehouse.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.uniteam.uniwarehouse.domain.entity.base.BaseIdEntity;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 07 янв. 2025
 **/
@Entity
public class Resource extends BaseIdEntity {
    @Column(name = "file_name", length = 200)
    private String name;
    @Column(name = "content_type", length = 50)
    private String contentType;
    @Column(name = "extension", length = 50)
    private String extension;
    @Column(length = 50)
    private Long size;
    @Column(length = 250)
    private String token;
    @Column(length = 50)
    private String path;
    @Column(length = 50)
    private String accessName;

    public Resource() {
    }

    public Resource(String name, String contentType, String extension, Long size, String token, String path, String accessName) {
        this.name = name;
        this.contentType = contentType;
        this.extension = extension;
        this.size = size;
        this.token = token;
        this.path = path;
        this.accessName = accessName;
    }

    public String getName() {
        return name;
    }

    public String getContentType() {
        return contentType;
    }

    public String getExtension() {
        return extension;
    }

    public Long getSize() {
        return size;
    }

    public String getToken() {
        return token;
    }

    public String getPath() {
        return path;
    }

    public String getAccessName() {
        return accessName;
    }
}
