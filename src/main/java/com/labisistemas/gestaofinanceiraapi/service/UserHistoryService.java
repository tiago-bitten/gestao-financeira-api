package com.labisistemas.gestaofinanceiraapi.service;

import com.labisistemas.gestaofinanceiraapi.enums.ChangeType;
import com.labisistemas.gestaofinanceiraapi.model.User;
import com.labisistemas.gestaofinanceiraapi.model.UserHistory;
import com.labisistemas.gestaofinanceiraapi.repository.UserHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserHistoryService {

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    public void insert(User user) {
        UserHistory userHistory = new UserHistory(user.getName(), user.getEmail(), user.getPassword(), ChangeType.INSERT, user);
        userHistoryRepository.save(userHistory);
    }

    public void update(User user) {
        UserHistory userHistory = new UserHistory(user.getName(), user.getEmail(), user.getPassword(), ChangeType.UPDATE, user);
        userHistoryRepository.save(userHistory);
    }
}
