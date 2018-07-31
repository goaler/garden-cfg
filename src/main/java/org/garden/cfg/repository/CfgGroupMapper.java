package org.garden.cfg.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garden.cfg.repository.entity.CfgGroup;
import org.garden.cfg.repository.entity.CfgGroupExample;

public interface CfgGroupMapper {
    long countByExample(CfgGroupExample example);

    int deleteByExample(CfgGroupExample example);

    int deleteByPrimaryKey(Integer groupId);

    int insert(CfgGroup record);

    int insertSelective(CfgGroup record);

    List<CfgGroup> selectByExample(CfgGroupExample example);

    CfgGroup selectByPrimaryKey(Integer groupId);

    int updateByExampleSelective(@Param("record") CfgGroup record, @Param("example") CfgGroupExample example);

    int updateByExample(@Param("record") CfgGroup record, @Param("example") CfgGroupExample example);

    int updateByPrimaryKeySelective(CfgGroup record);

    int updateByPrimaryKey(CfgGroup record);
}