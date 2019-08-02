package com.example.springboot.hello.mapper;

import com.example.springboot.hello.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BorrowMapper {
    int insert(Borrow borrow);
    int delete(Integer uId,Integer bId);
    List<Borrow> getList();
    Borrow getBookByUId(Integer uId);
    Borrow check(Integer uId,Integer bId);

}