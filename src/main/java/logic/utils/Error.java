package main.java.logic.utils;

import lombok.Getter;
import lombok.Setter;
import main.java.logic.enums.ErrorType;

@Getter
@Setter
public class Error{

    private ErrorType type;
    private String message;
}
