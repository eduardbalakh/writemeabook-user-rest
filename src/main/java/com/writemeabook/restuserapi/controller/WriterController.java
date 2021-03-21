package com.writemeabook.restuserapi.controller;

import com.writemeabook.restuserapi.model.User;
import com.writemeabook.restuserapi.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class WriterController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public DeferredResult<List<User>> showAllUsers() {
        log.info("Start of showAllUsers method");
        final DeferredResult<List<User>> deferredResult = new DeferredResult<>(5000L);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(() -> {
            log.info("Processing of showAllUsers method");
            List<User> result = null;
            try {
                result = userService.getAllUsers();
            } catch (Exception exception) {
                log.error("Exception occured in showAllUsers method: /n Message: " + exception.getMessage() +
                        "/n Stack trace: + " + Arrays.toString(exception.getStackTrace()));
            }
            deferredResult.setResult(result);
            deferredResult.onCompletion(() -> log.info("End of processing of showAllUsers method"));
        });
        log.info("End of showAllUsers method");
        return deferredResult;
    }

    @GetMapping("/{id}")
    public DeferredResult<User> getUser(@PathVariable int id) {
        log.info("Start of getUser method");
        final DeferredResult<User> deferredResult = new DeferredResult<>(5000L);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(() -> {
            log.info("Processing of getUser method");
            User result = null;
            try {
                result = userService.getUser(id);
            } catch (Exception exception) {
                log.error("Exception occured in getUser method: /n Message: " + exception.getMessage() +
                        "/n Stack trace: + " + Arrays.toString(exception.getStackTrace()));
            }
            deferredResult.setResult(result);
            log.info("End of processing of getUser method");
        });
        log.info("End of getUser method");
        return deferredResult;
    }

    @PostMapping("/")
    public DeferredResult<User> saveUser(@RequestBody User user) {
        log.info("Start of saveUser method");
        final DeferredResult<User> deferredResult = new DeferredResult<>(5000L);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(() -> {
            log.info("Processing of saveUser method");
            User result = null;
            try {
                result = userService.saveUser(user);
            } catch (Exception exception) {
                log.error("Exception occured in saveUser method: /n Message: " + exception.getMessage() +
                        "/n Stack trace: + " + Arrays.toString(exception.getStackTrace()));
            }
            deferredResult.setResult(result);
            log.info("End of processing of saveUser method");
        });
        log.info("End of saveUser method");
        return deferredResult;
    }

    @PutMapping("/")
    public DeferredResult<User> updateUser(@RequestBody User user) {
        log.info("Start of updateUser method");
        final DeferredResult<User> deferredResult = new DeferredResult<>(5000L);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(() -> {
            log.info("Processing of updateUser method");
            User result = null;
            try {
                result = userService.saveUser(user);
            } catch (Exception exception) {
                log.error("Exception occurred in updateUser method: /n Message: " + exception.getMessage() +
                        "/n Stack trace: + " + Arrays.toString(exception.getStackTrace()));
            }
            deferredResult.setResult(result);
            log.info("End of processing of updateUser method");
        });
        log.info("End of updateUser method");
        return deferredResult;
    }

    @DeleteMapping("/{id}")
    public DeferredResult<String> deleteUser(@PathVariable int id) {
        log.info("Start of deleteUser method");
        final DeferredResult<String> deferredResult = new DeferredResult<>(5000L);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(() -> {
            log.info("Processing of deleteUser method");
            try {
                userService.deleteUser(id);
            } catch (Exception exception) {
                log.error("Exception occurred in deleteUser method: /n Message: " + exception.getMessage() +
                        "/n Stack trace: + " + Arrays.toString(exception.getStackTrace()));
            }
            deferredResult.setResult("User with ID = " + id + " was deleted");
            log.info("End of processing of deleteUser method");
        });
        log.info("End of deleteUser method");
        return deferredResult;
    }

    private static<T> DeferredResult<T> createResponce(long timeOut, Callable<T> task, Runnable onTimeOut, String excMessage) {
        final DeferredResult<T> deferredResult = new DeferredResult<>(timeOut);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(()->{
            T result = null;
            try{
                result = task.call();
            } catch (Exception e) {
                log.error(excMessage + ": " + Arrays.toString(e.getStackTrace()));
            }
            deferredResult.setResult(result);
            deferredResult.onTimeout(onTimeOut);
        });
        return deferredResult;
    }
}

