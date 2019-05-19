package javabean;

import java.util.ArrayList;

public class SetOfPhones {
	private long num;
	ArrayList<PhoneInfo> set = new ArrayList<>();
	
	public SetOfPhones() {
		super();
	}

	public SetOfPhones(long num, ArrayList<PhoneInfo> set) {
		super();
		this.num = num;
		this.set = set;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public ArrayList<PhoneInfo> getSet() {
		return set;
	}

	public void setSet(ArrayList<PhoneInfo> set) {
		this.set = set;
	}
	
}
