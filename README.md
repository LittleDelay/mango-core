# 保准牛项目说明文档

该项目是保准牛后端项目标准模板，新建项目应从此项目 Clone 后进行业务开发。

#### 一、模板项目 Git 地址

> http://gitlab.baozhunniu.com/template/backend-template.git

#### 二、项目开发规范

1. Clone 本模板项目以后，请按照你的项目使用业务场景进行重命名。调整内容如下：

   - backend-template 父工程名称、pom.xml 中的 artifactId 名称
   - backend-api 模块名称、pom.xml 中的 artifactId 名称
   - backend-service 模块名称、pom.xml 中的 artifactId 名称
   - logback-spring.xml 文件中的 application.name 属性值及日志文件路径
   - application.properties 配置文件中的 spring.application.name、mapper.mappers 属性值
   - 修改各个环境的数据库连接配置

2. 请你在开始项目开发之前，认真阅读并熟悉本模板项目附带的示例程序。若无特殊情况，请以此示例程序的规范进行业务系统开发。

3. 项目中所使用的第三方开源项目jar包我们提供了统一的 base-dependencies-parent 依赖管理。若无特殊情况，不允许修改 SpringBoot、SpringCloud 以及第三方jar包版本号。

#### 三、编码规范

1. 关于实体命名规范，我们统一约定如下：

   - 控制层（Controller）请求实体以 Request 为后缀（例如：AddExampleRequest），定义在 api 模块中
   - 控制层（Controller）返回实体以 Response 为后缀（例如：AddExampleResponse），定义在 api 模块中
   - 控制层（Controller）与 服务层（Service）交互请求实体以 Param 为后缀（例如：AddExampleParam），定义在 service 模块中
   - 控制层（Controller）与 服务层（Service）交互返回实体以 Bo 为后缀（例如：ExamplePageBo），定义在 service 模块中

2. 关于 properties 或 yml 配置文件中属性值的注入方式，尽量减少使用 @Value 随处注入，我们推荐如下的注入方式且对 IDEA 开发工具友好

    ```java
    @Data
    @Component("tokenConfig")
    @ConfigurationProperties(prefix = TokenConfig.TOKEN_CONFIG_PREFIX)
    public class TokenConfig {
    
        static final String TOKEN_CONFIG_PREFIX = "token.config";
    
        /**
         * 请求头中令牌的Key
         */
        private String headerTokenKey;
    
        /**
         * 令牌过期时间
         */
        private String expiration;
    
    }
    ```

3. 关于 java 文件头注释，鉴于之前部分工程自由度过高，引起 IDEA 对 java 文件头注释报警告，所以这里推荐大家参考如下的文件头注释内容

    ```java
    /**
     * 查询示例响应结果
     *
     * @author Shangxp
     * @version 1.0.0
     * @since 2020/4/20 21:01
     */
    ```

4. 关于 api 模块 jar 包引入，请你在引入时思考是否对外部系统提供该 jar，一般情况下，我们推荐加入 optional 元素以进行限制，即外部系统如果使用了你提供的 api 模块 jar 包，但是内部依赖的 jar 包是无法向外传递的。这样做的目的是为了尽可能地减少外部系统 jar 包冲突。

    ```xml
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    ```

    > 更多 optional 的官方使用说明，请参考：
    >http://maven.apache.org/guides/introduction/introduction-to-optional-and-excludes-dependencies.html

5. 遵循RESTful规范
   
   - GET，用来浏览(browse)资源
   - POST，用来新建(create)资源
   - PUT，用来更新(update)资源
   - DELETE，用来删除(delete)资源 

#### 四、第三方开源 jar 包版本号清单

> 该清单中的大部分 jar 包及其版本号由 SpringBoot 内置提供，在实际业务项目开发过程中如需引入，不用再单独注明版本号。

```xml
<properties>
    <spring-boot.version>2.2.6.RELEASE</spring-boot.version>
    <spring-cloud.version>Hoxton.SR3</spring-cloud.version>
    <guava.version>20.0</guava.version>
    <commons-io.version>2.6</commons-io.version>
    <commons-collections4.version>4.4</commons-collections4.version>
    <fastjson.version>1.2.62</fastjson.version>
    <mybatis-spring-boot-starter.version>2.1.2</mybatis-spring-boot-starter.version>
    <mapper-spring-boot-starter.version>2.1.5</mapper-spring-boot-starter.version>
    <pagehelper-spring-boot-starter.version>1.2.13</pagehelper-spring-boot-starter.version>
    <activemq.version>5.15.12</activemq.version>
    <antlr2.version>2.7.7</antlr2.version>
    <appengine-sdk.version>1.9.79</appengine-sdk.version>
    <artemis.version>2.10.1</artemis.version>
    <aspectj.version>1.9.5</aspectj.version>
    <assertj.version>3.13.2</assertj.version>
    <atomikos.version>4.0.6</atomikos.version>
    <awaitility.version>4.0.2</awaitility.version>
    <bitronix.version>2.1.4</bitronix.version>
    <build-helper-maven-plugin.version>3.0.0</build-helper-maven-plugin.version>
    <byte-buddy.version>1.10.8</byte-buddy.version>
    <caffeine.version>2.8.1</caffeine.version>
    <cassandra-driver.version>3.7.2</cassandra-driver.version>
    <classmate.version>1.5.1</classmate.version>
    <commons-codec.version>1.13</commons-codec.version>
    <commons-dbcp2.version>2.7.0</commons-dbcp2.version>
    <commons-lang3.version>3.9</commons-lang3.version>
    <commons-pool.version>1.6</commons-pool.version>
    <commons-pool2.version>2.7.0</commons-pool2.version>
    <couchbase-cache-client.version>2.1.0</couchbase-cache-client.version>
    <couchbase-client.version>2.7.13</couchbase-client.version>
    <db2-jdbc.version>11.5.0.0</db2-jdbc.version>
    <dependency-management-plugin.version>1.0.9.RELEASE</dependency-management-plugin.version>
    <derby.version>10.14.2.0</derby.version>
    <dropwizard-metrics.version>4.1.5</dropwizard-metrics.version>
    <ehcache.version>2.10.6</ehcache.version>
    <ehcache3.version>3.8.1</ehcache3.version>
    <elasticsearch.version>6.8.7</elasticsearch.version>
    <embedded-mongo.version>2.2.0</embedded-mongo.version>
    <exec-maven-plugin.version>1.6.0</exec-maven-plugin.version>
    <flatten-maven-plugin.version>1.1.0</flatten-maven-plugin.version>
    <flyway.version>6.0.8</flyway.version>
    <freemarker.version>2.3.30</freemarker.version>
    <git-commit-id-plugin.version>3.0.1</git-commit-id-plugin.version>
    <glassfish-el.version>3.0.3</glassfish-el.version>
    <glassfish-jaxb.version>2.3.2</glassfish-jaxb.version>
    <groovy.version>2.5.10</groovy.version>
    <gson.version>2.8.6</gson.version>
    <h2.version>1.4.200</h2.version>
    <hamcrest.version>2.1</hamcrest.version>
    <hazelcast.version>3.12.6</hazelcast.version>
    <hazelcast-hibernate5.version>1.3.2</hazelcast-hibernate5.version>
    <hibernate.version>5.4.12.Final</hibernate.version>
    <hibernate-validator.version>6.0.18.Final</hibernate-validator.version>
    <hikaricp.version>3.4.2</hikaricp.version>
    <hsqldb.version>2.5.0</hsqldb.version>
    <htmlunit.version>2.36.0</htmlunit.version>
    <httpasyncclient.version>4.1.4</httpasyncclient.version>
    <httpclient.version>4.5.12</httpclient.version>
    <httpcore.version>4.4.13</httpcore.version>
    <infinispan.version>9.4.18.Final</infinispan.version>
    <influxdb-java.version>2.15</influxdb-java.version>
    <jackson.version>2.10.3</jackson.version>
    <jackson-bom.version>${jackson.version}</jackson-bom.version>
    <jakarta-activation.version>1.2.2</jakarta-activation.version>
    <jakarta-annotation.version>1.3.5</jakarta-annotation.version>
    <jakarta-jms.version>2.0.3</jakarta-jms.version>
    <jakarta-json.version>1.1.6</jakarta-json.version>
    <jakarta-json-bind.version>1.0.2</jakarta-json-bind.version>
    <jakarta-mail.version>1.6.5</jakarta-mail.version>
    <jakarta-persistence.version>2.2.3</jakarta-persistence.version>
    <jakarta-servlet.version>4.0.3</jakarta-servlet.version>
    <jakarta-servlet-jsp.version>2.3.5</jakarta-servlet-jsp.version>
    <jakarta-servlet-jsp-jstl.version>1.2.7</jakarta-servlet-jsp-jstl.version>
    <jakarta-transaction.version>1.3.3</jakarta-transaction.version>
    <jakarta-validation.version>2.0.2</jakarta-validation.version>
    <jakarta-websocket.version>1.1.2</jakarta-websocket.version>
    <jakarta-ws-rs.version>2.1.6</jakarta-ws-rs.version>
    <jakarta-xml-bind.version>2.3.3</jakarta-xml-bind.version>
    <jakarta-xml-soap.version>1.4.2</jakarta-xml-soap.version>
    <jakarta-xml-ws.version>2.3.3</jakarta-xml-ws.version>
    <janino.version>3.1.2</janino.version>
    <javax-activation.version>1.2.0</javax-activation.version>
    <javax-annotation.version>1.3.2</javax-annotation.version>
    <javax-cache.version>1.1.1</javax-cache.version>
    <javax-jaxb.version>2.3.1</javax-jaxb.version>
    <javax-jaxws.version>2.3.1</javax-jaxws.version>
    <javax-jms.version>2.0.1</javax-jms.version>
    <javax-json.version>1.1.4</javax-json.version>
    <javax-jsonb.version>1.0</javax-jsonb.version>
    <javax-mail.version>1.6.2</javax-mail.version>
    <javax-money.version>1.0.3</javax-money.version>
    <javax-persistence.version>2.2</javax-persistence.version>
    <javax-transaction.version>1.3</javax-transaction.version>
    <javax-validation.version>2.0.1.Final</javax-validation.version>
    <javax-websocket.version>1.1</javax-websocket.version>
    <jaxen.version>1.2.0</jaxen.version>
    <jaybird.version>3.0.8</jaybird.version>
    <jboss-logging.version>3.4.1.Final</jboss-logging.version>
    <jboss-transaction-spi.version>7.6.0.Final</jboss-transaction-spi.version>
    <jdom2.version>2.0.6</jdom2.version>
    <jedis.version>3.1.0</jedis.version>
    <jersey.version>2.29.1</jersey.version>
    <jest.version>6.3.1</jest.version>
    <jetty.version>9.4.27.v20200227</jetty.version>
    <jetty-el.version>8.5.49</jetty-el.version>
    <jetty-jsp.version>2.2.0.v201112011158</jetty-jsp.version>
    <jetty-reactive-httpclient.version>1.0.3</jetty-reactive-httpclient.version>
    <jmustache.version>1.15</jmustache.version>
    <jna.version>4.5.2</jna.version>
    <joda-time.version>2.10.5</joda-time.version>
    <johnzon.version>${johnzon-jsonb.version}</johnzon.version>
    <johnzon-jsonb.version>1.2.3</johnzon-jsonb.version>
    <jolokia.version>1.6.2</jolokia.version>
    <jooq.version>3.12.4</jooq.version>
    <jsonassert.version>1.5.0</jsonassert.version>
    <json-path.version>2.4.0</json-path.version>
    <jstl.version>1.2</jstl.version>
    <jtds.version>1.3.1</jtds.version>
    <junit.version>4.12</junit.version>
    <junit-jupiter.version>5.5.2</junit-jupiter.version>
    <kafka.version>2.3.1</kafka.version>
    <kotlin.version>1.3.71</kotlin.version>
    <kotlin-coroutines.version>1.3.5</kotlin-coroutines.version>
    <lettuce.version>5.2.2.RELEASE</lettuce.version>
    <liquibase.version>3.8.8</liquibase.version>
    <log4j2.version>2.12.1</log4j2.version>
    <logback.version>1.2.3</logback.version>
    <lombok.version>1.18.12</lombok.version>
    <mariadb.version>2.4.4</mariadb.version>
    <maven-antrun-plugin.version>1.8</maven-antrun-plugin.version>
    <maven-assembly-plugin.version>3.1.1</maven-assembly-plugin.version>
    <maven-clean-plugin.version>3.1.0</maven-clean-plugin.version>
    <maven-compiler-plugin.version>3.8.1</maven-compiler-plugin.version>
    <maven-dependency-plugin.version>3.1.2</maven-dependency-plugin.version>
    <maven-deploy-plugin.version>2.8.2</maven-deploy-plugin.version>
    <maven-enforcer-plugin.version>3.0.0-M3</maven-enforcer-plugin.version>
    <maven-failsafe-plugin.version>2.22.2</maven-failsafe-plugin.version>
    <maven-help-plugin.version>3.2.0</maven-help-plugin.version>
    <maven-install-plugin.version>2.5.2</maven-install-plugin.version>
    <maven-invoker-plugin.version>3.2.1</maven-invoker-plugin.version>
    <maven-jar-plugin.version>3.1.2</maven-jar-plugin.version>
    <maven-javadoc-plugin.version>3.1.1</maven-javadoc-plugin.version>
    <maven-resources-plugin.version>3.1.0</maven-resources-plugin.version>
    <maven-shade-plugin.version>3.2.2</maven-shade-plugin.version>
    <maven-site-plugin.version>3.8.2</maven-site-plugin.version>
    <maven-source-plugin.version>3.1.0</maven-source-plugin.version>
    <maven-surefire-plugin.version>2.22.2</maven-surefire-plugin.version>
    <maven-war-plugin.version>3.2.3</maven-war-plugin.version>
    <micrometer.version>1.3.6</micrometer.version>
    <mimepull.version>1.9.13</mimepull.version>
    <mockito.version>3.1.0</mockito.version>
    <mongodb.version>3.11.2</mongodb.version>
    <mongo-driver-reactivestreams.version>1.12.0</mongo-driver-reactivestreams.version>
    <mssql-jdbc.version>7.4.1.jre8</mssql-jdbc.version>
    <mysql.version>8.0.19</mysql.version>
    <nekohtml.version>1.9.22</nekohtml.version>
    <neo4j-ogm.version>3.2.10</neo4j-ogm.version>
    <netty.version>4.1.48.Final</netty.version>
    <netty-tcnative.version>2.0.30.Final</netty-tcnative.version>
    <nio-multipart-parser.version>1.1.0</nio-multipart-parser.version>
    <ojdbc.version>19.3.0.0</ojdbc.version>
    <okhttp3.version>3.14.7</okhttp3.version>
    <pooled-jms.version>1.0.6</pooled-jms.version>
    <postgresql.version>42.2.11</postgresql.version>
    <prometheus-pushgateway.version>0.7.0</prometheus-pushgateway.version>
    <quartz.version>2.3.2</quartz.version>
    <querydsl.version>4.2.2</querydsl.version>
    <rabbit-amqp-client.version>5.7.3</rabbit-amqp-client.version>
    <reactive-streams.version>1.0.3</reactive-streams.version>
    <reactor-bom.version>Dysprosium-SR6</reactor-bom.version>
    <rest-assured.version>3.3.0</rest-assured.version>
    <rsocket.version>1.0.0-RC6</rsocket.version>
    <rxjava.version>1.3.8</rxjava.version>
    <rxjava2.version>2.2.19</rxjava2.version>
    <rxjava-adapter.version>1.2.1</rxjava-adapter.version>
    <saaj-impl.version>1.5.1</saaj-impl.version>
    <selenium.version>3.141.59</selenium.version>
    <selenium-htmlunit.version>2.36.0</selenium-htmlunit.version>
    <sendgrid.version>4.4.6</sendgrid.version>
    <servlet-api.version>4.0.1</servlet-api.version>
    <slf4j.version>1.7.30</slf4j.version>
    <snakeyaml.version>1.25</snakeyaml.version>
    <solr.version>8.2.0</solr.version>
    <spring-amqp.version>2.2.5.RELEASE</spring-amqp.version>
    <spring-batch.version>4.2.1.RELEASE</spring-batch.version>
    <spring-cloud-connectors.version>2.0.7.RELEASE</spring-cloud-connectors.version>
    <spring-data-releasetrain.version>Moore-SR6</spring-data-releasetrain.version>
    <spring-framework.version>5.2.5.RELEASE</spring-framework.version>
    <spring-hateoas.version>1.0.4.RELEASE</spring-hateoas.version>
    <spring-integration.version>5.2.5.RELEASE</spring-integration.version>
    <spring-kafka.version>2.3.7.RELEASE</spring-kafka.version>
    <spring-ldap.version>2.3.2.RELEASE</spring-ldap.version>
    <spring-restdocs.version>2.0.4.RELEASE</spring-restdocs.version>
    <spring-retry.version>1.2.5.RELEASE</spring-retry.version>
    <spring-security.version>5.2.2.RELEASE</spring-security.version>
    <spring-session-bom.version>Corn-SR2</spring-session-bom.version>
    <spring-ws.version>3.0.8.RELEASE</spring-ws.version>
    <sqlite-jdbc.version>3.28.0</sqlite-jdbc.version>
    <sun-mail.version>${jakarta-mail.version}</sun-mail.version>
    <thymeleaf.version>3.0.11.RELEASE</thymeleaf.version>
    <thymeleaf-extras-data-attribute.version>2.0.1</thymeleaf-extras-data-attribute.version>
    <thymeleaf-extras-java8time.version>3.0.4.RELEASE</thymeleaf-extras-java8time.version>
    <thymeleaf-extras-springsecurity.version>3.0.4.RELEASE</thymeleaf-extras-springsecurity.version>
    <thymeleaf-layout-dialect.version>2.4.1</thymeleaf-layout-dialect.version>
    <tomcat.version>9.0.33</tomcat.version>
    <unboundid-ldapsdk.version>4.0.14</unboundid-ldapsdk.version>
    <undertow.version>2.0.30.Final</undertow.version>
    <versions-maven-plugin.version>2.7</versions-maven-plugin.version>
    <webjars-hal-browser.version>3325375</webjars-hal-browser.version>
    <webjars-locator-core.version>0.41</webjars-locator-core.version>
    <wsdl4j.version>1.6.3</wsdl4j.version>
    <xml-maven-plugin.version>1.0.2</xml-maven-plugin.version>
    <xmlunit2.version>2.6.4</xmlunit2.version>
  </properties>
```

---

##### 创建者：尚晓鹏、伍海超、邓宗政
##### 创建日期：2020-04-20

---
