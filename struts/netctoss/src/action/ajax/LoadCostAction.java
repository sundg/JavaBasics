package action.ajax;

import java.util.List;

import dao.CostDAO;

import util.ConfigUtil;
import util.DAOFactory;

import entity.Cost;

public class LoadCostAction {
	private Integer page;//Ò³Âë
	private String colm;//ÅÅÐò×Ö¶Î
	private String sort;//ÅÅÐò·½Ê½
	private List<Cost> list;
	
	public String loadCost(){
		CostDAO dao=(CostDAO) DAOFactory.getInstance("CostDAO");
		int pagesize=Integer.parseInt(ConfigUtil.getValue("pagesize"));
		try {
			list=dao.findAll(page,pagesize, colm, sort);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	
	
	
	
	
	
	
	
	
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public String getColm() {
		return colm;
	}
	public void setColm(String colm) {
		this.colm = colm;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public List<Cost> getList() {
		return list;
	}
	public void setList(List<Cost> list) {
		this.list = list;
	}
	
}
