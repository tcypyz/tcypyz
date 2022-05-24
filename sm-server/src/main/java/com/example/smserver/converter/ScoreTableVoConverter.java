package com.example.smserver.converter;

import com.example.smserver.core.base.Converter;
import com.example.smserver.entity.Score;
import com.example.smserver.vo.ScoreTableVO;
import org.mapstruct.factory.Mappers;

/**
 * @description:
 * @author: zhh
 * @time: 2022/5/23
 */
@org.mapstruct.Mapper
public interface ScoreTableVoConverter extends Converter<Score, ScoreTableVO> {

    ScoreTableVoConverter INSTANCE = Mappers.getMapper(ScoreTableVoConverter.class);
}
