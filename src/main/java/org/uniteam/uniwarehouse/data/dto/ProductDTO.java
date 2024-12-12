package org.uniteam.uniwarehouse.data.dto;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 27 нояб. 2024
 **/
public record ProductDTO (
        Integer id,
        String nameUz,
        String nameUk,
        String nameRu,
        String nameEn,
        Double amount,
        Double price,
        String tinCode,
        Integer unitId,
        Integer qualityId,
        Integer productTypesId
) {}
