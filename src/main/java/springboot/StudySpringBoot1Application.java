package springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 当前类是SpringBoot的入口类，启动当前类的main方法即可启动SpringBoot，它会自动启动其内置的服务器（默认为 Tomcat）
 * @SpringBootApplication 是一个SpringBoot项目的启动注解，也是一个组合注解，它包含了以下几个有用的注解以及它们的功能：
 * 		@SpringBootConfiguration：用于标明当前类是一个配置类，就像xml配置文件，而现在是用java代码来配置，效果是一样的；
 * 		@EnableAutoConfiguration：用于将spring的  @Enable* 系列注解全部包含进来而无需开发者显式声明，其中就包括了用于开启事务的注解；
 * 		@ComponentScan：用于实现自动扫描注解（包括@Controller、@RestController、@Service等等一系列的Spring注解），默认会扫描当前包和所有子包，和 xml 配置自动扫描效果一样；
 * 		@Filter：用于排除两个系统类。
 * 
 * @author Administrator
 *
 */
@SpringBootApplication
@MapperScan(value="springboot.mapper")  //开启扫描 mapper 包
public class StudySpringBoot1Application {
	public static void main(String[] args) {
		SpringApplication.run(StudySpringBoot1Application.class, args);
	}
}
