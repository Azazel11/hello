package com.example.springboot.hello.web.controller;

import com.example.springboot.hello.TmallApplicationTests;
import com.example.springboot.hello.entity.Book;
import com.example.springboot.hello.entity.Borrow;
import com.example.springboot.hello.entity.User;
import com.example.springboot.hello.service.BorrowService;
import com.example.springboot.hello.service.UserService;
import com.example.springboot.hello.web.response.Response;
import com.github.pagehelper.Page;
import junit.textui.TestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

public class BorrowControllerTest extends TmallApplicationTests {

    @Autowired
    BorrowService borrowService;
    @Test

    public void borrowBook() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 50; i++) {
            final int a = i;
            new Thread(() -> {
                countDownLatch.countDown();
                //System.out.println(11111);
                Response response = borrowService.borrowBook(3,111);
                System.out.println(response);
            }).start();
        }
        for (int i = 0; i < 50; i++) {
            final int a = i;
            new Thread(() -> {
                countDownLatch.countDown();
                //System.out.println(3333);
                Response response1 = borrowService.borrowBook(19,111);
                System.out.println(response1);
            }).start();
        }
        countDownLatch.await();

        System.out.println("success");
    }

    @Test
    public void returnBook() {
        Response response = borrowService.delete(1,134);
        System.out.println(response.toString());
    }

    @Test
    public void getList() {
        Page<Borrow> page = borrowService.getList(0,5);
        Assert.assertNotNull(page);
        System.out.println(page.getResult());
        page.getResult().forEach(System.out::println);
    }

    @Test
    public void getBookByUId() {
        Borrow borrow = borrowService.getBookByUId(15);
        System.out.println(borrow.getbName());
    }
    //测试借书接口线程安全
    @Test
    public void threadTest()throws InterruptedException{
//       Response response = borrowService.borrowBook(20,200);
//       System.out.println(response.toString());
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0;i < 16;i++){
            BorrowBook bb = new BorrowBook(countDownLatch);
            Thread b = new Thread(bb);
            b.start();
        }
        countDownLatch.countDown();
    }
}