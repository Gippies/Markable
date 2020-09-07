package com.gippies.markable.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<UserDTO> listAll() {
        return repo.findAll();
    }

    public void save(UserDTO user) {
        repo.save(user);
    }

    public UserDTO get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public UserDTO getByUsername(String username) {
        return repo.findByUsername(username).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}
