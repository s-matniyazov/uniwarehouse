package org.uniteam.uniwarehouse.data.dto;

import java.sql.Date;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 18 дек. 2024
 **/
public record OrderDTO (
        Integer id,
        String customer,
        String number,
        Date date,
        String description
) { }
