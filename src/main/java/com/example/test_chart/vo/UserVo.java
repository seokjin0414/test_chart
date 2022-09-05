package com.example.test_chart.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("user")
public class UserVo {
    private Long userId;
    private String userName;
}
