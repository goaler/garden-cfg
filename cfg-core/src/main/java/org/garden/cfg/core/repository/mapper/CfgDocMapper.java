package org.garden.cfg.core.repository.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garden.cfg.core.repository.entity.CfgDoc;
import org.garden.cfg.core.repository.entity.CfgDocExample;

public interface CfgDocMapper {
    long countByExample(CfgDocExample example);

    int deleteByExample(CfgDocExample example);

    int deleteByPrimaryKey(Integer docId);

    int insert(CfgDoc record);

    int insertSelective(CfgDoc record);

    List<CfgDoc> selectByExample(CfgDocExample example);

    CfgDoc selectByPrimaryKey(Integer docId);

    int updateByExampleSelective(@Param("record") CfgDoc record, @Param("example") CfgDocExample example);

    int updateByExample(@Param("record") CfgDoc record, @Param("example") CfgDocExample example);

    int updateByPrimaryKeySelective(CfgDoc record);

    int updateByPrimaryKey(CfgDoc record);
}