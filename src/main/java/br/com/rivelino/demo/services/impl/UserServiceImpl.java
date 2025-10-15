package br.com.rivelino.demo.services.impl;

import br.com.rivelino.demo.domain.User;
import br.com.rivelino.demo.repositories.UserRepository;
import br.com.rivelino.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Integer id) {
        Optional<User> optional = repository.findById(id);
        return optional.orElse(null);
    }
}
