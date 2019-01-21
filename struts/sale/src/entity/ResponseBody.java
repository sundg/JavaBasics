package entity;

public class ResponseBody {
	private String code;//0 1
	private String msg;//√Ë ˆ–≈œ¢
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public ResponseBody(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public ResponseBody() {
	}
	
}
