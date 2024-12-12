package org.uniteam.uniwarehouse.domain.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 20 нояб. 2024
 **/
@MappedSuperclass
public abstract class BaseIconEntity extends BaseNameEntity {
    @Column(name = "icon", length = 20)
    private String icon;
    @Column(name = "color", length = 20)
    private String color;
    @Column(name = "bg_color", length = 20)
    private String bgColor;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }
}
