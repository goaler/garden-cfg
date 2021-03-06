package org.garden.cfg.controller;

import java.util.ArrayList;
import java.util.List;

import org.garden.cfg.controller.obj.PropInfo;
import org.garden.cfg.core.repository.entity.CfgItem;
import org.garden.cfg.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doc")
public class DocController {

	@Autowired
	private ManagerService managerService;

	@GetMapping("/props/{docId}")
	public List<PropInfo> getDocProps(@PathVariable String docId) {
		List<CfgItem> props = managerService.getDocProps(docId);
		List<PropInfo> rets = new ArrayList<>();
		for (CfgItem p : props) {
			rets.add(new PropInfo(p));
		}

		return rets;
	}
	
	@PostMapping("/props/{docId}")
	public boolean addProps(@PathVariable String docId, @RequestBody List<PropInfo> props) {
		return managerService.addDocProps(docId, props);
	}
	
	@DeleteMapping("/props/{docId}")
	public boolean deleteProps(@PathVariable String docId, @RequestBody List<Integer> propIds) {
		return managerService.deleteDocProps(docId, propIds);
	}
	
	@PutMapping("/props/{docId}")
	public boolean updateProps(@PathVariable String docId, @RequestBody List<PropInfo> props) {
		return managerService.updateDocProps(docId, props);
	}

}
