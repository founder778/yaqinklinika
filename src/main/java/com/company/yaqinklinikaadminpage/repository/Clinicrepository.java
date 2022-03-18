package com.company.yaqinklinikaadminpage.repository;

import com.company.yaqinklinikaadminpage.entity.ClinicEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Clinicrepository extends CrudRepository<ClinicEntity,Integer> {
    @Query("select c from ClinicEntity c where c.c_name = ?1")
    Optional<ClinicEntity> findByName(String name);





}
