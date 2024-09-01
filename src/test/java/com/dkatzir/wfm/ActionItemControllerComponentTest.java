package com.dkatzir.wfm;

import com.dkatzir.wfm.controllers.ActionItemController;
import com.dkatzir.wfm.models.ActionItemRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ActionItemController.class)
class ActionItemControllerComponentTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateActionItem() throws Exception {
        ActionItemRequest actionItemRequest = new ActionItemRequest();
        actionItemRequest.setName("Webinar on AI");
        actionItemRequest.setDueDate(LocalDate.of(2025, 3, 15));
        actionItemRequest.setDueTime(LocalTime.of(10, 0));

        mockMvc.perform(post("/api/action-item")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(actionItemRequest)))
                .andExpect(status().isCreated());

        MvcResult getResult = mockMvc.perform(get("/api/action-item/1"))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(deserializeActionItem(getResult)).usingRecursiveComparison().isEqualTo(actionItemRequest);
    }

    private ActionItemRequest deserializeActionItem(MvcResult getResult) throws JsonProcessingException, UnsupportedEncodingException {
        return objectMapper.readValue(getResult.getResponse().getContentAsString(), ActionItemRequest.class);
    }


    // Add similar tests for other item types

    private String asJsonString(final Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
