package com.example.exam.client;


import com.example.exam.bean.Parametria;
import com.example.exam.entity.Pet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

/**
 * Clase cliente para interactuar con la API externa de mascotas.
 *
 * Proporciona métodos para realizar solicitudes GET y POST a la API, manejando las respuestas y errores de manera adecuada.
 */
@Component
public class ApiClientPet {
    public static final Logger log = LoggerFactory.getLogger(ApiClientPet.class);


    private final Parametria val;

    public ApiClientPet(Parametria val) {
        this.val = val;
    }


    private final Pet resEmpty = new Pet();

    public Pet apiConnectorExternal(String path, Long idPet) {


        try {
            WebClient client = WebClient.create(val.getEndPoint());

            Pet response = client.get()
                    .uri(path, idPet)
                    .retrieve()
                    .bodyToMono(Pet.class)
                    .block();

            log.warn("Respuesta OK: {}", response);

            return response;

        } catch (WebClientResponseException e) {
            log.error("Error {}: {}", e.getStatusCode(), e.getResponseBodyAsString());
            return resEmpty;
        }
    }

    public Pet apiConnectorExternalCreate(String path, Pet in) {

        try {
            WebClient client = WebClient.create(val.getEndPoint());


            Pet response = client.post()
                    .uri(path)
                    .bodyValue(in)
                    .retrieve()
                    .bodyToMono(Pet.class)
                    .block();

            log.warn("Respuesta OK: {}", response);

            return response;
        } catch (WebClientResponseException e) {
            log.error("Error {}: {}", e.getStatusCode(), e.getResponseBodyAsString());
            return resEmpty;
        }
    }

}
