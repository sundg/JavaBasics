package action.fee;

import dao.CostDAO;
import util.DAOFactory;

//处理启用资费请求
public class StartCostAction {
	private Integer id;
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
	public String execute(){
		CostDAO dao=(CostDAO) DAOFactory.getInstance("CostDAO");
		try {
			dao.startFee(id);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
}
