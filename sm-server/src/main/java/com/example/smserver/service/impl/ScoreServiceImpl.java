package com.example.smserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.smserver.core.base.BaseServiceImpl;
import com.example.smserver.entity.Score;
import com.example.smserver.mapper.ScoreMapper;
import com.example.smserver.service.ScoreService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/12
 */
@Service
public class ScoreServiceImpl extends BaseServiceImpl<ScoreMapper, Score> implements ScoreService {
}
