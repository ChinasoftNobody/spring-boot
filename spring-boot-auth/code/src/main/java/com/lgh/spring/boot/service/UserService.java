package com.lgh.spring.boot.service;

import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.pojo.user.UserAddQuery;
import com.lgh.spring.boot.pojo.user.UserQueryQuery;
import org.springframework.data.domain.Page;

/**
 * Created by Administrator on 2017/3/4.
 */
public interface UserService {
    boolean addUser(UserAddQuery user);

    /**
     * 分页查询所有用户
     * @param userQueryQuery 条件
     * @return 用户信息
     */
    Page<MUser> query(UserQueryQuery userQueryQuery);
}
