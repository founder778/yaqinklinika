package com.company.yaqinklinikaadminpage.repository;

import com.company.yaqinklinikaadminpage.entity.AdviceEntity;
import com.company.yaqinklinikaadminpage.entity.AnalizEntity;
import com.company.yaqinklinikaadminpage.entity.CircleEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface CircleRepository extends CrudRepository<CircleEntity,Integer> {
    @Query("select distinct a.a_type from CircleEntity a")
    List<String> findBytabel(String name);
//    Optional<CircleEntity> findByA_name(String name);

    @Query("select a from CircleEntity a where a.a_name=?1")
    List<CircleEntity> getName(String name);

    @Modifying
    @Transactional
    @Query("delete from CircleEntity a where a.a_name=?1")
    void ByNameDelete(String name);
}
