
package main.java.logic.utils;


import lombok.Getter;
import lombok.Setter;
import main.java.logic.enums.ErrorType;

@Getter
@Setter
public class Error{

    private String message;

    public Error(){

    }

    public Error( String msg ){
        this.message = msg;
    }

}
