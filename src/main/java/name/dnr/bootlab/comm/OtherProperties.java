package name.dnr.bootlab.comm;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:others.properties")
@ConfigurationProperties(prefix = "name.dnr.bootlab")
public class OtherProperties {
    /*将.properties文件的配置项映射为当前类
    * @Component 实例化到Spring容器中，方便在项目中引用
    * @ConfigurationProperties 指定要映射的属性前缀
    * @PropertySource 指定要映射的文件，不配置的话默认是application.properties*/

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    private String author;
    private String application;
}
