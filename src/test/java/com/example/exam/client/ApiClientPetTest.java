package com.example.exam.client;

import com.example.exam.bean.Parametria;
import com.example.exam.entity.Pet;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

public class ApiClientPetTest {

    private Pet testPet = new Pet(1L, "Firulais", "available");

    @Test
    void testApiConnectorExternal() {

        WebClient mockClient = Mockito.mock(WebClient.class, Mockito.RETURNS_DEEP_STUBS);

        Mockito.when(mockClient.get()
                        .uri("/pet/{id}", 1L)
                        .retrieve()
                        .bodyToMono(Pet.class))
                .thenReturn(Mono.just(testPet));


        assertNotNull(testPet);
        assertEquals("Firulais", testPet.getName());


    }


    @Test
    void testApiConnectorExternalCreate() {

        WebClient mockClient = Mockito.mock(WebClient.class, Mockito.RETURNS_DEEP_STUBS);

        Mockito.when(mockClient.post()
                        .uri("/pet")
                        .bodyValue(Mockito.any(Pet.class))
                        .retrieve()
                        .bodyToMono(Pet.class))
                .thenReturn(Mono.just(testPet));

        Parametria mockParametria = Mockito.mock(Parametria.class);
        Mockito.when(mockParametria.getEndPoint()).thenReturn("http://prueba-api");

        Pet response = testPet;
        assertNotNull(response);
        assertEquals("Firulais", response.getName());

    }
}
