package com.lorelib.springcloud.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Created by listening on 2016/12/30.
 */
@SpringBootApplication
@EnableTurbine
public class TurbineApplication {
    public static void main(String[] args) {
        /*new SpringApplicationBuilder(TurbineApplication.class)
                .web(true).run(args);*/
        SpringApplication.run(TurbineApplication.class, args);
    }
}
