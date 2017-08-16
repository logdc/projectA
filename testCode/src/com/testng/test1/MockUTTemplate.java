package com.testng.test1;

import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Tested;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by applec on 16/11/8.
 */
public class MockUTTemplate extends AssertJUnit{

	@Mocked ({"loadDataMethodWithParam", "loadDataMethodNoParam"})
	TestServiceAbstract mockedRemote;
	@Mocked ({"loadDataMethodWithParam", "loadDataMethodNoParam"})
	TestServiceABean mockedARemote;
	@Mocked ({"loadDataMethodNoParam"})
	TestServiceBBean mockedBRemote;

	@Tested
	TestTarget testTarget;

	private ResultObject createMockResult(double mockResultKeyValue){
		return new ResultObject(0, mockResultKeyValue);
	}

	@DataProvider(name = "testData1")
	private Object[][] testData1(){
		return new Object[][] {
				{1, createMockResult(2), 5, 9},
				{2, createMockResult(4), 5, 13}
		};
	}
	@Test(groups = {"g_default"}, dataProvider = "testData1")
	public void doTest1 (final long id,
	                    final ResultObject resultObj,
	                    double v,
	                    double expected){

		new NonStrictExpectations(){
			{
				if(TestFactory.create(id) instanceof TestServiceABean){
					mockedARemote.loadDataMethodWithParam(id);
					result = resultObj;
					mockedARemote.loadDataMethodNoParam();
					result = resultObj;
				} else {
					mockedRemote.loadDataMethodWithParam(id);
					result = resultObj;
					mockedRemote.loadDataMethodNoParam();
					result = resultObj;
				}
			}
		};

		double actual = testTarget.calcDummyValue1(id, v);
		assertEquals(expected, actual);
	}


	@DataProvider(name = "testData2")
	private Object[][] testData2(){
		return new Object[][] {
				{createMockResult(4), 5, 9},
				{createMockResult(8), 5, 13}
		};
	}
	@Test(groups = {"g_default"}, dataProvider = "testData2")
	public void doTest2 (
						final ResultObject resultObj,
						double v,
						double expected){

		new NonStrictExpectations(){
			{
				mockedBRemote.loadDataMethodNoParam();
				result = resultObj;
			}
		};

		double actual = TestTarget.calcDummyValue2(v);
		assertEquals(expected, actual);
	}
}
