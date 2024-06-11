package chakaChatApp.chaka.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UnAuthenticated  extends  RuntimeException{
    public  UnAuthenticated(String messeage)
    {
        super(messeage);
    }

}
