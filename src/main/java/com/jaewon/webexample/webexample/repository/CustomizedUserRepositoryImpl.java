package com.jaewon.webexample.webexample.repository;

import com.jaewon.webexample.webexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomizedUserRepositoryImpl implements CustomizeduserRepository{

    @PersistenceContext
    private EntityManager em;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findByUsernameCustom(User user) {
//        JPAQuery<?> query = new JPAQuery<>(Void)(em);
//        User u = query.select(user)
//                .from(user)
        return null;
    }

    @Override
    public List<User> findByUsernameJdbc(String username) {

        String sql = "SELECT * from USER WHERE username like ?";

        List<User> users = jdbcTemplate.query(
                sql,
                new Object[]{"%"+username+"%"},
                new BeanPropertyRowMapper(User.class));

        return users;
    }


}
