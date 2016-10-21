package com.superClass.test1;

/**
 * Created by applec on 16/10/21.
 */
public class ChildTest2 extends AbstractParent {

	private double money;
	private String name;
	private long idB;

	public ChildTest2(double money, String name, long idB) {
		this.money = money;
		this.name = name;
		this.idB = idB;
	}

	public ChildTest2(double money) {
		this.money = money;
	}

	public long getIdB() {
		return idB;
	}

	public void setIdB(long idB) {
		this.idB = idB;
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
