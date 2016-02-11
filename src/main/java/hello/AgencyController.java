package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AgencyController {

    @RequestMapping("/agencies")
    public List<AgencyResource> getAgencies() {

        List<AgencyResource> agencies = getListing();

        return agencies;

    }

    private List<AgencyResource> getListing() {

        List<AgencyResource> resources = new ArrayList<>();
        resources.add(new AgencyResource(1, "All State", "123"));
        resources.add(new AgencyResource(2, "FCCI Insurance Group", "456"));
        resources.add(new AgencyResource(3, "Farmers", "789"));
        resources.add(new AgencyResource(4, "Met life", "167"));

        return resources;
    }
}
