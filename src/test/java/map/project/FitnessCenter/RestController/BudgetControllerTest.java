package map.project.FitnessCenter.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import map.project.FitnessCenter.controller.BudgetController;
import map.project.FitnessCenter.service.BudgetService;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.doNothing;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BudgetController.class)
public class BudgetControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BudgetService service;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void get() throws Exception
    {
        String response = "Budget: 30.0 EURO";
        given(service.getBudget()).willReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/budget"))
                .andExpect(status().isOk())
                .andExpect(content().string(response));
    }

    @Test
    void add() throws Exception
    {
        double amount = 10;
        String requestBody = objectMapper.writeValueAsString(amount);
        String response = "Old budget --->   Budget: 30.0 EURO\n" +
                "New budget --->   Budget: 40.0 EURO";
        when(service.getBudget())
                .thenReturn("Budget: 30.0 EURO")  // First call returns 10
                .thenReturn("Budget: 40.0 EURO"); // Second call returns 20
        doNothing().when(service).addMoney(amount);

        mockMvc.perform(MockMvcRequestBuilders.post("/budget/add")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(response));
    }
}
