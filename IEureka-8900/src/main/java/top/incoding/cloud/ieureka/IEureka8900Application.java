package top.incoding.cloud.ieureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description 不要太懒了注释一下吧^_^
 * @Author Bellus
 * @Date 2022/6/18 22:21
 * @Version 1.0.0
 * @Param 
 * @return 
 **/
@SpringBootApplication
@EnableEurekaServer
public class IEureka8900Application {

    public static void main(String[] args) {
        SpringApplication.run(IEureka8900Application.class, args);
    }

}
