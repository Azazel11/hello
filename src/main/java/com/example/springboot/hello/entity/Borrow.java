package com.example.springboot.hello.entity;

import java.util.Date;

public class Borrow {
    //借阅信息编号
    private Integer id;
    //借书人id
    private Integer uId;
    //借书人姓名
    private String uName;
    //借阅图书的ISBN号
    private Integer bId;
    //借阅的书籍名称
    private String bName;
    //借书时间
    private String borrowDate;
    //还书时间
    private Date returnDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", uId=" + uId +
                ", uName='" + uName + '\'' +
                ", bId=" + bId +
                ", bName='" + bName + '\'' +
                ", borrowDate='" + borrowDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
