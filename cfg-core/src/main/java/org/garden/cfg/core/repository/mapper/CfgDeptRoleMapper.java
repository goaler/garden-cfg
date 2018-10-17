package org.garden.cfg.core.repository.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garden.cfg.core.repository.entity.CfgDeptRole;
import org.garden.cfg.core.repository.entity.CfgDeptRoleExample;

public interface CfgDeptRoleMapper {
    long countByExample(CfgDeptRoleExample example);

    int deleteByExample(CfgDeptRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgDeptRole record);

    int insertSelective(CfgDeptRole record);

    List<CfgDeptRole> selectByExample(CfgDeptRoleExample example);

    CfgDeptRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgDeptRole record, @Param("example") CfgDeptRoleExample example);

    int updateByExample(@Param("record") CfgDeptRole record, @Param("example") CfgDeptRoleExample example);

    int updateByPrimaryKeySelective(CfgDeptRole record);

    int updateByPrimaryKey(CfgDeptRole record);
}