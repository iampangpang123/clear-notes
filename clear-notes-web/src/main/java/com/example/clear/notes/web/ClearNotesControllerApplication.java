package com.example.clear.notes.web;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NacosPropertySource(dataId = "clear-Notes-web", autoRefreshed = true)
public class ClearNotesControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClearNotesControllerApplication.class, args);
    }

}
