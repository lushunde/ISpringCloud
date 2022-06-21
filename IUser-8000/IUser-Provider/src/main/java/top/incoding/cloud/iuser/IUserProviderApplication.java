package top.incoding.cloud.iuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description 不要太懒了注释一下吧^_^
 * @Author Bellus
 * @Date 2022/6/19 15:31
 * @Version 1.0.0
 * @Param
 * @return
 **/
@EnableEurekaClient
@SpringBootApplication
@MapperScan("top.incoding.cloud.iuser.mapper")
@EnableFeignClients(basePackages = "top.incoding.cloud")
@EnableDiscoveryClient
public class IUserProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(IUserProviderApplication.class, args);
    }

}
