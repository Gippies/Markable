package com.gippies.markable.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GreetingService {

    @Autowired
    private GreetingRepository repo;

    public List<Greeting> listAll() {
        return repo.findAll();
    }

    public void save(Greeting greeting) {
        repo.save(greeting);
    }

    public Greeting get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
