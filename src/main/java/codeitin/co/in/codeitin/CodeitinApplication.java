package codeitin.co.in.codeitin;

import codeitin.co.in.codeitin.Service.BlogService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class CodeitinApplication implements CommandLineRunner {

    @Resource
    BlogService blogService;
	public static void main(String[] args) {
		SpringApplication.run(CodeitinApplication.class, args);
	}

    @Override
    public void run(String... arg) throws Exception {
        blogService.delete();
        blogService.init();
    }

}
