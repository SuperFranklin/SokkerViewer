
package main.java.logic.utils;


import java.util.ArrayList;
import java.util.List;

public class ErrorCollector<T> {

    private T response;
    private List<Error> errors = new ArrayList<>();

    public ErrorCollector( T response ){
        this.response = response;
    }

    public ErrorCollector( T response, List<Error> errors ){
        this.response = response;
        this.errors = errors;
    }

    public T getObject(){
        return response;
    }

    public boolean hasErrors(){
        return errors.isEmpty()? false : true;
    }
}
