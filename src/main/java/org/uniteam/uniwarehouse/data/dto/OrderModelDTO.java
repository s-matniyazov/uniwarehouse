package org.uniteam.uniwarehouse.data.dto;

import java.util.List;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 19 дек. 2024
 **/
public record OrderModelDTO (
        Integer id,
        String name,
        String size,
        Integer count,
        String description,
        List<OrderModelAttributeDTO> attributes,
        Integer orderId
) {}
