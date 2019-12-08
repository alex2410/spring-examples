package ru.trushkin.spring.example2.data;

import org.hibernate.SessionFactory;
import org.postgresql.Driver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;
import java.util.Properties;


@EnableTransactionManagement
@Configuration
@ComponentScan
public class JpaConfig {

    @Bean
    public HibernateTemplate hibernateTemplate() {
        HibernateTemplate hibernateTemplate = new HibernateTemplate();
        hibernateTemplate.setSessionFactory(sessionFactory().getObject());
        return hibernateTemplate;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(
                new String[]{"ru.trushkin.spring.example2.data"});
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/boot");
        dataSource.setDriverClassName(Driver.class.getName());
        dataSource.setUsername("postgres");
        dataSource.setSchema("public");
        dataSource.setPassword("password");

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
                = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private final Properties hibernateProperties() {
        Properties p = new Properties();
        p.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        p.setProperty("hibernate.username", "postgres");
        p.setProperty("hibernate.password", "password");

        return p;
    }


    public static void main(String[] args) throws InterruptedException {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
        SpeakerRepository bean = ctx.getBean(SpeakerRepository.class);

        ATalk t = new ATalk();
        t.setTitle("1");
        t.setWhenDate(new Date());

        Speaker s = new Speaker();
        s.setName("speaker 1");
        s.addTalk(t);
        t.setSpeaker(s);
        bean.save(s);

        List<Speaker> s1 = bean.findByName("s");
        System.out.println(s1);

        s1 = bean.findByName("speaker 1");
        System.out.println(s1);

    }
}
