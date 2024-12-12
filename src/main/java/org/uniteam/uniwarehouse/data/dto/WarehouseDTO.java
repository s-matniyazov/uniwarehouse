package org.uniteam.uniwarehouse.data.dto;

import java.util.List;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 23 нояб. 2024
 **/
public record WarehouseDTO (
        Integer id,
        String name,
        Integer productTypeId,
        List<WarehouseProductDTO> products
) {}
