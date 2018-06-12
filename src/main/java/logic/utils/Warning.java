
package main.java.logic.utils;


import lombok.Getter;
import lombok.Setter;
import main.java.logic.enums.ErrorType;

@Getter
@Setter
public class Warning{

    private String message;

    public Warning(){

    }

    public Warning( String msg ){
        this.message = msg;
    }
}
