package test.java.configuration;

import static org.hibernate.cfg.AvailableSettings.C3P0_ACQUIRE_INCREMENT;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_STATEMENTS;
import static org.hibernate.cfg.AvailableSettings.C3P0_MIN_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_TIMEOUT;
import static org.hibernate.cfg.AvailableSettings.DRIVER;
import static org.hibernate.cfg.AvailableSettings.PASS;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.URL;
import static org.hibernate.cfg.AvailableSettings.USER;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@ComponentScan({"sokker"})
public class TestContext{
    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
       LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

       Properties props = new Properties();
       // Setting JDBC properties
       props.put(DRIVER, "com.mysql.jdbc.Driver");
       props.put(URL, "jdbc:mysql://localhost:3306/sokker?useSSL=false");
       props.put(USER, "sokker");
       props.put(PASS, "sokker");

       // Setting Hibernate properties
       props.put(SHOW_SQL, true);
       //props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));

       // Setting C3P0 properties
       props.put(C3P0_MIN_SIZE, 
             5);
       props.put(C3P0_MAX_SIZE, 
             20);
       props.put(C3P0_ACQUIRE_INCREMENT,
             1);
       props.put(C3P0_TIMEOUT, 
             1800);
       props.put(C3P0_MAX_STATEMENTS, 
             150);

       factoryBean.setHibernateProperties(props);
       //factoryBean.setAnnotatedClasses(User.class);
       factoryBean.setPackagesToScan( "sokker" );
       return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
       HibernateTransactionManager transactionManager = new HibernateTransactionManager();
       transactionManager.setSessionFactory(getSessionFactory().getObject());
       return transactionManager;
    }

}
