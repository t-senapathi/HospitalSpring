package global.coda.hms.exception.handler;

import global.coda.hms.exception.SystemException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type System exception handler.
 */
@ControllerAdvice
public class SystemExceptionHandler {
    /**
     * Handler response entity.
     *
     * @return the response entity
     */
    @ExceptionHandler({SystemException.class})
    public ResponseEntity<?> handler(){
        return new ResponseEntity<String>("Something went Wrong", HttpStatus.BAD_REQUEST);
    }
}