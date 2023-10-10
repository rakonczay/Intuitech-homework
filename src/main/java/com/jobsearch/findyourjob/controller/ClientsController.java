package com.jobsearch.findyourjob.controller;/*
 * @created by Tom 08/10/2023
 */

import com.jobsearch.findyourjob.domain.dto.ClientFormData;
import com.jobsearch.findyourjob.domain.dto.ResponseApiKey;
import com.jobsearch.findyourjob.service.ClientsService;
import com.jobsearch.findyourjob.validator.ClientsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api")
public class ClientsController {

    private final ClientsValidator clientsValidator;
    private final ClientsService clientsService;

    @Autowired
    public ClientsController(ClientsValidator clientsValidator, ClientsService clientsService) {
        this.clientsValidator = clientsValidator;
        this.clientsService = clientsService;
    }

    @InitBinder(value = "clientFormData")
    protected void initBinderClientFormData(WebDataBinder binder) {
        binder.addValidators(clientsValidator);
    }

    @PostMapping("/clients")

    public ResponseEntity<?> registerClient(@RequestBody @Valid ClientFormData clientFormData) {
        ResponseApiKey apiKey = clientsService.registerClient(clientFormData);
        return (apiKey != null) ?
                ResponseEntity.status(HttpStatus.CREATED).body(apiKey) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
