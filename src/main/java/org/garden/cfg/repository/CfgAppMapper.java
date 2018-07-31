package org.garden.cfg.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garden.cfg.repository.entity.CfgApp;
import org.garden.cfg.repository.entity.CfgAppExample;

public interface CfgAppMapper {
    long countByExample(CfgAppExample example);

    int deleteByExample(CfgAppExample example);

    int deleteByPrimaryKey(Integer appId);

    int insert(CfgApp record);

    int insertSelective(CfgApp record);

    List<CfgApp> selectByExample(CfgAppExample example);

    CfgApp selectByPrimaryKey(Integer appId);

    int updateByExampleSelective(@Param("record") CfgApp record, @Param("example") CfgAppExample example);

    int updateByExample(@Param("record") CfgApp record, @Param("example") CfgAppExample example);

    int updateByPrimaryKeySelective(CfgApp record);

    int updateByPrimaryKey(CfgApp record);
}