package action.fee;


import dao.CostDAO;
import util.DAOFactory;
import entity.Cost;

public class ModifyCostAction {
	private Integer id;
	private Cost cost;
	private Integer page;
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}

	public String execute(){
		CostDAO dao=(CostDAO) DAOFactory.getInstance("CostDAO");
		try {
			 cost=dao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
}
