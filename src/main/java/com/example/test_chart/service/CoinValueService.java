package com.example.test_chart.service;

import com.example.test_chart.repository.CoinValueRepository;
import com.example.test_chart.vo.CoinValue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CoinValueService {

    private final CoinValueRepository coinValueRepository;

    public List<CoinValue> selectWaitingTransferList(CoinValue vo) {
        List<CoinValue> result = coinValueRepository.selectCoinValueList(vo);
        return result;
    }

    public int insertCoinValue(CoinValue vo) {
        return coinValueRepository.insertCoinValue(vo);
    }

}
