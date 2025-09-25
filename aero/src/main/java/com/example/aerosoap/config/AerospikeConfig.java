package com.example.aerosoap.config;

import com.aerospike.client.Host;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.aerospike.config.AbstractAerospikeDataConfiguration;
import org.springframework.ws.config.annotation.EnableWs;

import java.util.Collection;
import java.util.Collections;
@EnableWs
@Configuration
public class AerospikeConfig extends AbstractAerospikeDataConfiguration {

    @Override
    protected Collection<Host> getHosts() {
        // configure Aerospike cluster hosts
        return Collections.singleton(new Host("127.0.0.1", 3000));
    }

    @Override
    protected String nameSpace() {
        return "test";  // your namespace
    }
}
