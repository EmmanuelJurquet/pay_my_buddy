package com.pmb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pmb.model.Identification;

@Repository
public interface IdentificationRepository extends CrudRepository<Identification, Integer>{

}
