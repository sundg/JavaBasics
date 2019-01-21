package action.fee;

import dao.CostDAO;
import util.DAOFactory;
import entity.Cost;

public class DetailCostAction {
	private Integer id;
	private Cost cost;
	private int page;

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String execute(){
		//调用dao，获取资费对象
		CostDAO dao=(CostDAO) DAOFactory.getInstance("CostDAO");
		try {
			cost=dao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
