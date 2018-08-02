package org.garden.cfg.core.repository.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garden.cfg.core.repository.entity.CfgItem;
import org.garden.cfg.core.repository.entity.CfgItemExample;

public interface CfgItemMapper {
    long countByExample(CfgItemExample example);

    int deleteByExample(CfgItemExample example);

    int deleteByPrimaryKey(Integer itemId);

    int insert(CfgItem record);

    int insertSelective(CfgItem record);

    List<CfgItem> selectByExample(CfgItemExample example);

    CfgItem selectByPrimaryKey(Integer itemId);

    int updateByExampleSelective(@Param("record") CfgItem record, @Param("example") CfgItemExample example);

    int updateByExample(@Param("record") CfgItem record, @Param("example") CfgItemExample example);

    int updateByPrimaryKeySelective(CfgItem record);

    int updateByPrimaryKey(CfgItem record);
}