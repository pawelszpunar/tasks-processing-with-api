package com.pawel.restapi.taskprocessing.enums;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TasksContainer {

    private HashMap<Integer, MyThread> container;

    public TasksContainer() {
        container = new HashMap<>();
    }

    public HashMap<Integer, MyThread> getContainer() {
        return container;
    }

    public void setContainer(HashMap<Integer, MyThread> container) {
        this.container = container;
    }

    public void putThread(MyThread myThread) {
        container.put(myThread.getId(), myThread);
    }

    public MyThread getThreadById(int id) {
        return container.get(id);
    }


}
