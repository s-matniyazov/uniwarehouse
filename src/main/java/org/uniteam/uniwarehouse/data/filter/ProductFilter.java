package org.uniteam.uniwarehouse.data.filter;

import java.math.BigDecimal;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 12 дек. 2024
 **/
public record ProductFilter (
        String name,
        Integer productTypesId,
        Integer productStatusesId,
        BigDecimal price
) { }
