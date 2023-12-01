package com.labisistemas.gestaofinanceiraapi.controller;

import com.labisistemas.gestaofinanceiraapi.dto.ReadUserHistoriesDto;
import com.labisistemas.gestaofinanceiraapi.service.UserHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user-histories")
public class UserHistoryController {

    @Autowired
    private UserHistoryService userHistoryService;

    @GetMapping
    public ResponseEntity<Page<ReadUserHistoriesDto>> findAll(@RequestParam(required = false) String filter,
                                                              @RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "10") int size) {

        Page<ReadUserHistoriesDto> userHistories = userHistoryService.findAll(filter, PageRequest.of(page, size));
        return new ResponseEntity<>(userHistories, HttpStatus.OK);
    }
}
