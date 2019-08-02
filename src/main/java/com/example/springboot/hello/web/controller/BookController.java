package com.example.springboot.hello.web.controller;

import com.example.springboot.hello.entity.Book;
import com.example.springboot.hello.exception.NotFoundException;
import com.example.springboot.hello.service.BookService;
import com.example.springboot.hello.web.response.Response;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "book")
public class BookController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;
    @PostMapping(value = "addBook")
    public Response addBook(@RequestBody Book book){
        Response response = bookService.addBook(book);
        return response;
    }
    @PostMapping(value = "deleteBook")
    public Response deleteBook(@RequestBody Book book){
        //try {
            Response response = bookService.deleteBook(book.getBookId());
            return response;
//        }catch (NotFoundException e){
//            logger.error("该书不存在");
//        }
//        return null;
    }
    @PostMapping(value = "updateBook")
    public Response updateBook(@RequestBody Book book){
        Response response = bookService.updateBook(book);
        return response;
    }
    @PostMapping(value = "getBookById")
    public Response getBookById(@RequestBody Book book){
        Response response = new Response();
        response.setResponse("查询成功",1,bookService.getBookById(book.getBookId()));
        return response;
    }
    @PostMapping(value = "getBookList")
    public Response findByPage(@RequestParam(value = "pn") int pageNo,@RequestParam(value = "ps") int pageSize){
        Response response = new Response();
        Page<Book> bookList = bookService.findByPage(pageNo,pageSize);
        response.setResponse("查询成功",1,bookList);
        return response;
    }
    @PostMapping(value = "getBookByCondition")
    public Response getBookByCondition(@RequestBody Book book){
        Response response = new Response();
        List<Book> bookList1 = bookService.getBookByCondition(book.getBookName(),book.getAuthor(),book.getBookId());
        response.setResponse("查询成功",1,bookList1);
        return response;
    }
}
