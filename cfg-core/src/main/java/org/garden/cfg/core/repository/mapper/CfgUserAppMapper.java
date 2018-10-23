package org.garden.cfg.core.repository.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garden.cfg.core.repository.entity.CfgUserApp;
import org.garden.cfg.core.repository.entity.CfgUserAppExample;

public interface CfgUserAppMapper {
    long countByExample(CfgUserAppExample example);

    int deleteByExample(CfgUserAppExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgUserApp record);

    int insertSelective(CfgUserApp record);

    List<CfgUserApp> selectByExample(CfgUserAppExample example);

    CfgUserApp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgUserApp record, @Param("example") CfgUserAppExample example);

    int updateByExample(@Param("record") CfgUserApp record, @Param("example") CfgUserAppExample example);

    int updateByPrimaryKeySelective(CfgUserApp record);

    int updateByPrimaryKey(CfgUserApp record);
}