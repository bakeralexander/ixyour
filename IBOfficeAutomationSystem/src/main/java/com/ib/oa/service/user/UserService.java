package com.ib.oa.service.user;

import com.ib.oa.model.OaUser;

public interface UserService {

    OaUser findByUserName(String userName);
}
