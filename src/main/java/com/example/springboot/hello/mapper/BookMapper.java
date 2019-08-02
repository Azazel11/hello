package com.example.springboot.hello.mapper;

import com.example.springboot.hello.entity.Book;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface BookMapper {
    //添加图书
    int addBook(Book book);
    //分页查询
    Page<Book> getBookList();
    //删除图书
    int deleteBook(Integer bookId);
    //修改图书信息
    int updateBook(Book book);
    //条件查询
    List<Book> getBookByCondition(String bookName,String author,Integer bookId);
    //根据id查询
    Book getBookById(Integer bookId);
}
