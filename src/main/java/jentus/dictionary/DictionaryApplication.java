package jentus.dictionary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

//https://github.com/skieylion/2021-02-otus-spring-ubahhukob/tree/main/project
//https://github.com/skieylion/dictionary

@SpringBootApplication
@EnableFeignClients
public class DictionaryApplication {

    public static void main(String[] args) {
        ApplicationContext context=SpringApplication.run(DictionaryApplication.class, args);
        //context.getBean(RunnerImpl.class).run();
    }

}
