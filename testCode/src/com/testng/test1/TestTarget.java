package com.testng.test1;

/**
 * Created by applec on 16/11/8.
 */
public class TestTarget {

	public double calcDummyValue1 (long id, double v){
		TestServiceRemote remote = TestFactory.create();
		ResultObject result = remote.loadDataMethodWithParam(id);
		ResultObject result2 = remote.loadDataMethodNoParam();
		return v + result.getA() + result2.getA();
	}

	public static double calcDummyValue2 (double v){
		TestServiceRemote remote = TestFactory.create();
		ResultObject result = remote.loadDataMethodNoParam();
		return v + result.getA();
	}

}

class ResultObject{
	private long id;
	private double a;

	public ResultObject(long id, double a) {
		this.id = id;
		this.a = a;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

}

interface TestServiceRemote {
	ResultObject loadDataMethodWithParam(long id);
	ResultObject loadDataMethodNoParam();
}

class TestServiceBean implements TestServiceRemote{

	public ResultObject loadDataMethodWithParam(long id){
		return null;
	}

	public ResultObject loadDataMethodNoParam(){
		return null;
	}
}

class TestFactory{
	public static TestServiceRemote create (){
		return new TestServiceBean();
	}
}
