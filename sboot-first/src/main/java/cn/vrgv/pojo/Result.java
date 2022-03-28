package cn.vrgv.pojo;


public class Result {
	//响应码
    private int code;
    private Object res;

    public Result(int code, Object res) {
        this.code = code;
        this.res = res;
    }
    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

	public Object getRes() {
		return res;
	}

	public void setRes(Object res) {
		this.res = res;
	}
    
}
