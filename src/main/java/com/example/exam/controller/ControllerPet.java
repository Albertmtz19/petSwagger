package com.example.exam.controller;

import com.example.exam.bean.out.OutRegistedPet;
import com.example.exam.entity.Pet;
import com.example.exam.service.ServicePet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/** * Controlador REST para gestionar las operaciones relacionadas con las mascotas (Pet).
 * Proporciona endpoints para consultar y crear mascotas utilizando el servicio ServicePet.
 */
@RestController
@RequestMapping("api/pet")
public class ControllerPet {

    @Autowired
    ServicePet servicePet;


    @GetMapping("{idPet}")
    public Pet getPet(@PathVariable Long idPet) {
        return servicePet.consultaPet(idPet);
    }

    @PostMapping
    public OutRegistedPet create(@RequestBody Pet in) {
        return servicePet.create(in);
    }

}
