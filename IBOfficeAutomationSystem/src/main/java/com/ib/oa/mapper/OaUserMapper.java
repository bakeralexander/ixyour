package com.ib.oa.mapper;

import com.ib.oa.model.OaUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OaUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(OaUser record);

    OaUser selectByPrimaryKey(String id);

    List<OaUser> selectAll();

    int updateByPrimaryKey(OaUser record);

    OaUser selectByUserName(String username);
}