package com.gippies.markable.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserAuthorityService {

    @Autowired
    private UserAuthorityRepository repo;

    public List<UserAuthority> listAll() {
        return repo.findAll();
    }

    public void save(UserAuthority user) {
        repo.save(user);
    }

    public UserAuthority get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}
