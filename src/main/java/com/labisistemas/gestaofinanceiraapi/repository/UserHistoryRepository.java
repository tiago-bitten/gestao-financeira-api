package com.labisistemas.gestaofinanceiraapi.repository;

import com.labisistemas.gestaofinanceiraapi.enterprise.CustomQuerydslPredicateExecutor;
import com.labisistemas.gestaofinanceiraapi.model.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long>, CustomQuerydslPredicateExecutor<UserHistory> {
}
