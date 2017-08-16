package com.testng.test1;

/**
 * Created by applec on 16/11/8.
 */
public class TestTarget {

	public double calcDummyValue1 (long id, double v){
		TestServiceRemote remote = TestFactory.create(id);
		System.out.println("Remote: " + remote);
		ResultObject result = remote.loadDataMethodWithParam(id);
		ResultObject result2 = remote.loadDataMethodNoParam();
		return v + result.getA() + result2.getA();
	}

	public static double calcDummyValue2 (double v){
		TestServiceRemote remote = TestFactory.create(2);
		ResultObject result = remote.loadDataMethodNoParam();
		return v + result.getA();
	}

	public static void main(String[] args) {
		System.out.println(new TestTarget().calcDummyValue1(2, 5));
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
abstract class TestServiceAbstract implements TestServiceRemote{
	public ResultObject loadDataMethodWithParam(long id){
		return new ResultObject(11111, 11111);
	}
	public ResultObject loadDataMethodNoParam(){
		return new ResultObject(22222, 22222);
	}
}

class TestServiceABean extends TestServiceAbstract{

	public ResultObject loadDataMethodWithParam(long id){
		return new ResultObject(55555, 55555);
	}

	public ResultObject loadDataMethodNoParam(){
		return new ResultObject(88888, 88888);
	}
}

class TestServiceBBean extends TestServiceAbstract{

	public ResultObject loadDataMethodNoParam(){
		return new ResultObject(99999, 99999);
	}
}

class TestFactory{
	/**
	 *
	 * @param id 1==A, 2==B
	 * @return
	 */
	public static TestServiceRemote create (long id){
		if(id % 2 == 0){
			return new TestServiceBBean();
		}
		return new TestServiceABean();
	}
}
