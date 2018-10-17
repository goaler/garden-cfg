package org.garden.cfg.core.repository.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garden.cfg.core.repository.entity.CfgRole;
import org.garden.cfg.core.repository.entity.CfgRoleExample;

public interface CfgRoleMapper {
    long countByExample(CfgRoleExample example);

    int deleteByExample(CfgRoleExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(CfgRole record);

    int insertSelective(CfgRole record);

    List<CfgRole> selectByExample(CfgRoleExample example);

    CfgRole selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") CfgRole record, @Param("example") CfgRoleExample example);

    int updateByExample(@Param("record") CfgRole record, @Param("example") CfgRoleExample example);

    int updateByPrimaryKeySelective(CfgRole record);

    int updateByPrimaryKey(CfgRole record);
}