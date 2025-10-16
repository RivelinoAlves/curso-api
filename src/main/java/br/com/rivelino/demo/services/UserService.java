package br.com.rivelino.demo.services;

import br.com.rivelino.demo.domain.User;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    List<User> findAll();
}
