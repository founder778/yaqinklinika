package com.company.yaqinklinikaadminpage.repository;

import com.company.yaqinklinikaadminpage.entity.AdviceEntity;
import com.company.yaqinklinikaadminpage.entity.AnalizEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface AnalizRepository extends CrudRepository<AnalizEntity,Integer> {
    @Query("select distinct a.a_type from AnalizEntity a")
    List<String> findBytabel(String name);


    @Query("select a from AnalizEntity a where a.a_name=?1")
    List<AnalizEntity> getName(String name);

    @Modifying
    @Transactional
    @Query("delete from AnalizEntity a where a.a_name=?1")
    void ByNameDelete(String name);
}
