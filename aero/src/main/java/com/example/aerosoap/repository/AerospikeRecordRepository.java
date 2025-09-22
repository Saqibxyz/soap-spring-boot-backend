package com.example.aerosoap.repository;

import com.example.aerosoap.model.AerospikeRecord;
import org.springframework.data.aerospike.repository.AerospikeRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AerospikeRecordRepository extends AerospikeRepository<AerospikeRecord, String> {
}
