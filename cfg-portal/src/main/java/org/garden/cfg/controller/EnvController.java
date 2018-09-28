package org.garden.cfg.controller;

import java.util.ArrayList;
import java.util.List;

import org.garden.cfg.controller.obj.EnvInfo;
import org.garden.cfg.core.repository.entity.CfgEnv;
import org.garden.cfg.service.ManagerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("env")
public class EnvController {
	
	@Autowired
	private ManagerService managerService;
	
	@GetMapping("list")
	public List<EnvInfo> findEnvs() {
		List<CfgEnv> envs = managerService.findEnvs();
		List<EnvInfo> infos = new ArrayList<>();
		for(CfgEnv env:envs) {
			EnvInfo info = new EnvInfo();
			BeanUtils.copyProperties(env, info);
			infos.add(info);
		}
		return infos;
	}
	
}
