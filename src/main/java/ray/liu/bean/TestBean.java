package ray.liu.bean;

import java.sql.Timestamp;

public class TestBean {
	private int id;
	private String something;
	private Timestamp timestamp;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSomething() {
		return something;
	}
	public void setSomething(String something) {
		this.something = something;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "TestBean [id=" + id + ", something=" + something + ", timestamp=" + timestamp + "]";
	}
	
	
	
}
