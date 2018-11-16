package name.dnr.bootlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootlabApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootlabApplication.class, args);
        /* *
         * comm 公共的类，如全局的配置文件、工具类等
         * model 于实体（Entity）与数据访问层（Repository）
         * repository 数据库访问层代码
         * service 业务类代码
         * web 页面访问控制（controller）
         */
    }
}
