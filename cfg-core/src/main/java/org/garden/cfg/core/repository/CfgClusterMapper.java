package org.garden.cfg.core.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garden.cfg.core.repository.entity.CfgCluster;
import org.garden.cfg.core.repository.entity.CfgClusterExample;

public interface CfgClusterMapper {
    long countByExample(CfgClusterExample example);

    int deleteByExample(CfgClusterExample example);

    int deleteByPrimaryKey(Integer clusterId);

    int insert(CfgCluster record);

    int insertSelective(CfgCluster record);

    List<CfgCluster> selectByExample(CfgClusterExample example);

    CfgCluster selectByPrimaryKey(Integer clusterId);

    int updateByExampleSelective(@Param("record") CfgCluster record, @Param("example") CfgClusterExample example);

    int updateByExample(@Param("record") CfgCluster record, @Param("example") CfgClusterExample example);

    int updateByPrimaryKeySelective(CfgCluster record);

    int updateByPrimaryKey(CfgCluster record);
}