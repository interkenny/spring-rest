package hello;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Request implements Serializable {

    private String resourceId;
    private List<Map<String, String>> records;


    public List<Map<String, String>> getRecords() {
        return records;
    }

    public void setRecords(List<Map<String, String>> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id='" + resourceId + '\'' +
                ", records=" + records +
                '}';
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }
}
