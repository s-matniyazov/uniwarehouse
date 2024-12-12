package org.uniteam.uniwarehouse.data.dto;

import java.util.Date;
import java.util.List;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 30 нояб. 2024
 **/
public record ImportDTO (
        Integer id,
        Integer warehouseId,
        List<ImportProductDTO> products,
        Date importDate,
        String sender,
        String receiver
) {
}
