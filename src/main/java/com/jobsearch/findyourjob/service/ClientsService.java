package com.jobsearch.findyourjob.service;/*
 * @created by Tom 08/10/2023
 */

import com.jobsearch.findyourjob.domain.Client;
import com.jobsearch.findyourjob.domain.dto.ClientFormData;
import com.jobsearch.findyourjob.domain.dto.ResponseApiKey;
import com.jobsearch.findyourjob.exception.EmailNotUniqueException;
import com.jobsearch.findyourjob.repository.ClientsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientsService {

    private final Logger logger = LoggerFactory.getLogger(ClientsService.class);

    private final ClientsRepository clientsRepository;

    @Autowired
    public ClientsService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public ResponseApiKey registerClient(ClientFormData clientFormData) {
        if (clientsRepository.existsByEmail(clientFormData.getEmail())) {
            throw new EmailNotUniqueException();
        } else {
            logger.info("Client has ben registered");
            Client client = clientsRepository.save(new Client(clientFormData));
            return new ResponseApiKey(client.getApiKey());
        }
    }

}
