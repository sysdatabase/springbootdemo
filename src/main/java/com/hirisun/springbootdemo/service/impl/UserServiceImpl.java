package com.hirisun.springbootdemo.service.impl;

import com.hirisun.springbootdemo.bean.User;
import com.hirisun.springbootdemo.dao.UserRepository;
import com.hirisun.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User loadUserByUsername(String username) {
        String newUserName = Optional.ofNullable(username).orElse("");
        return Optional.ofNullable(userRepository.getByUsername(newUserName)).orElse(null);
    }

    @Override
    public User getById(long id) {
        User user = new User();
        user.setId(id);
        Example<User> example = Example.of(user);
        Optional<User> userOptional = userRepository.findOne(example);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delById(long id) {
        userRepository.deleteById(id);
    }
}
