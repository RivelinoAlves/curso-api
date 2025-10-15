package br.com.rivelino.demo.services;

import br.com.rivelino.demo.domain.User;

public interface UserService {
    User findById(Integer id);
}
