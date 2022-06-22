package top.incoding.cloud.hystrixdashdoard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


/**
 * @Description http://127.0.0.1:8600/hystrix
 * @Author Bellus
 * @Date 2022/6/22 9:39
 * @Version 1.0.0
 * @Param 
 * @return 
 **/
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashdoard8600Application {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashdoard8600Application.class, args);
    }

}
