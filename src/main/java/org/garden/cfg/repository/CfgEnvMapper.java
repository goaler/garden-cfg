package org.garden.cfg.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garden.cfg.repository.entity.CfgEnv;
import org.garden.cfg.repository.entity.CfgEnvExample;

public interface CfgEnvMapper {
    long countByExample(CfgEnvExample example);

    int deleteByExample(CfgEnvExample example);

    int deleteByPrimaryKey(Integer envId);

    int insert(CfgEnv record);

    int insertSelective(CfgEnv record);

    List<CfgEnv> selectByExample(CfgEnvExample example);

    CfgEnv selectByPrimaryKey(Integer envId);

    int updateByExampleSelective(@Param("record") CfgEnv record, @Param("example") CfgEnvExample example);

    int updateByExample(@Param("record") CfgEnv record, @Param("example") CfgEnvExample example);

    int updateByPrimaryKeySelective(CfgEnv record);

    int updateByPrimaryKey(CfgEnv record);
}