package com.example.springboot.hello.service;

import com.example.springboot.hello.entity.Book;
import com.example.springboot.hello.web.response.Response;
import com.github.pagehelper.Page;


import java.util.List;

public interface BookService {
    //添加图书
    Response addBook(Book book);
    //删除图书
    Response deleteBook(Integer bookId);
    //更新图书信息
    Response updateBook(Book book);
    //条件查询
    List<Book> getBookByCondition(String bookName,String author,Integer bookId);
    //根据id查询
    Book getBookById(Integer bookId);
    //分页查询
    Page<Book> findByPage(int pageNo, int pageSize);
}
