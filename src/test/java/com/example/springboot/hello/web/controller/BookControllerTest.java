package com.example.springboot.hello.web.controller;

import com.example.springboot.hello.TmallApplicationTests;
import com.example.springboot.hello.entity.Book;
import com.example.springboot.hello.exception.NotFoundException;
import com.example.springboot.hello.service.BookService;
import com.example.springboot.hello.service.BorrowService;
import com.example.springboot.hello.web.response.Response;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class BookControllerTest extends TmallApplicationTests {

    @Autowired
    BookService bookService;
    @Test
    public void addBook() {
        Book book = new Book();
        book.setBookId(100);
        book.setBookName("地理中国");
        book.setBookType("科普");
        book.setAuthor("佚名");
        book.setNumber(2);
        book.setTotalnumber(3);
        book.setPublisher("长江出版社");
        book.setDate("1888-08-08");
        book.setPrice(5);
        Response response = bookService.addBook(book);
        System.out.println(response.toString());
    }

    @Test
    public void getBookList() {
        Page<Book> books=bookService.findByPage(0,2);
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        Assert.assertNotNull(books);
        books.getResult().forEach(System.out::println);

    }

    @Test
    public void deleteBook() {
        try {
            Response response = bookService.deleteBook(500);
            System.out.println(response.toString());
        }catch (NotFoundException e){
            e.getMessage();
        }
    }

    @Test
    public void updateBook() {
        Book book = new Book();
        book.setBookId(111);
        book.setBookName("化身孤岛的鲸");
        book.setBookType("唯美");
        book.setAuthor("佚名");
        book.setNumber(2);
        book.setTotalnumber(4);
        book.setPublisher("长江出版社");
        book.setDate("1888-08-08");
        book.setPrice(50);
        Response response = bookService.updateBook(book);
        System.out.println(response.toString());
    }

    @Test
    public void getBookByCondition() {
        List<Book> book1 = bookService.getBookByCondition("儒道至圣","永恒之火",154);
        for (Book book:book1){
            System.out.println(book.getNumber());
            System.out.println(book.getBookType());
        }
    }

    @Test
    public void getBookById() {
        Book book = bookService.getBookById(154);
        Assert.assertEquals(new String("儒道至圣"),book.getBookName());
    }
}