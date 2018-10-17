package org.garden.cfg.core.repository.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garden.cfg.core.repository.entity.CfgRoleCluster;
import org.garden.cfg.core.repository.entity.CfgRoleClusterExample;

public interface CfgRoleClusterMapper {
    long countByExample(CfgRoleClusterExample example);

    int deleteByExample(CfgRoleClusterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgRoleCluster record);

    int insertSelective(CfgRoleCluster record);

    List<CfgRoleCluster> selectByExample(CfgRoleClusterExample example);

    CfgRoleCluster selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgRoleCluster record, @Param("example") CfgRoleClusterExample example);

    int updateByExample(@Param("record") CfgRoleCluster record, @Param("example") CfgRoleClusterExample example);

    int updateByPrimaryKeySelective(CfgRoleCluster record);

    int updateByPrimaryKey(CfgRoleCluster record);
}