package spring.config;


import DAO.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("/WEB-INF/database.properties")
public class HibernateConfig {
    @Autowired
    private Environment env;

    private Properties hibernateProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        hibernateProperties.setProperty("current_session_context_class", env.getRequiredProperty("current_session_context_class"));

        return hibernateProperties;
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("postgresql.driver"));
        dataSource.setUrl(env.getRequiredProperty("postgresql.localhost") +
                env.getRequiredProperty("postgresql.database"));
        dataSource.setUsername(env.getRequiredProperty("postgresql.user"));
        dataSource.setPassword(env.getRequiredProperty("postgresql.password"));

        return dataSource;
    }

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setPackagesToScan("entity");
        factoryBean.setDataSource(dataSource);
        factoryBean.setHibernateProperties(hibernateProperties());
        factoryBean.setMappingResources("link.hbm.xml");
        return factoryBean;
    }

    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

    @Bean(name = "DaoCars")
    public DaoCars DaoCars() {
        return new DaoCars();
    }

    @Bean(name = "DaoClients")
    public DaoClients DaoClients() {
        return new DaoClients();
    }

    @Bean(name = "DaoDevelopers")
    public DaoDevelopers DaoDrvelopers() {
        return new DaoDevelopers();
    }

    @Bean(name = "DaoDevices")
    public DaoDevices DaoDevices() {
        return new DaoDevices();
    }

    @Bean(name = "DaoModels")
    public DaoModels SportsmanDAO() {
        return new DaoModels();
    }

    @Bean(name = "DaoOrders")
    public DaoOrders DaoOrders() {
        return new DaoOrders();
    }

}