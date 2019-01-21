package action.fee;


import dao.CostDAO;

import util.DAOFactory;


public class DelCostAction {
	private Integer id;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
	public String execute(){
		CostDAO dao=(CostDAO) DAOFactory.getInstance("CostDAO");
		try {
			boolean isDel=dao.del(id);
			if(isDel){
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
