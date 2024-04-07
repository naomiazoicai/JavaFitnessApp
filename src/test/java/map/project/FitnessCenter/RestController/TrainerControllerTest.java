package map.project.FitnessCenter.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import map.project.FitnessCenter.controller.TrainerController;
import map.project.FitnessCenter.data.model.Trainer;
import map.project.FitnessCenter.data.model.enums.Gender;
import map.project.FitnessCenter.data.model.enums.TrainerSpecialisation;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import map.project.FitnessCenter.service.TrainerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TrainerController.class)
public class TrainerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TrainerService service;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void add() throws Exception {
        Trainer testTrainer = new Trainer("ion", "ion", null, Gender.male, 0, TrainerSpecialisation.none);
        String requestBody = objectMapper.writeValueAsString(testTrainer);

        given(service.add(testTrainer)).willReturn(Optional.of(testTrainer));

        mockMvc.perform(MockMvcRequestBuilders.post("/trainer")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.username").value(testTrainer.getUsername()));
    }

    @Test
    void getById() throws Exception {
        Trainer testTrainer = new Trainer("ion", "ion", null, Gender.male, 0, TrainerSpecialisation.none);
        given(service.getEntityByKey(testTrainer.getUsername())).willReturn(Optional.of(testTrainer));

        mockMvc.perform(get("/trainer/" + testTrainer.getUsername()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value(testTrainer.getUsername()));

    }
}
