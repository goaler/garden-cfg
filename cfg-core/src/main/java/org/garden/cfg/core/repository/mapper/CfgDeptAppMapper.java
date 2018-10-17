package org.garden.cfg.core.repository.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garden.cfg.core.repository.entity.CfgDeptApp;
import org.garden.cfg.core.repository.entity.CfgDeptAppExample;

public interface CfgDeptAppMapper {
    long countByExample(CfgDeptAppExample example);

    int deleteByExample(CfgDeptAppExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgDeptApp record);

    int insertSelective(CfgDeptApp record);

    List<CfgDeptApp> selectByExample(CfgDeptAppExample example);

    CfgDeptApp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgDeptApp record, @Param("example") CfgDeptAppExample example);

    int updateByExample(@Param("record") CfgDeptApp record, @Param("example") CfgDeptAppExample example);

    int updateByPrimaryKeySelective(CfgDeptApp record);

    int updateByPrimaryKey(CfgDeptApp record);
}