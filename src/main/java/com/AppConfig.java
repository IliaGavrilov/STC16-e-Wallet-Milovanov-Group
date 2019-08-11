package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan({"com.controllers"})
@Import({SecurityConfig.class})
public class AppConfig {

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://ec2-54-247-170-5.eu-west-1.compute.amazonaws.com:5432/d1qsn4vbbh1t4");
        driverManagerDataSource.setUsername("yavknxrhegcjyx");
        driverManagerDataSource.setPassword("c38b2288b7f0d450f64eec0baaae8cbadd43fb4ccd754768fb0e6e002e291144");
        return driverManagerDataSource;
    }

//    @Bean(name = "dataSource")
//    public DriverManagerDataSource dataSource() {
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
//        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
//        driverManagerDataSource.setUsername("postgres");
//        driverManagerDataSource.setPassword("landlord17");
//        return driverManagerDataSource;
//    }

}
