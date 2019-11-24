package com.kevin.springboot.ctrip.config;

import com.kevin.springboot.ctrip.api.PriceService;
import com.kevin.springboot.ctrip.api.PriceServiceImpl;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: yoli
 * @since: 2019/11/24
 */
@Configuration
public class ProviderConfig
{
    @Value("${dubbo.registry.address}")
    private String registerAddress;

    @Value("${dubbo.application.name}")
    private String applicationName;

//    //<dubbo:application name="boot-user-service-provider"></dubbo:application>
//    @Bean
//    @ConditionalOnMissingBean(value = {ApplicationConfig.class})
//    public ApplicationConfig applicationConfig() {
//        ApplicationConfig applicationConfig = new ApplicationConfig();
//        applicationConfig.setName(applicationName);
//        return applicationConfig;
//    }
//
//    //<dubbo:registry protocol="zookeeper" address="127.0.0.1:2181"></dubbo:registry>
//    @Bean
//    @ConditionalOnMissingBean(value = {RegistryConfig.class})
//    public RegistryConfig registryConfig() {
//        RegistryConfig registryConfig = new RegistryConfig();
//        registryConfig.setProtocol("nacos");
//        registryConfig.setAddress("127.0.0.1:8848");
//        return registryConfig;
//    }
//
//    @Bean
//    public ServiceConfig<PriceService> userServiceConfig(PriceService priceService)
//    {
//        ServiceConfig<PriceService> serviceConfig = new ServiceConfig<>();
//        serviceConfig.setInterface(PriceService.class);
//        serviceConfig.setRef(priceService);
//        serviceConfig.setVersion("1.0.0");
//
////        //配置每一个method的信息
////        MethodConfig methodConfig = new MethodConfig();
////        methodConfig.setName("getUserAddressList");
////        methodConfig.setTimeout(1000);
////
////        //将method的设置关联到service配置中
////        List<MethodConfig> methods = new ArrayList<>();
////        methods.add(methodConfig);
////        serviceConfig.setMethods(methods);
//
//        return serviceConfig;
//
//    }
}
