
package com.pawel.restapi.taskprocessing.service;

import com.pawel.restapi.taskprocessing.enums.InputData;
import com.pawel.restapi.taskprocessing.enums.MyThread;
import com.pawel.restapi.taskprocessing.enums.TasksContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class MyThreadService {

    @Qualifier("taskExecutor")
    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private TasksContainer tasksContainer;

    public MyThread startNewThread(InputData inputData) {
        MyThread myThread = new MyThread(inputData.getBase(), inputData.getExponent());
        taskExecutor.execute(myThread);
        tasksContainer.putThread(myThread);
        return myThread;
    }

    public MyThread getThread(int id) {
        return tasksContainer.getThreadById(id);
    }

    public List<LinkedHashMap<String, Object>> getAllThreads() {
        return mapThreadList(tasksContainer.getContainer().values().stream().toList());
    }


    public HashMap<String, Object> mapThreadIdToHashMap(MyThread myThread) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", myThread.getId());
        return map;
    }

    public LinkedHashMap<String, Object> mapThreadToLinkedHashMap(MyThread myThread) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("id", myThread.getId());
        map.put("status", myThread.getStatus());
        map.put("progress", myThread.getProgress() + "%");
        if (myThread.getProgress() == 100) {
            map.put("result", myThread.getResult());
        }
        return map;
    }

    public List<LinkedHashMap<String, Object>> mapThreadList(List<MyThread> myThreadList) {
        List<LinkedHashMap<String, Object>> resultList = new ArrayList<>();
        for (MyThread thread : myThreadList) {
            resultList.add(mapThreadToLinkedHashMap(thread));
        }
        return resultList;
    }
}
