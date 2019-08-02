package com.example.springboot.hello.service.impl;

import com.example.springboot.hello.entity.Book;
import com.example.springboot.hello.entity.Borrow;
import com.example.springboot.hello.entity.User;
import com.example.springboot.hello.mapper.BookMapper;
import com.example.springboot.hello.mapper.BorrowMapper;
import com.example.springboot.hello.mapper.UserMapper;
import com.example.springboot.hello.service.BorrowService;
import com.example.springboot.hello.untils.DateUntils;
import com.example.springboot.hello.web.response.Response;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private BorrowMapper borrowMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private BookMapper bookMapper;
    @Override
    //TODO 加事务，回滚
    @Transactional
    public synchronized Response borrowBook(Integer uId, Integer bId){
        User u = userMapper.selectByPrimaryKey(uId);
        Book b = bookMapper.getBookById(bId);
        if(u!=null && b!=null ) {
            if (b.getNumber() > 0 && b.getNumber() < b.getTotalnumber()) {
                Borrow check = borrowMapper.check(uId, bId);
                if (check == null) {
                    try {
                    Borrow borrow = new Borrow();
                    borrow.setbName(b.getBookName());
                    borrow.setuName(u.getName());
                    borrow.setbId(b.getBookId());
                    borrow.setuId(u.getId());
                    borrow.setBorrowDate(DateUntils.getCurrentDate());
                    borrow.setReturnDate(DateUntils.addDay(30));
                    borrowMapper.insert(borrow);
                    b.setNumber(b.getNumber() - 1);
                    bookMapper.updateBook(b);
                    }catch (Exception e){
                        e.printStackTrace();
                        logger.error("借阅失败，异常",e);
                    }
                    //Response response= new Response("借阅成功",1);
                    Response response = new Response();
                    response.setResponse("借阅成功",1,borrowMapper.getBookByUId(uId));
                    return response;
                } else {
                    Response response= new Response("你已经借阅过此书，请勿重复借阅",-1);
                    return response;
                }
            } else {
                Response response= new Response("借阅失败，该图书库存不足",-1);
                return response;
            }
        }
        Response response= new Response("借阅失败，出现未知错误",1);
        return response;
    }
    public Response delete(Integer uId,Integer bId){
        Borrow borrow = borrowMapper.check(uId,bId);
        if (borrow!=null){
            try {
                borrowMapper.delete(uId,bId);
                Book book = bookMapper.getBookById(bId);
                book.setNumber(book.getNumber()+1);
                bookMapper.updateBook(book);
            }catch (Exception e){
                e.printStackTrace();
                logger.error("归还失败，异常",e);
            }
            Response response = new Response("归还成功",1);
            return response;
        }else {
            Response response = new Response("没有借阅记录",1);
            return response;
        }
    }
    public Page<Borrow> getList(Integer c,Integer n){
        return PageHelper.startPage(c,n).doSelectPage(()->borrowMapper.getList());
    }
    public Borrow getBookByUId(Integer uId){
        Borrow borrow = borrowMapper.getBookByUId(uId);
        return borrow;
    }
}
