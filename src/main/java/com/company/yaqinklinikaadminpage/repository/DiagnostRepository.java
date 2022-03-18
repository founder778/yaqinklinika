package com.company.yaqinklinikaadminpage.repository;

import com.company.yaqinklinikaadminpage.entity.AdviceEntity;
import com.company.yaqinklinikaadminpage.entity.CircleEntity;
import com.company.yaqinklinikaadminpage.entity.DiagnostEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface DiagnostRepository extends CrudRepository<DiagnostEntity,Integer> {
    @Query("select distinct a.a_type from DiagnostEntity a")
    List<String> findBytabel(String name);
//    Optional<AdviceEntity> findByA_name(String name);

    @Query("select a from DiagnostEntity a where a.a_name=?1")
    List<DiagnostEntity> getName(String name);

    @Modifying
    @Transactional
    @Query("delete from DiagnostEntity a where a.a_name=?1")
    void ByNameDelete(String name);
}
