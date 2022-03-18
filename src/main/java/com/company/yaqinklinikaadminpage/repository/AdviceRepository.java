package com.company.yaqinklinikaadminpage.repository;

import com.company.yaqinklinikaadminpage.entity.AdviceEntity;
import com.company.yaqinklinikaadminpage.entity.IntenciveEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface AdviceRepository extends CrudRepository<AdviceEntity, Integer> {
    @Query("select a from AdviceEntity a where a.a_name=?1")
    List<AdviceEntity> getName(String name);

    @Modifying
    @Transactional
    @Query("delete from AdviceEntity a where a.a_name=?1")
    void ByNameDelete(String name);


}
