package org.uniteam.uniwarehouse.util.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.uniteam.uniwarehouse.util.exceptions.NotFoundException;
import org.uniteam.uniwarehouse.util.helper.MessageSourceBundle;

import java.util.logging.Logger;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 27 нояб. 2024
 **/
@ControllerAdvice
public class GlobalHandler extends ResponseEntityExceptionHandler {

    private final MessageSourceBundle messageSourceBundle;

    private final java.util.logging.Logger logger = Logger.getLogger(GlobalHandler.class.getName());

    @Autowired
    public GlobalHandler(MessageSourceBundle messageSourceBundle) {
        this.messageSourceBundle = messageSourceBundle;
    }

    // todo: BaseResponse should be returned
    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<?> handleExists(NotFoundException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}