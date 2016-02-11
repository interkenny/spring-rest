package hello;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Request implements Serializable {
  private String id;
    private List<Map<String,String>> records;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Map<String, String>> getRecords() {
        return records;
    }

    public void setRecords(List<Map<String, String>> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id='" + id + '\'' +
                ", records=" + records +
                '}';
    }
}
