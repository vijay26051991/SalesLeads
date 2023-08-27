package org.assessment.salesleads.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assessment.salesleads.model.LeadsRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LeadsControllerTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Test
    public void happyPath() throws Exception {
        String uri = "/leads/publish";

        LeadsRequest leadsRequest
                = new LeadsRequest(12345, "landing page", "Fazil", "", "abc@hidubai.com", "SMS", "I'm interested in chocolate flavoured cake of 3kg");
        String inputJson = mapToJson(leadsRequest);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void testLeadIdMissing() throws Exception {
        String uri = "/leads/publish";

        LeadsRequest leadsRequest
                = new LeadsRequest(null, "landing page", "Fazil", "", "abc@hidubai.com", "SMS", "I'm interested in chocolate flavoured cake of 3kg");
        String inputJson = mapToJson(leadsRequest);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        assertEquals(true, response.contains("Leads ID is missing"));
    }

    @Test
    public void testMobileNumberOrEmailExists() throws Exception {
        String uri = "/leads/publish";

        LeadsRequest leadsRequest
                = new LeadsRequest(12345, "landing page", "Fazil", null, null, "SMS", "I'm interested in chocolate flavoured cake of 3kg");
        String inputJson = mapToJson(leadsRequest);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
        assertEquals(true, response.contains("Email or Mobile must be present"));
    }

    @Test
    public void testInValidEmailFormat() throws Exception {
        String uri = "/leads/publish";

        LeadsRequest leadsRequest
                = new LeadsRequest(12345, "landing page", "Fazil", null, "abc.com", "SMS", "I'm interested in chocolate flavoured cake of 3kg");
        String inputJson = mapToJson(leadsRequest);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
        assertEquals(true, response.contains("The email ID must be in the proper format"));
    }

    @Test
    public void testInvalidCommunicationMode() throws Exception {
        String uri = "/leads/publish";

        LeadsRequest leadsRequest
                = new LeadsRequest(12345, "landing page", "Fazil", null, "abc@hidubai.com", "SMS1", "I'm interested in chocolate flavoured cake of 3kg");
        String inputJson = mapToJson(leadsRequest);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
        assertEquals(true, response.contains("Invalid mobile communication mode"));
    }

    @Test
    public void testMessageLength() throws Exception {
        String uri = "/leads/publish";

        LeadsRequest leadsRequest
                = new LeadsRequest(12345, "landing page", "Fazil", null, "abc@hidubai.com", "SMS", "I'm");
        String inputJson = mapToJson(leadsRequest);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
        assertEquals(true, response.contains("Message must be 10 characters atleast"));
    }

    @Test
    public void testMobileFormat() throws Exception {
        String uri = "/leads/publish";

        LeadsRequest leadsRequest
                = new LeadsRequest(12345, "landing page", "Fazil", "+971 561112222", "abc@hidubai.com", "SMS", "I'm interested");
        String inputJson = mapToJson(leadsRequest);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
//        assertEquals(true, response.contains("The mobile phone number must be in the international format"));
    }

    private String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
}
