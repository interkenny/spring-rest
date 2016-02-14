package hello;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Respons implements Serializable {
    private static final long serialVersionUID = 7247714666080613254L;
    private String code;
    private String message;
    private List<Map<String,String>> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Map<String, String>> getData() {
        return data;
    }

    public void setData(List<Map<String, String>> data) {
        this.data = data;
    }
}
