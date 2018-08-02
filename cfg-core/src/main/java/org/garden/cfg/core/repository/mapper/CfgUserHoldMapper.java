package org.garden.cfg.core.repository.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garden.cfg.core.repository.entity.CfgUserHold;
import org.garden.cfg.core.repository.entity.CfgUserHoldExample;

public interface CfgUserHoldMapper {
    long countByExample(CfgUserHoldExample example);

    int deleteByExample(CfgUserHoldExample example);

    int deleteByPrimaryKey(Integer holdId);

    int insert(CfgUserHold record);

    int insertSelective(CfgUserHold record);

    List<CfgUserHold> selectByExample(CfgUserHoldExample example);

    CfgUserHold selectByPrimaryKey(Integer holdId);

    int updateByExampleSelective(@Param("record") CfgUserHold record, @Param("example") CfgUserHoldExample example);

    int updateByExample(@Param("record") CfgUserHold record, @Param("example") CfgUserHoldExample example);

    int updateByPrimaryKeySelective(CfgUserHold record);

    int updateByPrimaryKey(CfgUserHold record);
}