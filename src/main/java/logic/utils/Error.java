
package main.java.logic.utils;


import lombok.Getter;
import lombok.Setter;
import main.java.logic.enums.ErrorType;

@Getter
@Setter
public class Error{

    private ErrorType type;
    private String message;

    public Error(){

    }

    public Error( String msg ){
        this.message = msg;
        this.type = ErrorType.ERROR;
    }

    public Error( String msg, ErrorType type ){
        this.message = msg;
        this.type = type;
    }
}
