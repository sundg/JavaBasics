package action.fee;

import dao.CostDAO;
import util.DAOFactory;
import entity.Cost;

public class AddCostAction {
	private Cost cost;
	private boolean flag;
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}
	public String execute(){
		CostDAO dao =(CostDAO) DAOFactory.getInstance("CostDAO");
		try {
//			System.out.println(cost.getBase_duration());
			Object obj=dao.findByCostName(cost.getName());
			if(obj==null){
				dao.add(cost);
				flag=true;
				return "success";
			}else{
				flag=false;
				return "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
