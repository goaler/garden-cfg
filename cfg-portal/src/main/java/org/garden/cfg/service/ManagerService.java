package org.garden.cfg.service;

import java.text.MessageFormat;
import java.util.List;

import org.garden.cfg.core.exception.DataException;
import org.garden.cfg.core.repository.CfgDao;
import org.garden.cfg.core.repository.entity.CfgApp;
import org.garden.cfg.core.repository.entity.CfgAppExample;
import org.garden.cfg.core.repository.entity.CfgDoc;
import org.garden.cfg.core.repository.entity.CfgDocExample;
import org.garden.cfg.core.repository.entity.CfgEnv;
import org.garden.cfg.core.repository.entity.CfgEnvExample;
import org.garden.cfg.core.repository.entity.CfgUser;
import org.garden.cfg.core.repository.entity.CfgUserExample;
import org.garden.cfg.core.repository.mapper.CfgAppMapper;
import org.garden.cfg.core.repository.mapper.CfgDocMapper;
import org.garden.cfg.core.repository.mapper.CfgEnvMapper;
import org.garden.cfg.core.repository.mapper.CfgUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class ManagerService {

	private static final Logger log = LoggerFactory.getLogger(ManagerService.class);

	@Autowired
	private CfgUserMapper cfgUserMapper;

	@Autowired
	private CfgAppMapper cfgAppMapper;

	@Autowired
	private CfgEnvMapper cfgEnvMapper;

	@Autowired
	private CfgDocMapper cfgDocMapper;

	@Autowired
	private CfgDao cfgDao;

	public boolean login(String userCode, String password) {
		CfgUserExample example = new CfgUserExample();
		example.createCriteria().andUserCodeEqualTo(userCode).andPasswordEqualTo(password).andStatusEqualTo(1);
		List<CfgUser> users = cfgUserMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(users)) {
			return false;
		}
		return true;
	}

	public List<CfgApp> getOwnAppList(String userCode) {
		List<CfgApp> apps = cfgDao.getApps(userCode);
		return apps;
	}

	public CfgApp getApp(String appCode) {
		CfgAppExample example = new CfgAppExample();
		example.createCriteria().andAppCodeEqualTo(appCode).andStatusEqualTo(1);
		List<CfgApp> apps = cfgAppMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(apps)) {
			String msg = MessageFormat.format("无应用（{0}）相关信息", appCode);
			log.warn(msg);
			throw new DataException(msg);
		}
		return apps.get(0);
	}

	public List<CfgEnv> findEnvs() {
		CfgEnvExample example = new CfgEnvExample();
		example.createCriteria().andStatusEqualTo(1);
		List<CfgEnv> envs = cfgEnvMapper.selectByExample(example);
		return envs;
	}

	public List<CfgDoc> findDocs(String appCode, String envCode, String clusterCode) {
		CfgDocExample example = new CfgDocExample();
		example.createCriteria().andStatusEqualTo(1).andAppCodeEqualTo(appCode).andEnvCodeEqualTo(envCode)
				.andClusterCodeEqualTo(clusterCode);
		List<CfgDoc> docs = cfgDocMapper.selectByExample(example);
		return docs;
	}

}
