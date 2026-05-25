package com.example.exam.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
/** * Clase de utilidad para generar respuestas HTTP de manera consistente.
 */
public class Util {

    public ResponseEntity<Object> generatedResponse(HttpStatus status, String messages, Object response) {
        HashMap<String, Object> res = new HashMap<>();
        res.put("data", response);
        res.put("messages", messages);
        res.put("status", status.value());
        return ResponseEntity.status(status).body(res);
    }
}
