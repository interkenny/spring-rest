package hello;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class RequestControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;
    private HttpMessageConverter mappingJackson2HttpMessageConverter;
    @Autowired
    private WebApplicationContext webApplicationContext;

    private Request request;
    private List<Map<String,String>> record = new ArrayList<>();
    private Respons respons;

    //サービス
    //@Autowired
    //private TodoService todoServiceMock;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream().filter(
                hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();

        Assert.assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        //DBリターンmock
//        when(todoServiceMock.findAll()).thenReturn(Arrays.asList(first, second));
        Request req = new Request();
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map1 = new HashMap<String,String>();
        map1.put("name","yoshiki");
        map1.put("number","888");
        list.add(map1);
        Map<String,String> map2 = new HashMap<String,String>();
        map2.put("name","tanaka");
        map2.put("number","999");
        list.add(map2);
        req.setResourceId("1");
        req.setRecords(list);
        this.request = req;

    }
    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }

    @Test
    public void testGet() throws Exception {

        String requestJson = json(this.request);
        String jsonUri = URLEncoder.encode(requestJson, "UTF-8");

        System.out.println("はははっは：" + jsonUri);
        this.mockMvc.perform(get("/request?" + jsonUri)
                .contentType(contentType)
                .sessionAttr("request",new Request())
        //        .param("resourceId",this.request.getResourceId())
          //      .param("records", requestJson)
        ).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
}
