package cn.monksfish.happypush;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import javax.xml.crypto.Data;

@SpringBootApplication
public class HappypushApplication {

    public static void main(String[] args) {
        SpringApplication.run(HappypushApplication.class, args);
    }

}
