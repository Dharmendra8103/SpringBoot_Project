package com.codewitharjun.app.service;

import com.codewitharjun.app.exception.UserNotFoundException;
import com.codewitharjun.app.model.User;
import com.codewitharjun.app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }

    @Override
    public User updateUser(User user, Long id) {
    return userRepository.findById(id).map(userUpdate -> {
        userUpdate.setName(user.getName());
        userUpdate.setLastName(user.getLastName());
        userUpdate.setUsername(user.getUsername());
        userUpdate.setEmail(user.getEmail());
        return userRepository.save(userUpdate);
    }).orElseThrow(()-> new UserNotFoundException(id));
    }

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


}
