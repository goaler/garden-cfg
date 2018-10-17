package org.garden.cfg.core.repository.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garden.cfg.core.repository.entity.CfgUserRole;
import org.garden.cfg.core.repository.entity.CfgUserRoleExample;

public interface CfgUserRoleMapper {
    long countByExample(CfgUserRoleExample example);

    int deleteByExample(CfgUserRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgUserRole record);

    int insertSelective(CfgUserRole record);

    List<CfgUserRole> selectByExample(CfgUserRoleExample example);

    CfgUserRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgUserRole record, @Param("example") CfgUserRoleExample example);

    int updateByExample(@Param("record") CfgUserRole record, @Param("example") CfgUserRoleExample example);

    int updateByPrimaryKeySelective(CfgUserRole record);

    int updateByPrimaryKey(CfgUserRole record);
}