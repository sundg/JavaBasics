package action;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Map;

import util.ImageUtil;

public class ValicodeAction extends BaseAction {
	//output
	private InputStream ins;//ͼƬ������

	public String execute(){
		Map<String,BufferedImage> map=ImageUtil.getImage();
		String key=map.keySet().iterator().next();
		//����ȷ����֤��󶨵�session��
		session.put("rightCode", key);
		BufferedImage image=map.get(key);
		ins=ImageUtil.changeImage(image);
		return "success";
	}
	public InputStream getIns() {
		return ins;
	}

	public void setIns(InputStream ins) {
		this.ins = ins;
	}
	
}
