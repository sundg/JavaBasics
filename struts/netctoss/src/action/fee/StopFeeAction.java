package action.fee;

import dao.CostDAO;
import util.DAOFactory;

public class StopFeeAction {
	private Integer id;
	private Integer page;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	
	public String execute(){
		CostDAO dao=(CostDAO) DAOFactory.getInstance("CostDAO");
		try {
			dao.stopFee(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
}
