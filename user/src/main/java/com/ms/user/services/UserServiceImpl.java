package com.ms.user.services;

import com.ms.user.models.User;
import com.ms.user.producers.UserProducer;
import com.ms.user.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
    final UserRepository userRepository;
    final UserProducer userProducer;

    public UserServiceImpl(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Override
    @Transactional
    public User save(User user) {
        userRepository.save(user);
        userProducer.publishMessageEmail(user);
        return user;
    }
}
