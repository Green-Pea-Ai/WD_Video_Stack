package com.example.demo.mongod.service;

import com.example.demo.mongod.entity.User;
import com.example.demo.mongod.entity.UserVo;
import com.example.demo.mongod.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserVo> getUserList() {
        return repository.findAll().stream().map(u -> {
            UserVo vo = new UserVo();
            vo.setId(u.getId());
            vo.setName(u.getName());
            vo.setEmail(u.getEmail());

            return vo;
        }).collect(Collectors.toList());
    }

    public UserVo getUserById(String id) {
        return repository.findById(id).map(u -> {
            UserVo vo = new UserVo();
            vo.setId(u.getId());
            vo.setName(u.getName());
            vo.setEmail(u.getEmail());

            return vo;
        }).orElse(null);
    }

    public void saveUser(UserVo vo) {
        User user = new User();
        user.setName(vo.getName());
        user.setEmail(vo.getEmail());
        user.setPwd(vo.getPwd());
        repository.save(user);
    }

    public void updateUser(UserVo vo) {
        User user = new User();
        user.setId(vo.getId());
        user.setName(vo.getName());
        user.setEmail(vo.getEmail());
        user.setPwd(vo.getPwd());
        repository.save(user);
    }

    public void deleteUser(UserVo vo) {
        User user = new User();
        user.setId(vo.getId());
        repository.delete(user);
    }
}
