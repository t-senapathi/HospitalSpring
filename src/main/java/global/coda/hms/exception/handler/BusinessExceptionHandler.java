package global.coda.hms.exception.handler;

import global.coda.hms.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type Business exception handler.
 */
@ControllerAdvice
public class BusinessExceptionHandler {
    /**
     * Handler response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<?> handler(BusinessException e) {
        return new ResponseEntity<String>("Business Exception:"+ e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}