package com.superClass.test1;

import java.util.List;

/**
 * Created by applec on 16/10/21.
 */
public abstract class AbstractParent {

	protected abstract double getMoney();
	protected abstract void setMoney(double money);

	protected abstract String getName();
	protected abstract void setName(String name);

	public static double getValue(List<AbstractParent> abstractParentList){
		double num = 0;
		for(AbstractParent abstractParent : abstractParentList){
			num += abstractParent.getMoney();
			if(abstractParent instanceof ChildTest1){
				System.out.println(((ChildTest1)abstractParent).getIdA());
			}
		}
		return num;
	}

}
