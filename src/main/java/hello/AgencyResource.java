package hello;

public class AgencyResource {

    private Integer id;
    private String name;
    private String EIN;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEIN() {
        return EIN;
    }

    public void setEIN(String EIN) {
        this.EIN = EIN;
    }

    public AgencyResource(Integer id, String name, String eIN) {
        super();
        this.id = id;
        this.name = name;
        EIN = eIN;
    }
}
