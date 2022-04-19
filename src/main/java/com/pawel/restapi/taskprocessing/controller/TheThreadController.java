package com.pawel.restapi.taskprocessing.controller;

import com.pawel.restapi.taskprocessing.enums.InputData;
import com.pawel.restapi.taskprocessing.enums.MyThread;
import com.pawel.restapi.taskprocessing.service.MyThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class TheThreadController {

    @Autowired
    private MyThreadService myThreadService;

    @PostMapping("/tasks")
    public ResponseEntity<Map<String, Object>> setNewThread(@Valid @RequestBody InputData inputData) {
        return new ResponseEntity(myThreadService.
                mapThreadIdToHashMap(myThreadService.startNewThread(inputData)), HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Map<String, Object>> getThread(@PathVariable("id") int id) {
        return new ResponseEntity(myThreadService
                .mapThreadToLinkedHashMap(myThreadService.getThread(id)), HttpStatus.OK);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<MyThread>> getAllThreads() {
        return new ResponseEntity(myThreadService.getAllThreads(), HttpStatus.OK);
    }

}
