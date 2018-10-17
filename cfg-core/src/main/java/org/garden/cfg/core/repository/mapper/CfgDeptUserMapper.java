package org.garden.cfg.core.repository.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garden.cfg.core.repository.entity.CfgDeptUser;
import org.garden.cfg.core.repository.entity.CfgDeptUserExample;

public interface CfgDeptUserMapper {
    long countByExample(CfgDeptUserExample example);

    int deleteByExample(CfgDeptUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgDeptUser record);

    int insertSelective(CfgDeptUser record);

    List<CfgDeptUser> selectByExample(CfgDeptUserExample example);

    CfgDeptUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgDeptUser record, @Param("example") CfgDeptUserExample example);

    int updateByExample(@Param("record") CfgDeptUser record, @Param("example") CfgDeptUserExample example);

    int updateByPrimaryKeySelective(CfgDeptUser record);

    int updateByPrimaryKey(CfgDeptUser record);
}