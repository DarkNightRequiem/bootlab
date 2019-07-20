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
}
