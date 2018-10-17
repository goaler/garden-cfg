package org.garden.cfg.core.repository.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garden.cfg.core.repository.entity.CfgDepartment;
import org.garden.cfg.core.repository.entity.CfgDepartmentExample;

public interface CfgDepartmentMapper {
    long countByExample(CfgDepartmentExample example);

    int deleteByExample(CfgDepartmentExample example);

    int deleteByPrimaryKey(Integer deptId);

    int insert(CfgDepartment record);

    int insertSelective(CfgDepartment record);

    List<CfgDepartment> selectByExample(CfgDepartmentExample example);

    CfgDepartment selectByPrimaryKey(Integer deptId);

    int updateByExampleSelective(@Param("record") CfgDepartment record, @Param("example") CfgDepartmentExample example);

    int updateByExample(@Param("record") CfgDepartment record, @Param("example") CfgDepartmentExample example);

    int updateByPrimaryKeySelective(CfgDepartment record);

    int updateByPrimaryKey(CfgDepartment record);
}