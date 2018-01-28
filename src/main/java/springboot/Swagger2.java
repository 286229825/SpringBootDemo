package springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/** Swagger2的配置类，需要放在StudySpringBoot1Application.java的同级目录下
 *  通过@Configuration注解让spring来加载当前配置类；通过@EnableSwagger2来启用Swagger2
 * @author Administrator
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
    	//添加header参数
    	ParameterBuilder tokenPar = new ParameterBuilder();  
        List<Parameter> pars = new ArrayList<Parameter>();
        //添加Content-Type参数，并设默认值为application/json
        Parameter param1 = tokenPar.name("Content-Type").description("请求内容类型").modelRef(new ModelRef("string")).parameterType("header").defaultValue("application/json").required(true).build();
        //添加Accept参数，并设默认值为application/json
        Parameter param2 = tokenPar.name("Accept").description("接收内容类型").modelRef(new ModelRef("string")).parameterType("header").defaultValue("application/json").required(true).build();
        pars.add(param1);
        pars.add(param2);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("springboot.controller"))  //定义需要扫描的包名
                .paths(PathSelectors.any())
                .build()
		        .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")  //标题
                .description("Spring Boot中使用Swagger2构建RESTful APIs的描述")  //描述
                .termsOfServiceUrl("http://blog.didispace.com/") 
                .contact("xiaowu")  //作者
                .version("1.0")  //版本号
                .build();
    }
}
