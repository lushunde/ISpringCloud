package top.incoding.cloud.ieureka.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.ConfigurationPropertySources;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.commons.util.InetUtilsProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.net.InetAddress;
import java.util.LinkedHashMap;

/**
 * @ClassName HostInfoEnvironmentPostProcessor
 * @Description TODO 快来记录点什么吧，不要太懒了
 * @Author bellus
 * @Date 2022/6/20 11:22
 * @Version 1.0.0
 **/

@Configuration
public class HostInfoEnvironmentPostProcessor  implements EnvironmentPostProcessor, Ordered {


    private int order = ConfigFileApplicationListener.DEFAULT_ORDER ;

    @Override
    public int getOrder() {
        return this.order;
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment,
                                       SpringApplication application) {
        InetUtils.HostInfo hostInfo = getFirstNonLoopbackHostInfo(environment);
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("spring.cloud.client.hostname", hostInfo.getHostname());
        map.put("spring.cloud.client.ip-address", hostInfo.getIpAddress());
        MapPropertySource propertySource = new MapPropertySource(
                "springCloudClientHostInfo", map);
        environment.getPropertySources().addLast(propertySource);
        System.out.println("HostInfoEnvironmentPostProcessor.postProcessEnvironment" + environment);
    }

    private InetUtils.HostInfo getFirstNonLoopbackHostInfo(ConfigurableEnvironment environment) {
        InetUtilsProperties target = new InetUtilsProperties();
        ConfigurationPropertySources.attach(environment);
        Binder.get(environment).bind(InetUtilsProperties.PREFIX,
                Bindable.ofInstance(target));
        try (InetUtils utils = new InetUtils(target)) {

            return utils.findFirstNonLoopbackHostInfo();
        }
    }

}