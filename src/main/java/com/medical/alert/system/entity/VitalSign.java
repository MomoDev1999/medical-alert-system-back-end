package com.medical.alert.system.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VitalSign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    private String type; // e.g., Heart Rate
    private Double value;
    private LocalDateTime timestamp;

    // Default Constructor
    public VitalSign() {
    }

    // Constructor with Fields
    public VitalSign(Patient patient, String type, Double value, LocalDateTime timestamp) {
        this.patient = patient;
        this.type = type;
        this.value = value;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // toString
    @Override
    public String toString() {
        return "VitalSign{" +
                "id=" + id +
                ", patient=" + (patient != null ? patient.getId() : null) + // Avoid recursion in toString
                ", type='" + type + '\'' +
                ", value=" + value +
                ", timestamp=" + timestamp +
                '}';
    }
}
