
package main.java.logic.utils;


import java.util.ArrayList;
import java.util.List;

public class Result<T> {

    private T response;
    private List<Error> errors = new ArrayList<>();
    private List<Warning> warnings = new ArrayList<>();
    private List<Info> infos = new ArrayList<>();

    public Result( T response ){
        this.response = response;
    }

    public Result(){

    }

    public Result( T response, List<Error> errors ){
        this.response = response;
        this.errors = errors;
    }

    public T getObject(){
        return response;
    }

    public void addError( String msg ){
        Error error = new Error( msg );
        errors.add( error );
    }

    public void setErrors( List<Error> errors ){
        this.errors = errors;
    }

    public boolean hasErrors(){
        return errors.isEmpty()? false : true;
    }
}
