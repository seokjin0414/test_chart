package com.example.test_chart.dao;

import com.example.test_chart.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    List<UserVo> userList(UserVo vo);
}
