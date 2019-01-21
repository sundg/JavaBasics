package action;

import java.util.List;

import dao.CostDAO;

import util.ConfigUtil;
import util.DAOFactory;
import entity.Cost;

public class FeeListAction {
	private List<Cost>  list;
	private Integer page=1;//Ò³Âë
	private int totalPages;//×ÜÒ³Êý

	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}


	public int getTotalPages() {
		return totalPages;
	}


	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}


	public List<Cost> getList() {
		return list;
	}


	public void setList(List<Cost> list) {
		this.list = list;
	}


	public String execute(){
		CostDAO dao=(CostDAO) DAOFactory.getInstance("CostDAO");
		try {
			if(page==null){
				page=1;
			}
			list=dao.findAll(page,3,null,null);
			totalPages=dao.getTotalPages(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
		
	}
}
