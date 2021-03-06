package com.company.yaqinklinikaadminpage.repository;

import com.company.yaqinklinikaadminpage.entity.AdminEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AdminRepository  extends CrudRepository<AdminEntity,Integer> {
    Optional<AdminEntity> findByLogin(String login);
}
