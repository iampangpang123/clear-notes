package com.example.clear.notes.biz;

//import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.example.clear.notes.biz.mapper")
//@NacosPropertySource(dataId = "clear-Notes-biz", autoRefreshed = true)
public class ClearNotesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClearNotesServiceApplication.class, args);
    }

}
