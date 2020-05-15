package com.example.hungpchu.ConfigurationAndBean.Database;

public abstract class Database {

    String url;

    public String toString(){
        return "The database connection is " + this.url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){ return this.url; }
}
