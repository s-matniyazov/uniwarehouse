package org.uniteam.uniwarehouse.util.helper;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 07 янв. 2025
 **/
public class Helpers {
    public static String token() {
        return UUID.randomUUID().toString();
    }
    public static String path() {
        LocalDate cDate = LocalDate.now();
        return String.format("//%s//%s//%s//", cDate.getYear(), cDate.getMonthValue(), cDate.getDayOfMonth());
    }
}
