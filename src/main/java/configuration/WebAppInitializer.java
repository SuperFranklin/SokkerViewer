package main.java.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    protected Class< ? >[] getRootConfigClasses(){
        return new Class<?>[] {PersistanceConfiguration.class};
    }

    protected Class< ? >[] getServletConfigClasses(){
        return new Class<?>[] {WebConfiguration.class};
    }

    protected String[] getServletMappings(){
        return new String[] {"/"};
    }
}
