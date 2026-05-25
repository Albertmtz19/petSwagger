package com.example.exam.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * Clase de configuración para cargar parámetros desde el archivo de propiedades.
 *
 *  Permite acceder a los valores configurados en application.properties, como la URL del endpoint de la API de mascotas.
 */
@Component
public class Parametria {
    @Value("${api.pet.url}")
    private String endPoint;


    public String getEndPoint() {
        return endPoint;
    }
}
