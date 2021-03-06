package org.garden.cfg.controller;

import java.util.ArrayList;
import java.util.List;

import org.garden.cfg.controller.obj.AppInfo;
import org.garden.cfg.controller.obj.DocInfo;
import org.garden.cfg.core.repository.entity.CfgApp;
import org.garden.cfg.core.repository.entity.CfgDoc;
import org.garden.cfg.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app")
public class AppController {
	
	@Autowired
	private ManagerService managerService;
	
	@GetMapping("info")
	public AppInfo getAppInfo(String appCode) {
		
		CfgApp app = managerService.getApp(appCode);
		AppInfo info = new AppInfo(app);
		return info;
	}
	
	@GetMapping("list")
	public List<AppInfo> getOwnAppList(@RequestAttribute String userCode){
		List<AppInfo> list = new ArrayList<>();
		List<CfgApp> apps = managerService.getOwnAppList(userCode);
		for(CfgApp app:apps) {
			list.add(new AppInfo(app));
		}
		return list;
	}
	
	@GetMapping("docs")
	public List<DocInfo> findDocs(String appCode, String envCode, String clusterCode){
		List<CfgDoc> docs = managerService.findDocs(appCode, envCode, clusterCode);
		List<DocInfo> rets = new ArrayList<>();
		for(CfgDoc doc:docs) {
			rets.add(new DocInfo(doc));
		}
		return rets; 
	}
	
}
