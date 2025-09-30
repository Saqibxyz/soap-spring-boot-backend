package com.example.aerosoap.endpoint;

import com.example.aerospike.CreateRecordRequest;
import com.example.aerospike.CreateRecordResponse;
import com.example.aerospike.ReadRecordRequest;
import com.example.aerospike.ReadRecordResponse;
import com.example.aerospike.UpdateRecordRequest;
import com.example.aerospike.UpdateRecordResponse;
import com.example.aerospike.DeleteRecordRequest;
import com.example.aerospike.DeleteRecordResponse;
import com.example.aerosoap.service.AerospikeService;
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

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "readRecordRequest")
    @ResponsePayload
    public ReadRecordResponse read(@RequestPayload ReadRecordRequest request) {
        String value = service.readRecord(request.getKey());
        ReadRecordResponse response = new ReadRecordResponse();
        response.setValue(value);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateRecordRequest")
    @ResponsePayload
    public UpdateRecordResponse update(@RequestPayload UpdateRecordRequest request) {
        String status = service.updateRecord(request.getKey(), request.getBinName(), request.getValue());
        UpdateRecordResponse response = new UpdateRecordResponse();
        response.setStatus(status);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteRecordRequest")
    @ResponsePayload
    public DeleteRecordResponse delete(@RequestPayload DeleteRecordRequest request) {
        boolean success = service.deleteRecord(request.getKey());
        DeleteRecordResponse response = new DeleteRecordResponse();
        response.setSuccess(success);
        return response;
    }
}
