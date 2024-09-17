package com.codewitharjun.app.service;

import com.codewitharjun.app.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface UserService {

   public User saveUser(User user);

   public List<User> getAllUsers();

   public User getUserById(Long id);
   public User updateUser(User user,Long id);

   public boolean existsById(Long id);

   public void deleteUserById(Long id);
}
