package com.lgh.spring.boot.service.impl;

import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.pojo.user.UserAddQuery;
import com.lgh.spring.boot.pojo.user.UserQueryQuery;
import com.lgh.spring.boot.repo.UserRepo;
import com.lgh.spring.boot.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/3/4.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepo userRepo;
    @Override
    public boolean addUser(UserAddQuery user) {
        MUser mUser = new MUser();
        mUser.setName(user.getName());
        mUser.setEmail(user.getEmail());
        return userRepo.save(mUser) != null;
    }

    @Override
    public Page<MUser> query(UserQueryQuery userQueryQuery) {
        return userRepo.findAll(userQueryQuery);
    }
}
