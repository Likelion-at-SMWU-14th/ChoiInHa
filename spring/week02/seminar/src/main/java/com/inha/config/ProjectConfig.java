package com.inha.config;

import com.inha.bean.Lion;
import com.inha.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.inha.proxy",
        "com.inha.service",
        "com.inha.repository"
})
public class ProjectConfig {
    @Bean
    public Lion lion() {
        Lion lion = new Lion();
        lion.setName("inha");
        return lion;
    }

    @Bean
    public Person person(Lion lion) {
        Person person = new Person(lion);
        person.setName("inha");
        return person;
    }
}
