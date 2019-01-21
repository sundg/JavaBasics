package action.fee;

import java.util.Timer;
import java.util.TimerTask;

import dao.CostDAO;
import util.DAOFactory;
import entity.Cost;

public class UpdateCostAction {
	private Integer page;
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
	private Cost cost;

	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}
	public String execute(){
		CostDAO dao=(CostDAO) DAOFactory.getInstance("CostDAO");
		try {
		 boolean flag=dao.update(cost);
		 Thread.sleep(3000);
			if(flag){
				return "success";
			}else{
				return "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
