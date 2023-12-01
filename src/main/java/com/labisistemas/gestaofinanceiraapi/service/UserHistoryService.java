package com.labisistemas.gestaofinanceiraapi.service;

import com.labisistemas.gestaofinanceiraapi.dto.ReadUserHistoriesDto;
import com.labisistemas.gestaofinanceiraapi.enums.ChangeType;
import com.labisistemas.gestaofinanceiraapi.model.User;
import com.labisistemas.gestaofinanceiraapi.model.UserHistory;
import com.labisistemas.gestaofinanceiraapi.repository.UserHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserHistoryService {

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    public void log(User user, ChangeType changeType) {
        UserHistory userHistory = new UserHistory(user.getName(), user.getEmail(), user.getPassword(), changeType, user);
        userHistoryRepository.save(userHistory);
    }

    public Page<ReadUserHistoriesDto> findAll(String filter, Pageable pageable) {
        Page<UserHistory> userHistories = userHistoryRepository.findAll(filter, UserHistory.class, pageable);
        return userHistories.map(userHistory -> new ReadUserHistoriesDto(userHistory.getId(), userHistory.getName(), userHistory.getEmail(), userHistory.getUser().getId(), userHistory.getChangeType(), userHistory.getChangedAt()));
    }
}
