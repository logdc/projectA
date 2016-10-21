package com.superClass.test1;

/**
 * Created by applec on 16/10/21.
 */
public class ChildTest1 extends AbstractParent {

	private double money;
	private String name;
	private long idA;

	public ChildTest1(double money, String name, long idA) {
		this.money = money;
		this.name = name;
		this.idA = idA;
	}

	public long getIdA() {
		return idA;
	}

	public void setIdA(long idA) {
		this.idA = idA;
	}

	@Override
	public double getMoney() {
		return money;
	}

	@Override
	public void setMoney(double money) {
		this.money = money;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
