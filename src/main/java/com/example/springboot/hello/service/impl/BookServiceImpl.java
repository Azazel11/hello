package com.example.springboot.hello.service.impl;

import com.example.springboot.hello.entity.Book;
import com.example.springboot.hello.exception.NotFoundException;
import com.example.springboot.hello.mapper.BookMapper;
import com.example.springboot.hello.service.BookService;
import com.example.springboot.hello.web.response.Response;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import org.slf4j.Logger;


import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final  Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    BookMapper bookMapper;
    @Override
    public Response addBook(Book book){
        Response response = new Response();
        try {
            Book book1 = bookMapper.getBookById(book.getBookId());
            if (book1 != null || book.getBookId() == 0) {
                response.setMsg("增加失败");
                response.setCode(-1);
                logger.error("添加失败");
                return response;
            }else {
                bookMapper.addBook(book);
                response.setMsg("增加成功");
                response.setCode(1);
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("增加失败，异常",e);
    }
        return response;
    }
    @Override
    public Response deleteBook(Integer bookId){
        Response response = new Response();
        try {
            Book book = bookMapper.getBookById(bookId);
            if (book == null){
                response.setMsg("该书不存在，无法删除");
                response.setCode(-1);
                return response;
                //throw new NotFoundException("该书不存在");
            }
            bookMapper.deleteBook(bookId);
            response.setMsg("删除成功");
            response.setCode(1);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("删除失败，异常",e);
        }
        return response;
    }
    public Response updateBook(Book book) {
        Response response = new Response();
        try {
            Book book1 = bookMapper.getBookById(book.getBookId());
            if (book1 == null){
                response.setMsg("该书不存在，无法更新");
                response.setCode(-1);
                return response;
                //throw new NotFoundException("该书不存在");
            }
            bookMapper.updateBook(book);
            logger.info("更新成功");
            response.setMsg("更新成功");
            response.setCode(1);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("更新失败，异常",e);
        }
        return response;
    }
    public Book getBookById(Integer bookId){
        return bookMapper.getBookById(bookId);
    }
    public List<Book> getBookByCondition(String bookName, String author, Integer bookId){
        List<Book> bookList1 = bookMapper.getBookByCondition(bookName,author,bookId);
        return bookList1;
    }
    public Page<Book> findByPage(int pageNo, int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        return bookMapper.getBookList();
    }
}
