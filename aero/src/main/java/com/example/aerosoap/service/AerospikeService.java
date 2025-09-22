package com.example.aerosoap.service;

import com.example.aerosoap.model.AerospikeRecord;
import com.example.aerosoap.repository.AerospikeRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class AerospikeService {

    private final AerospikeRecordRepository repository;

    public AerospikeService(AerospikeRecordRepository repository) {
        this.repository = repository;
    }

    public String createRecord(String key, String binName, String value) {
        AerospikeRecord record = new AerospikeRecord();
        record.setKey(key);
        record.setBinName(binName);
        record.setValue(value);
        repository.save(record);
        return "CREATED";
    }

    public String readRecord(String key) {
        return repository.findById(key)
                .map(AerospikeRecord::getValue)
                .orElse("NOT_FOUND");
    }

    public String updateRecord(String key, String binName, String value) {
        AerospikeRecord record = new AerospikeRecord();
        record.setKey(key);
        record.setBinName(binName);
        record.setValue(value);
        repository.save(record);
        return "UPDATED";
    }

    public boolean deleteRecord(String key) {
        if (repository.existsById(key)) {
            repository.deleteById(key);
            return true;
        }
        return false;
    }
}
