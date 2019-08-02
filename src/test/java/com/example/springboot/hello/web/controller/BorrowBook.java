package com.example.springboot.hello.web.controller;

import com.example.springboot.hello.service.BorrowService;
import com.example.springboot.hello.service.impl.BorrowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.CountDownLatch;

public class BorrowBook implements Runnable{
    private final CountDownLatch startSignal;

    @Autowired
    BorrowService borrowService;

    public BorrowBook(CountDownLatch startSignal){
        super();
        this.startSignal = startSignal;
    }
    @Override
    public void  run(){
        try {
            startSignal.await();
            doWork1();
            doWork2();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
    private void doWork1(){
        borrowService.borrowBook(18,111);
        System.out.println("经过这里吗？");
    }
    private void doWork2(){
        borrowService.borrowBook(19,111);
        System.out.println("这里呢？");
    }

}