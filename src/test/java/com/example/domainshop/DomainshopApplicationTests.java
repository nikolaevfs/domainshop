package com.example.domainshop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DomainshopApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testExisting() throws Exception {

        this.mockMvc.perform(get("/domains/available?name=existing"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].tld").value("com"))
                .andExpect(jsonPath("$[0].price").value(8.99))
                .andExpect(jsonPath("$[0].available").value(false))
                .andExpect(jsonPath("$[1].tld").value("net"))
                .andExpect(jsonPath("$[1].price").value(9.99))
                .andExpect(jsonPath("$[1].available").value(true))
                .andExpect(jsonPath("$[2].tld").value("club"))
                .andExpect(jsonPath("$[2].price").value(15.99))
                .andExpect(jsonPath("$[2].available").value(true));
    }

    @Test
    public void testNotExisting() throws Exception {

        this.mockMvc.perform(get("/domains/available?name=new"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].tld").value("com"))
                .andExpect(jsonPath("$[0].price").value(8.99))
                .andExpect(jsonPath("$[0].available").value(true))
                .andExpect(jsonPath("$[1].tld").value("net"))
                .andExpect(jsonPath("$[1].price").value(9.99))
                .andExpect(jsonPath("$[1].available").value(true))
                .andExpect(jsonPath("$[2].tld").value("club"))
                .andExpect(jsonPath("$[2].price").value(15.99))
                .andExpect(jsonPath("$[2].available").value(true));
    }

    @Test
    public void testFullyNotExisting() throws Exception {

        this.mockMvc.perform(get("/domains/available?name=fullbusy"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].tld").value("com"))
                .andExpect(jsonPath("$[0].price").value(8.99))
                .andExpect(jsonPath("$[0].available").value(false))
                .andExpect(jsonPath("$[1].tld").value("net"))
                .andExpect(jsonPath("$[1].price").value(9.99))
                .andExpect(jsonPath("$[1].available").value(false))
                .andExpect(jsonPath("$[2].tld").value("club"))
                .andExpect(jsonPath("$[2].price").value(15.99))
                .andExpect(jsonPath("$[2].available").value(false));
    }
}
