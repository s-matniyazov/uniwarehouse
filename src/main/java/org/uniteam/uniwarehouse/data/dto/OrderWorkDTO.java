package org.uniteam.uniwarehouse.data.dto;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 23 дек. 2024
 **/
public record OrderWorkDTO (
        Integer id,
        String name,
        Integer count,
        Integer orderId
) {}
