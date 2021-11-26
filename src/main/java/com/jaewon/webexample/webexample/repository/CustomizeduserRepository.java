package com.jaewon.webexample.webexample.repository;

import com.jaewon.webexample.webexample.model.User;

import java.util.List;

public interface CustomizeduserRepository {

    List<User> findByUsernameCustom(User user);

    List<User> findByUsernameJdbc(String username);
}
