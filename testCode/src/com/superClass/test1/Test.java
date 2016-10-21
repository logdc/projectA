package com.superClass.test1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by applec on 16/10/21.
 */
public class Test {
	public static void main(String[] args) {
		List<AbstractParent> childTest1List = new ArrayList<AbstractParent>();
		for (int i = 1; i < 10; i++) {
			ChildTest1 test1 = new ChildTest1(111.11 * i, "aaa", 11 * i);
			childTest1List.add(test1);
		}
		ChildTest2 test2 = new ChildTest2(222.22, "bbb", 22);

		System.out.println(AbstractParent.getValue(childTest1List));
//		System.out.println(AbstractParent.getValue(test2));

	}
}
