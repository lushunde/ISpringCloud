package top.incoding.cloud.igateway.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.stream.Collectors;

/**
 * @ClassName MyBean
 * @Description TODO 快来记录点什么吧，不要太懒了
 * @Author bellus
 * @Date 2022/6/21 10:55
 * @Version 1.0.0
 **/
@Configuration
public class MyBean {

    // 解决问题 Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'org.springframework.boot.autoconfigure.http.HttpMessageConverters' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
    @Bean
    @ConditionalOnMissingBean
    public HttpMessageConverters messageConverters(ObjectProvider<HttpMessageConverter<?>> converters) {
        return new HttpMessageConverters(converters.orderedStream().collect(Collectors.toList()));
    }
}
