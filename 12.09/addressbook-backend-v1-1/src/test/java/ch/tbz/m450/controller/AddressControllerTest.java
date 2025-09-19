package ch.tbz.m450.controller;

import ch.tbz.m450.repository.Address;
import ch.tbz.m450.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AddressController.class)
class AddressControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AddressService service;

    @Test
    void getAddressesReturns200AndJson() throws Exception {
        when(service.getAll()).thenReturn(List.of(
                new Address(1, "A", "Zed", "000", new Date()),
                new Address(2, "B", "Yen", "111", new Date())
        ));

        mvc.perform(get("/address").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void getAddressById() throws Exception {
        when(service.getAddress(5)).thenReturn(Optional.of(new Address(5, "Luca", "B", "079", new Date())));

        mvc.perform(get("/address/5").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getAddressByIdNotFound() throws Exception {
        when(service.getAddress(999)).thenReturn(Optional.empty());

        mvc.perform(get("/address/999").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
