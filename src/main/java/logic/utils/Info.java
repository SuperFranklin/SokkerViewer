
package main.java.logic.utils;


import lombok.Getter;
import lombok.Setter;
import main.java.logic.enums.ErrorType;

@Getter
@Setter
public class Info{

    private String message;

    public Info(){

    }

    public Info( String msg ){
        this.message = msg;
    }
}
