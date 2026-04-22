package spring_boot.session13bt04.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.hibernate.HibernateTransactionManager;
import org.springframework.orm.jpa.hibernate.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class HibernateConfig {
    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean factoryBean(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("spring_boot.model.entity");

        Properties prop =  new Properties();
        prop.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        prop.put("hibernate.hbm2ddl.auto",env.getProperty("hibernate.ddl-auto"));
        prop.put("hibernate.dialect",env.getProperty("hibernate.dialect"));
        prop.put("hibernate.format_sql",env.getProperty("hibernate.format_sql"));
        sessionFactory.setHibernateProperties(prop);
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager(LocalSessionFactoryBean factoryBean) {
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(factoryBean.getObject());
        return manager;
    }
}
