package org.uniteam.uniwarehouse.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 22 нояб. 2024
 **/
@Entity(name = "icons")
public class Icon {
    @Id
    @Column(name = "code", length = 50)
    private String code;
    @Column(name = "content", length = 1_000)
    private String content;

    public Icon() {
    }

    public Icon(String content) {
        this.content = content;
        this.code = getUniqueCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String getUniqueCode() {
        return String.valueOf(System.currentTimeMillis());
    }
}
