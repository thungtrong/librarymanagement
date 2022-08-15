package com.tdtu.ktcn.librarymanagement.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DashBoardModel implements Serializable {
	private List<Info> list;
	
	public DashBoardModel() {
		this.list = new ArrayList<Info>();
	}
	
	public DashBoardModel add(Info value)
	{
		this.list.add(value);
		return this;
	}
	

	public List<Info> getList() {
		return list;
	}

	public void setList(List<Info> list) {
		this.list = list;
	}





	public static class Info
	{
		String key;
		String displayname;
		Long count;
		
		public Info() {
			
		}



		public Info(String key, String displayname, Long count) {
			super();
			this.key = key;
			this.displayname = displayname;
			this.count = count;
		}


		public String getDisplayname() {
			return displayname;
		}
		public void setDisplayname(String displayname) {
			this.displayname = displayname;
		}
		public Long getCount() {
			return count;
		}
		public void setCount(Long count) {
			this.count = count;
		}
		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}
		
	}
}
