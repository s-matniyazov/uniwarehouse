package org.uniteam.uniwarehouse.data.dto;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 19 дек. 2024
 **/
public record OrderModelAttributeDTO (
        Integer id,
        Double amount,
        Integer productsId
) {}
