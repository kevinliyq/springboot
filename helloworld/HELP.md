# springboot - helloworld

## Springboot 原理
Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化Spring应用的初始搭建以及开发过程，只需要少量的配置就可以把一些第三方的技术集合进来。
SpringBoot主要包含两部分的内容:
1.  自动配置

* SpringBoot通过启动类上的注解@SpringBootApplication来完成, @SpringBootApplication包含三个注解

    - SpringBootConfiguration 实际就是一个@Configuration，是基于JavaConfig的Bean生产容器
    - ComponentScan就是一个注解扫描器，负责扫描启动类包和子包的注解
    - EnableAutoConfiguration 负责load META-INF/spring.factories, 读取org.springframework.boot.autoconfigure.EnableAutoConfiguration
    从而获取一系列的AutoConfiguration，在写AutoConfiguration会根据特定的条件(@Conditional @ConditionalBean @ConditionalOnClass etc)去创建Bean

* EnableAutoConfiguration详解
  - 通过@Import({AutoConfigurationImportSelector.class})是的在SpringBoot启动过程中能调用到AutoConfigurationImportSelector的selectImports方法
  - ConfigurationClassParser.getImports -> AutoConfigurationImportSelector.process -> loadSpringFactories
  ```java
public void process(AnnotationMetadata annotationMetadata, DeferredImportSelector deferredImportSelector) {
            AutoConfigurationImportSelector.AutoConfigurationEntry autoConfigurationEntry = ((AutoConfigurationImportSelector)deferredImportSelector).getAutoConfigurationEntry(this.getAutoConfigurationMetadata(), annotationMetadata);
  ```
  - 在每个AutoConfiguration会根据特定条件才会创建Bean, 如RedisAutoConfiguration，只有在classpath能找到RedisOperations才会初始化

```java
@Configuration(
    proxyBeanMethods = false
)
@ConditionalOnClass({RedisOperations.class})
@EnableConfigurationProperties({RedisProperties.class})
@Import({LettuceConnectionConfiguration.class, JedisConnectionConfiguration.class})
```
@Configuration表明这个是配置类，ConditionalOnClass则表明需要RedisOperations存在在classpath才会走下一步。
如条件满足，则初始化RedisPropertiesBean如url, password等
之后引入LettuceConnectionConfiguration或者JedisConnectionConfiguration
  
  
  
2 快速启动依赖
在原先的Spring中，比如我们让我们的应用程序在Tomcat里运行，则需要在maven的pom.xml或者是gradle的build.grade添加很多的dependencies。
现在在SpringBoot，一个快速依赖会把相关的dependencies添加到starter中，
我们只需要添加spring-boot-starter-web就会把相应的dependencies关联进来。
节省了我们的很多工作。





