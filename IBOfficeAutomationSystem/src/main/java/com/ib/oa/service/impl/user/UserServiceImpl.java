package com.ib.oa.service.impl.user;

import com.ib.oa.mapper.OaUserMapper;
import com.ib.oa.model.OaUser;
import com.ib.oa.service.user.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Resource
    OaUserMapper oaUserMapper;

    public OaUser findByUserName(String userName) {
        return oaUserMapper.selectByUserName(userName);
    }
}
