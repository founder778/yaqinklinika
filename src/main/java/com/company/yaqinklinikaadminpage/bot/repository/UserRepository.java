package com.company.yaqinklinikaadminpage.bot.repository;

import com.company.yaqinklinikaadminpage.bot.entity.BotUsersEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<BotUsersEntity,Integer> {
    @Query("select count(b.userId) from BotUsersEntity b")
    int getAll();
}
