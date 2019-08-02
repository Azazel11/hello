package com.example.springboot.hello.web.controller;

import com.example.springboot.hello.entity.Borrow;
import com.example.springboot.hello.service.BookService;
import com.example.springboot.hello.service.BorrowService;
import com.example.springboot.hello.web.response.Response;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "borrow")
public class BorrowController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowService borrowService;
    @PostMapping(value = "borrowBook")
    public Response borrowBook(@RequestBody Borrow borrow) {
         Integer uId = borrow.getuId();
         Integer bId = borrow.getbId();
         Response response = borrowService.borrowBook(uId,bId);
         return response;
    }
    @PostMapping(value = "returnBook")
    public Response returnBook(@RequestBody Borrow borrow){
        Integer uId = borrow.getuId();
        Integer bId = borrow.getbId();
        Response response = borrowService.delete(uId,bId);
        return response;
    }
    @RequestMapping(value = "getList")
    public Response getList(@RequestParam(value = "C") Integer c,@RequestParam(value = "N") Integer n){
        Response response = new Response();
        Page<Borrow> list = borrowService.getList(c,n);
        response.setResponse("查询成功",1,list);
        return response;
    }
    @RequestMapping(value = "getBookByUName")
    public Response getBookByUId(@RequestBody Borrow borrow){
        Response response = new Response();
        Borrow list1 = borrowService.getBookByUId(borrow.getuId());
        response.setResponse("查询成功",1,list1);
        return response;
    }
}
