package com.mx.mobi_flm;

import androidx.annotation.NonNull;
import androidx.annotation.NonNull;

public class User {

    private String nickname;
    private Integer transactions;

  public void setNickname(String nickname) {this.nickname = nickname;}
  public void setTransaction(Integer transaction) {this.transactions = transaction;}
  public String getNickname() {return this.nickname;}
  public Integer getTransactions() { return this.transactions; }

    public User(){}

    public User(String nickname,Integer transaction){
        this.nickname=nickname;
        this.transactions=transaction;

    }

    @NonNull
    @Override
    public String toString() {
        return nickname+","+ transactions.toString();
    }
}
