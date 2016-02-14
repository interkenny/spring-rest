package hello;


import org.springframework.stereotype.Service;

@Service
public interface RequestService {

    String save(Request request);
}
