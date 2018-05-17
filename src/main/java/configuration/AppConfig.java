
package main.java.configuration;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import static org.hibernate.cfg.Environment.*;

@Configuration
@EnableTransactionManagement
@ComponentScans(value = {@ComponentScan("main.java") })
public class AppConfig{

    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/sokker?useSSL=false";
    private static final String LOGIN = "sokker";
    private static final String PASSWORD = "sokker";

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        Properties props = initProperties();
        factoryBean.setHibernateProperties( props );
        factoryBean.setPackagesToScan( "main.java.logic.entity" );
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory( sessionFactory().getObject() );

        return transactionManager;
    }

    private Properties initProperties(){
        Properties props = new Properties();
        
        props.put( DRIVER, DRIVER_NAME );
        props.put( URL, DB_URL );
        props.put( USER, LOGIN );
        props.put( PASS, PASSWORD );
        props.put( SHOW_SQL, true );
        props.put( C3P0_MIN_SIZE, 5 );
        props.put( C3P0_MAX_SIZE, 20 );
        props.put( C3P0_ACQUIRE_INCREMENT, 1 );
        props.put( C3P0_TIMEOUT, 1800 );
        props.put( C3P0_MAX_STATEMENTS, 150 );

        return props;
    }
}
