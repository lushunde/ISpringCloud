package top.incoding.cloud.iorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description 不要太懒了注释一下吧^_^
 * @Author Bellus
 * @Date 2022/6/19 15:49
 * @Version 1.0.0
 * @Param 
 * @return 
 **/
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "top.incoding.cloud")
@EnableHystrix
public class IOrderProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(IOrderProviderApplication.class, args);
    }

}
