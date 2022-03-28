package Application;
 
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
/**
 * Hello world!
 *
 */
@MapperScan(value = {"cn.vrgv.dao"})
@SpringBootApplication(scanBasePackages="cn.vrgv.controller")
public class SpringBootApplicationFirst {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplicationFirst.class, args);
	}
}