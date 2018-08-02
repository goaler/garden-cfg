package org.garden.cfg.core.repository.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garden.cfg.core.repository.entity.CfgUser;
import org.garden.cfg.core.repository.entity.CfgUserExample;

public interface CfgUserMapper {
    long countByExample(CfgUserExample example);

    int deleteByExample(CfgUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(CfgUser record);

    int insertSelective(CfgUser record);

    List<CfgUser> selectByExample(CfgUserExample example);

    CfgUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") CfgUser record, @Param("example") CfgUserExample example);

    int updateByExample(@Param("record") CfgUser record, @Param("example") CfgUserExample example);

    int updateByPrimaryKeySelective(CfgUser record);

    int updateByPrimaryKey(CfgUser record);
}