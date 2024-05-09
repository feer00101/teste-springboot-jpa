package com.aprendendo2.course.services;

import java.util.List;
import java.util.Optional;

import org.h2.jdbc.JdbcSQLNonTransientConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.aprendendo2.course.entities.User;
import com.aprendendo2.course.repositories.UserRepository;
import com.aprendendo2.course.services.exceptions.DatabaseException;
import com.aprendendo2.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {

        return repository.save(obj);

    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
            HttpStatus.valueOf(0);
        } catch (IllegalArgumentException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj) {
        User entity = repository.getReferenceById(id);
        updateDate(entity, obj);
        return repository.save(entity);
    }

    private void updateDate(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
