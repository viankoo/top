package com.top;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author guwei
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class TopApplication {
    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(TopApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ 牛逼啊 后台启动成功 开始拯救银河系的第一步了  ლ(´ڡ`ლ)ﾞ  ");
    }
}
