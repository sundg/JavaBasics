package action.fee;

import dao.CostDAO;
import util.DAOFactory;
import entity.Cost;

public class UpdateLoadAction {
	private int id;
	private Cost cost;
	private boolean flag;
	private int page;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	/*
	 * 加载更新页面
	 */
	public String load(){
		CostDAO dao=(CostDAO) DAOFactory.getInstance("CostDAO");
		try {
			dao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String update(){
		CostDAO dao=(CostDAO) DAOFactory.getInstance("CostDAO");
		try {
			dao.update(cost);
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cost getCost() {
		return cost;
	}
	public void setCost(Cost cost) {
		this.cost = cost;
	}
}
