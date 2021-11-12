package com.jaewon.webexample.webexample.repository;

import com.jaewon.webexample.webexample.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
