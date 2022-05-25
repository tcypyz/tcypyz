package com.example.smserver.service.impl;

import com.example.smserver.core.base.entity.BaseEntityServiceImpl;
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
public class ScoreServiceImpl extends BaseEntityServiceImpl<ScoreMapper, Score> implements ScoreService {
}
