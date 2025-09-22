// DeleteRecordRequest.java
package com.example.aerospike;

public class DeleteRecordRequest {
    private String key;

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }
}

// DeleteRecordResponse.java
package com.example.aerospike;

public class DeleteRecordResponse {
    private boolean success;

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
}
