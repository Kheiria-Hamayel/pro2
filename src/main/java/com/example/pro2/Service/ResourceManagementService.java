package com.example.pro2.Service;

import com.example.pro2.model.Memory;
import com.example.pro2.model.Servers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ResourceManagementService {
    Memory memory = new Memory(50);

    Logger logger = LoggerFactory.getLogger(Service.class);
    private static List<Servers> serversIN = new ArrayList<>();
    private static final Map<Integer, Servers> pendingThread = new ConcurrentHashMap<>();

    @Async
    public CompletableFuture<List<Servers>> addServers(int id, int amount) throws InterruptedException {
        Servers s = new Servers(id, amount);

        logger.info("the server with  id " + id + "and with allocation amount " + amount + " and the " +
                Thread.currentThread().getName());
        synchronized (this) {
            serversIN.add(s);
        }
        Thread.sleep(1000);

        return CompletableFuture.completedFuture(serversIN);
    }

    @Async
    public void allocate(int id, int amount) throws InterruptedException {
        int n;

        if (amount <= memory.getSize()) {
            n = memory.getSize() - amount;
            memory.setSize(n);
            logger.info("the server with  id " + id + "and with allocation amount " + amount + " and the " +
                    Thread.currentThread().getName() + " where the memory size become " + memory.getSize());
            Thread.sleep(100);
        } else if (amount > memory.getSize()) { // no enough memory
            logger.info("the server with  id " + id + "and with allocation amount " + amount + " and the " +
                    Thread.currentThread().getName() + " no enough memory space  " + memory.getSize()
                    + " so wait some  time to request another server");
            Thread.sleep(20000);
            memory.setSize(50);
            // pendingThread.put(id, new Servers(id, amount));
            logger.info(" resetting the memory " + memory.getSize());
            allocate(id, amount);


        }
    }

}