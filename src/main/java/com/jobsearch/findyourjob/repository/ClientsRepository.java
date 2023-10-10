package com.jobsearch.findyourjob.repository;/*
 * @created by Tom 08/10/2023
 */

import com.jobsearch.findyourjob.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<Client, Long> {

    boolean existsByEmail(String email);
}
