package com.example.test_chart.repository;

import com.example.test_chart.vo.CoinValue;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CoinValueRepository {

    // select coinValue list
    List<CoinValue> selectCoinValueList(CoinValue vo);

    // insert coinValue
    int insertCoinValue(CoinValue vo);

}
