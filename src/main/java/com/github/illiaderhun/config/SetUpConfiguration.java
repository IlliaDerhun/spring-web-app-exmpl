package com.github.illiaderhun.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.github.illiaderhun")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SetUpConfiguration implements WebMvcConfigurer {

    @Bean(destroyMethod = "close")
    public ComboPooledDataSource myDataSource() {
        ComboPooledDataSource thePool = new ComboPooledDataSource();

        try {
            thePool.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        thePool.setJdbcUrl("jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false");
        thePool.setUser("root");
        thePool.setPassword("root");

        thePool.setInitialPoolSize(5);
        thePool.setMinPoolSize(5);
        thePool.setMaxPoolSize(20);
        thePool.setMaxIdleTime(30000);

        return thePool;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean theSession = new LocalSessionFactoryBean();

        theSession.setDataSource(myDataSource());
        theSession.setPackagesToScan("com.github.illiaderhun.entity");
        theSession.setHibernateProperties(getHibernateProperties());

        return theSession;
    }

    @Bean
    public HibernateTransactionManager myTransactionManager() {
        HibernateTransactionManager theManager = new HibernateTransactionManager();

        theManager.setSessionFactory(sessionFactory().getObject());

        return theManager;
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
            .addResourceHandler("/resources/**")
            .addResourceLocations("/resources/");
    }

    private Properties getHibernateProperties() {
        Properties hibernateProperties = new Properties();

        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.put("hibernate.show_sql", true);

        return hibernateProperties;
    }
}


