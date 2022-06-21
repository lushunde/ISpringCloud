package top.incoding.cloud.igateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description 不要太懒了注释一下吧^_^
 * @Author Bellus
 * @Date 2022/6/21 10:55
 * @Version 1.0.0
 * @Param 
 * @return 
 **/
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = "top.incoding.cloud")
public class IGateway8800Application {

    public static void main(String[] args) {
        SpringApplication.run(IGateway8800Application.class, args);
    }



}
