package com.mycompany;

import java.util.List;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	new SpringApplicationBuilder(App.class)
        .web(false)
        .run(args);
    }
}

@Component
class RestTemplateExample implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(String... strings) throws Exception {
        // use the "smart" Eureka-aware RestTemplate
        ResponseEntity<List<Contact>> exchange =
                this.restTemplate.exchange(
                        "http://springwebapp/contact/jsonlist",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Contact>>() {}
                        
                        );

        exchange.getBody().forEach(System.out::println);
    }

}
