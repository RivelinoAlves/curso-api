package br.com.rivelino.demo.services.impl;

import br.com.rivelino.demo.domain.User;
import br.com.rivelino.demo.domain.dto.UserDTO;
import br.com.rivelino.demo.repositories.UserRepository;
import br.com.rivelino.demo.services.UserService;
import br.com.rivelino.demo.services.exceptions.DataIntegratyViolationException;
import br.com.rivelino.demo.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> optional = repository.findById(id);
        return optional.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    private void findByEmail(UserDTO obj){
        Optional<User> user = repository.findByEmail(obj.getEmail());
        if(user.isPresent()){
            throw new DataIntegratyViolationException("Email já cadastrado no Sistema:");
        }
    }
}
