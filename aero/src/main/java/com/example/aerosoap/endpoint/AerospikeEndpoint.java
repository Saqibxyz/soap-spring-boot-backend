package com.example.aerosoap.endpoint;

import com.example.aerosoap.service.AerospikeService;
import com.example.aerospike.CreateRecordRequest;
import com.example.aerospike.CreateRecordResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AerospikeEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/aerospike";

    private final AerospikeService service;

    public AerospikeEndpoint(AerospikeService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createRecordRequest")
    @ResponsePayload
    public CreateRecordResponse create(@RequestPayload CreateRecordRequest request) {
        String status = service.createRecord(request.getKey(), request.getBinName(), request.getValue());
        CreateRecordResponse response = new CreateRecordResponse();
        response.setStatus(status);
        return response;
    }
}
