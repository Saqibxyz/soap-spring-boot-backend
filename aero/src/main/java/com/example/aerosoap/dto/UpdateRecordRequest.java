package com.example.aerosoap.dto;

public class UpdateRecordRequest {
    private String key;
    private String binName;
    private String value;

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public String getBinName() { return binName; }
    public void setBinName(String binName) { this.binName = binName; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}