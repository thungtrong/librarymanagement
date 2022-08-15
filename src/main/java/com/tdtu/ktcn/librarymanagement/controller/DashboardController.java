package com.tdtu.ktcn.librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tdtu.ktcn.librarymanagement.model.DashBoardModel;
import com.tdtu.ktcn.librarymanagement.service.DashBoardService;

@CrossOrigin(origins = { ConfigController.ORIGIN })
@RestController
@RequestMapping("dashboard")
public class DashboardController {
	private DashBoardService service;
	@Autowired
	public DashboardController(DashBoardService service) {
		this.service = service;
	}
	
	@GetMapping("")
	public DashBoardModel getInfo()
	{
		return service.getInfo();
	}
}
