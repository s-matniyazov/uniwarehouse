package org.uniteam.uniwarehouse.data.dto;

import java.math.BigDecimal;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 30 нояб. 2024
 **/
public record ImportProductDTO(
        Integer id,
        Integer productId,
        Double amount,
        BigDecimal price
) { }
