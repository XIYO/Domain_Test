package com.example.domaintest;

import com.example.domaintest.domain.entity.Feed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;

@SpringBootApplication
public class DomaintestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DomaintestApplication.class, args);
    }

}
