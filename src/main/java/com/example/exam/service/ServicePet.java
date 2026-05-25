package com.example.exam.service;

import com.example.exam.bean.out.OutRegistedPet;
import com.example.exam.client.ApiClientPet;
import com.example.exam.entity.Pet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
/** * Servicio para gestionar las operaciones relacionadas con las mascotas (Pet).
 * Proporciona métodos para consultar y crear mascotas utilizando el cliente ApiClientPet.
 */
@Service
public class ServicePet {

    public static final Logger log = LoggerFactory.getLogger(ServicePet.class);
    @Autowired
    ApiClientPet clientPet;

    public Pet consultaPet(Long idPet) {

        Pet out = clientPet.ApiConnectorExternal("/pet/{petId}", idPet);

        log.info("ID : --------  {}", out.getId());
        log.info("NAME : ------ {}", out.getName());
        log.info("STATUS : ------  {}", out.getStatus());


        return out;
    }


    public OutRegistedPet create(Pet in) {

        LocalDateTime dateCreation = LocalDateTime.now();
        UUID iDCreation = UUID.randomUUID();

        Pet outResponse = clientPet.ApiConnectorExternalCreate("/pet", in);

        log.info("ID : --------  {}", outResponse.getId());
        log.info("NAME : ------ {}", outResponse.getName());
        log.info("STATUS : ------  {}", outResponse.getStatus());

        OutRegistedPet outRegistedPet = new OutRegistedPet(iDCreation, dateCreation, true, outResponse.getName());


        return outRegistedPet;
    }


}
