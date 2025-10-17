package br.com.rivelino.demo.services;

import br.com.rivelino.demo.domain.User;
import br.com.rivelino.demo.domain.dto.UserDTO;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    List<User> findAll();
    User create(UserDTO obj);
    User update(UserDTO obj);
    void delete(Integer id);
}
