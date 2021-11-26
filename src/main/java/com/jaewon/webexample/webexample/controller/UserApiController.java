package com.jaewon.webexample.webexample.controller;

import com.jaewon.webexample.webexample.model.Board;
import com.jaewon.webexample.webexample.model.User;
import com.jaewon.webexample.webexample.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserApiController {

    private final UserRepository repository;

    UserApiController(UserRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/users")
    List<User> all(@RequestParam(required = false) String method, @RequestParam(required = false) String text) {
        List<User> users = null;
        if ("query".equals((method))) {
            users = repository.findByUsernameQuery(text);
        } else if("nativeQuery".equals((method))){
            users = repository.findByUsernameNativeQuery(text);
        } else if("querydsl".equals((method))) {
//            Quser
//            Predicate predicate = ;
//            repository.findAll(predicate);
        } else if("jdbc".equals(method)) {
//            users = repository.findByUsernameJdbc(text);
        }
        else {
            users = repository.findAll();
        }
        return users;
//        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    // Single item

    @GetMapping("/users/{id}")
    User one(@PathVariable Long id) {

        return repository.findById(id).orElse(null);
//                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

        return repository.findById(id)
                .map(user -> {
//                    user.setBoards(newUser.getBoards());
                    user.getBoards().clear();
                    user.getBoards().addAll(newUser.getBoards());
                    for (Board board : user.getBoards()) {
                        board.setUser(user);
                    }
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
