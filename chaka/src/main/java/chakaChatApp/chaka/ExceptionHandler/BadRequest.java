package chakaChatApp.chaka.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequest  extends  RuntimeException{
    public  BadRequest(String messeage)
    {
        super(messeage);
    }

}
