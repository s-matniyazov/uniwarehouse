package org.uniteam.uniwarehouse.domain.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 20 нояб. 2024
 **/
@MappedSuperclass
public abstract class BaseNameEntity extends BaseIdEntity {
    @Transient
    private String name;

    @Column(name = "name_uz")
    private String nameUz;
    @Column(name = "name_uk")
    private String nameUk;
    @Column(name = "name_ru")
    private String nameRu;
    @Column(name = "name_en")
    private String nameEn;

    public BaseNameEntity() {
    }

    public BaseNameEntity(String nameUz, String nameUk, String nameRu, String nameEn) {
        this.nameUz = nameUz;
        this.nameUk = nameUk;
        this.nameRu = nameRu;
        this.nameEn = nameEn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameUz() {
        return nameUz;
    }

    public void setNameUz(String nameUz) {
        this.nameUz = nameUz;
    }

    public String getNameUk() {
        return nameUk;
    }

    public void setNameUk(String nameUk) {
        this.nameUk = nameUk;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
}
