package org.uniteam.uniwarehouse.util.helper;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.function.Function;

import static org.uniteam.uniwarehouse.util.constants.LangEnum.*;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 07 Mar 2023
 **/
@Component
public record MessageSourceBundle (
        MessageSource messageSource
) implements Function<String, String> {
    @Override
    public String apply(String code) {
        try {
            return messageSource.getMessage(
                    code,
                    null,
                    switch (UZ) {
                        case UZ -> Locale.forLanguageTag("UZ");
                        case RU -> Locale.forLanguageTag("RU");
                        case UK -> Locale.forLanguageTag("UK");
                        default -> Locale.ENGLISH;
                    }
            );
        } catch (Exception e) {
            return messageSource.getMessage(
                    code,
                    null,
                    Locale.forLanguageTag("UZ")
            );
        }
    }
}