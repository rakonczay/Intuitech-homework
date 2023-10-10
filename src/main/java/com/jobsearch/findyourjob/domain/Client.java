package com.jobsearch.findyourjob.domain;/*
 * @created by Tom 08/10/2023
 */

import com.jobsearch.findyourjob.domain.dto.ClientFormData;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.UUID;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Email
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "apiKey")
    private String apiKey;

    public Client() {
    }

    public Client(String name, String email, String apiKey) {
        this.name = name;
        this.email = email;
        this.apiKey = apiKey;
    }

    public Client(ClientFormData clientFormData) {
        this.name = clientFormData.getName();
        this.email = clientFormData.getEmail();
        this.apiKey = generateCode();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    private String generateCode() {
        return UUID.randomUUID().toString();
    }
}
