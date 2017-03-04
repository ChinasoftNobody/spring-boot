package com.lgh.spring.boot.service;

import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.pojo.user.AddUserQuery;
import com.lgh.spring.boot.pojo.user.QueryUserQuery;
import org.springframework.data.domain.Page;

/**
 * Created by Administrator on 2017/3/4.
 */
public interface UserService {
    boolean addUser(AddUserQuery user);

    /**
     * 分页查询所有用户
     * @param queryUserQuery 条件
     * @return 用户信息
     */
    Page<MUser> query(QueryUserQuery queryUserQuery);
}
