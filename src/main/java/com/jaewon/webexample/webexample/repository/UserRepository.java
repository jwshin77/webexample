package com.jaewon.webexample.webexample.repository;

import com.jaewon.webexample.webexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
