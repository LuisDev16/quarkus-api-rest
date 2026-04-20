package my.group.exception;

import java.time.LocalDateTime;

public class GlobalExceptionHandler {

    //FIX: BUSCCAR SU REMPLAZO PARA QUARKUS
   /*
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
        ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false),"EMPLOYEE_NOT_FOUND");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    */
}
