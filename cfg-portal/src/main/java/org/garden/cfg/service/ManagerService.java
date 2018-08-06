package org.garden.cfg.service;

import java.util.List;

import org.garden.cfg.core.repository.entity.CfgUser;
import org.garden.cfg.core.repository.entity.CfgUserExample;
import org.garden.cfg.core.repository.mapper.CfgUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class ManagerService {

	@Autowired
	private CfgUserMapper cfgUserMapper;

	public boolean login(String userCode, String password) {
		CfgUserExample example = new CfgUserExample();
		example.createCriteria().andUserCodeEqualTo(userCode).andPasswordEqualTo(password).andStatusEqualTo(1);
		List<CfgUser> users = cfgUserMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(users)) {
			return false;
		}
		return true;
	}

	public void getOwnAppList() {
		
	}

}
