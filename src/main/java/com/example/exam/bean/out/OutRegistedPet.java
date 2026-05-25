package com.example.exam.bean.out;

import java.time.LocalDateTime;
import java.util.UUID;
/** * Clase de salida para la respuesta de la creación de una mascota registrada.
 */
public class OutRegistedPet {
    private UUID transactionId;
    private LocalDateTime dateCreated;
    private boolean status;
    private String name;

    public OutRegistedPet(UUID transactionId, LocalDateTime dateCreated, boolean status, String name) {
        this.transactionId = transactionId;
        this.dateCreated = dateCreated;
        this.status = status;
        this.name = name;
    }

    public OutRegistedPet() {
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
