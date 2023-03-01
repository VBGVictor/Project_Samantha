package CalendarioFinanceiro.Samantha.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class tratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity <ErrorResponse> tratarErro404(EntityNotFoundException ex) {
        System.out.println("CHEGOU NA REQUSIÇÂO");
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
