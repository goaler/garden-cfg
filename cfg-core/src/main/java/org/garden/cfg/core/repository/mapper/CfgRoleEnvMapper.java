package org.garden.cfg.core.repository.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garden.cfg.core.repository.entity.CfgRoleEnv;
import org.garden.cfg.core.repository.entity.CfgRoleEnvExample;

public interface CfgRoleEnvMapper {
    long countByExample(CfgRoleEnvExample example);

    int deleteByExample(CfgRoleEnvExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgRoleEnv record);

    int insertSelective(CfgRoleEnv record);

    List<CfgRoleEnv> selectByExample(CfgRoleEnvExample example);

    CfgRoleEnv selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgRoleEnv record, @Param("example") CfgRoleEnvExample example);

    int updateByExample(@Param("record") CfgRoleEnv record, @Param("example") CfgRoleEnvExample example);

    int updateByPrimaryKeySelective(CfgRoleEnv record);

    int updateByPrimaryKey(CfgRoleEnv record);
}