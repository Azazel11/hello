package com.example.springboot.hello.service;

import com.example.springboot.hello.entity.Borrow;
import com.example.springboot.hello.web.response.Response;
import com.github.pagehelper.Page;

import java.util.List;

public interface BorrowService {
    Response borrowBook(Integer uId, Integer bId);
    Response delete(Integer uId,Integer bId);
    Page<Borrow> getList(Integer c,Integer n);
    Borrow getBookByUId(Integer uId);
}
