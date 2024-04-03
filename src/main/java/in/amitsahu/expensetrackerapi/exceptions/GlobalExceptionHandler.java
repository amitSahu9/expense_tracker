package in.amitsahu.expensetrackerapi.exceptions;

import in.amitsahu.expensetrackerapi.entity.ErrorObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorObject> handleExpenseNotFoundException(ResourceNotFoundException ex, WebRequest request){
//        ErrorObject errorObject = new ErrorObject();
//        errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
//        errorObject.setMessage(ex.getMessage());
//        errorObject.setTimestamp(new Date());
//        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
//    }
    @ExceptionHandler
    public ResponseEntity<ErrorObject> handleExpenseNotFoundException(ResourceNotFoundException ex, WebRequest request)
    {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setTimestamp(new Date());
        errorObject.setMessage(ex.getMessage());
        errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
    }
}
