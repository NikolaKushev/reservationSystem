package com.example.demo.controller;

import com.example.demo.dto.PassengerDTO;
import com.example.demo.service.PassengerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PassengerController.class)
class PassengerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PassengerService passengerService;


    @Test
    public void testGetAllPassengers() throws Exception {

        //given
        PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.setFirstName("nikola");
        passengerDTO.setLastName("kushev");

        PassengerDTO passengerDTO1 = new PassengerDTO();
        passengerDTO.setFirstName("ivan");
        passengerDTO1.setLastName("ivanov");

        List<PassengerDTO> passengerDTOS = List.of(passengerDTO, passengerDTO1);

        //when
        when(passengerService.getAllPassengers()).thenReturn(passengerDTOS);

//        //then
//        mockMvc.perform(MockMvcRequestBuilders.get("/passengers"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$[0].firstName", is("nikola")))
//                .andExpect(jsonPath("$[0].lastName", is("kushev")))
//                .andExpect(jsonPath("$[1].firstName", is("ivan")))
//                .andExpect(jsonPath("$[1].lastName", is("ivanov")));

    }

}