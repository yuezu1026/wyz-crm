package service.reg.entity;

public class ResponseData<T> {
	
	private T data;
	
	private boolean success;
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
