package com.moringaschool.asuper.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tokens {

    @SerializedName("users")
    @Expose
    private Users users;

    /**
     * No args constructor for use in serialization
     *
     */
    public Tokens() {
    }

    /**
     *
     * @param users
     */
    public Tokens(Users users) {
        super();
        this.users = users;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }

}