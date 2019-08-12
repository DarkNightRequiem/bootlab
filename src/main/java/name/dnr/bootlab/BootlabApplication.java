package name.dnr.bootlab;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootlabApplication {
    /* *
     * ****************bootlab*******************
     *
     * comm 公共的类，如全局的配置文件、工具类等
     * model 于实体（Entity）与数据访问层（Repository）
     * repository 数据库访问层代码
     * service 业务类代码
     * web 页面访问控制（controller）
     */

    public static void main(String[] args) {
        SpringApplication.run(BootlabApplication.class, args);
    }


    /*用于解决上传文件大小超过限制出现连接重置的问题
    * 这种异常连全局异常都捕捉不到
    * */
    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory(){
        TomcatServletWebServerFactory tomcat=new TomcatServletWebServerFactory();
        // 添加连接自定义设置
        tomcat.addConnectorCustomizers(connector -> {
            if(connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>){
                // -1代表无限制
                ((AbstractHttp11Protocol) connector.getProtocolHandler()).setMaxSwallowSize(-1);
            }
        });
        return tomcat;
    }

    /*@RequestParam
用来处理Content-Type: 为 application/x-www-form-urlencoded编码的内容

consumes="application/json"说明这个接口只处理Content-Type="application/json"的请求
headers="Referer=http://www.csdn.com/*"表示request请求头中必须包含Referer=http://www.csdn.com/* produces = "application/json;charset=UTF-8"会与请求头中的Accept进行匹配，如果Accept中也包含application/json，这时才返回数据，如果Accept中没有定义application/json，则服务器端会报错：Could not find acceptable representation 当你有如下Accept头，将遵守如下规则进行应用：

Spring Boot https

Spring Boot 跨域   nginx反向代理实现跨域
MyBatis接口注解

微信小程序的生命周期 静默登录 公私token

@ResultMap的服用和返回类型的问题，将先定义@Results的设置id，然后在别的地方复用。

EsLint代码风格审查
大数据需要使用 redis
数据库模糊查询搜搜过慢优化，使用索引
需求分析没有做好面向用户 市场调研 市场需求--运营 如何吸引算法用户过来
数据库关联查询的效率问题
@RequestParam("FF") @RequestBody*/
}
