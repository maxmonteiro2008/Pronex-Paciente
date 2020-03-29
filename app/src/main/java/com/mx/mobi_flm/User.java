package com.mx.mobi_flm;

import androidx.annotation.NonNull;
import androidx.annotation.NonNull;

public class User {

    private String nickname;
    private Integer transactions;

  public void setNickname(String nickname) {this.nickname = nickname;}
  public void setTransactions(Integer transaction) {this.transactions = transaction;}
  public String getNickname() {return this.nickname;}
  public Integer getTransactions() { return this.transactions; }

    public User(){}

    public User(String nickname,Integer transactions){
        this.nickname=nickname;
        this.transactions=transactions;

    }

    @NonNull
    @Override
    public String toString() {
        return nickname+","+ transactions.toString();
    }
}
