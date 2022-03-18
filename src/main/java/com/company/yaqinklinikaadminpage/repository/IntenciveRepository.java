package com.company.yaqinklinikaadminpage.repository;

import com.company.yaqinklinikaadminpage.entity.IntenciveEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IntenciveRepository extends CrudRepository<IntenciveEntity,Integer> {
    @Query("select distinct a.a_type from IntenciveEntity a")
    List<String> findBytabel(String name);


    @Query("select a from IntenciveEntity a where a.a_name=?1")
    List<IntenciveEntity> getName(String name);

    @Modifying
    @Transactional
    @Query("delete from IntenciveEntity a where a.a_name=?1")
    void ByNameDelete(String name);
}
