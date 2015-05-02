package com.annontations.test1;

/**
 * Created by applec on 15/5/2.
 */
@Description(value = "这是一个有用的工具类")
public class Utility {

	@Author(name = "haoran_202", group = Author.groupType.A)
	public String work() {
		return "work over!";
	}
}