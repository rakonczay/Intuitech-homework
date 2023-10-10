package com.jobsearch.findyourjob.repository;/*
 * @created by Tom 08/10/2023
 */

import com.jobsearch.findyourjob.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionsRepository extends JpaRepository<Position, Long> {

}
