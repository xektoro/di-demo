package com.example.didemo.config;

import com.example.didemo.examplebeans.FakeDataSource;
import com.example.didemo.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
// specify the property file, where Spring should search for that string values
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

    // when we use @Value, the PropertySourcesPlaceholderConfigurer is going to match the values
    // for us. So the bean PropertySourcesPlaceholderConfigurer is very important
    @Value("${guru.username}")
    private String user;

    @Value("${guru.password}")
    private String password;


    @Value("${guru.jms.username}")
    private String jmsUsername;

    @Value("${guru.jms.password}")
    private String jmsPassoword;

    @Value("${guru.jms.url}")
    private String jmsUrl;

    // it is going to be evaluated as an expression and it is going to go into the Spring Context
    // and got that value out of the context as an externalised property
    @Value("${guru.dburl}")
    private String url;


    // this is one way ro read Environment Variables
    @Autowired
    private Environment env;

    // sets up the properties on a bean
    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setName(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        // we are loading the System Environment Bean and we are getting one of its properties
        fakeDataSource.setFavouriteClub(env.getProperty("FAVOURITE_CLUB"));
        return fakeDataSource;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker(){
        FakeJmsBroker jmsBroker = new FakeJmsBroker();
        jmsBroker.setUsername(jmsUsername);
        jmsBroker.setPassword(jmsPassoword);
        jmsBroker.setUrl(jmsUrl);
        return jmsBroker;
    }

    // it is needed to read the file(external file, but not application.property and application.yml)
    // because that two files are automatically  brought into the context by Spring
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer =
                new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
