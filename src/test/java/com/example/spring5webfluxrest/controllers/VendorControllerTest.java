package com.example.spring5webfluxrest.controllers;

import com.example.spring5webfluxrest.domain.Vendor;
import com.example.spring5webfluxrest.repositories.VendorRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

@Ignore
public class VendorControllerTest {

    private WebTestClient webTestClient;
    @Mock
    private VendorRepository vendorRepository;
    @InjectMocks
    private VendorController vendorController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        webTestClient = WebTestClient.bindToController(vendorController).build();
    }

    @Test
    public void getAllVendors() throws Exception {
        BDDMockito.given(vendorRepository.findAll()).willReturn(Flux.just(Vendor.builder().firstName("John").lastName("Doe").build()));
        webTestClient.get().uri("api/v1/vendors")
                .exchange()
                .expectBodyList(Vendor.class)
                .hasSize(1);

    }

    @Test
    public void getVendorById() {
    }
}