package com.example.aerosoap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;

@SpringBootApplication
@EnableAerospikeRepositories(basePackages = "com.example.aerosoap.repository")
public class AerosoapApplication {
    public static void main(String[] args) {
        SpringApplication.run(AerosoapApplication.class, args);
    }
}
