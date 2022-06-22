package top.incoding.cloud.igoods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @Description 不要太懒了注释一下吧^_^
 * @Author Bellus
 * @Date 2022/6/19 16:14
 * @Version 1.0.0
 * @Param 
 * @return 
 **/
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class IGoodsProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(IGoodsProviderApplication.class, args);
    }

}
