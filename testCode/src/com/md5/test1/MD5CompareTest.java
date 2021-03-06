package com.md5.test1;

import com.transfer.object.ObjectSizeCalculator;
import com.transfer.object.ObjectUtil;
import com.jaxb.test1.sampleObj.Customer;
import com.jaxb.test1.JAXBExampleTest;

import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * test md5 encode and compare the result generated each time
 *  Note that a result file would be put on disk each execution
 * Created by applec on 15/4/30.
 */
public class MD5CompareTest {
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException, IllegalAccessException {
		// get sample object
		Customer customer = JAXBExampleTest.getSampleCustomer();

		// try to convert the object with MD5
		byte[] b = ObjectUtil.serialize(customer);
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(b);
		byte[] resultByteArray = messageDigest.digest();


		// get object size in bytes
		long objSize = ObjectSizeCalculator.sizeOf(customer);


		// print the object size and md5 string
		System.out.println(objSize);
		String objMD5Str = byteArrayToHex(resultByteArray);
		System.out.println(objMD5Str);

		// write to a doc for compare each time
		String path = "/Users/applec/Documents/IdeaProjects/projectA/tmp/md5compare.txt";
		FileWriter writer = new FileWriter(path, true);
		writer.write(objSize + objMD5Str + "\n");
		writer.close();

	}
	public static String byteArrayToHex(byte[] byteArray) {

		// 首先初始化一个字符数组，用来存放每个16进制字符
		char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };

		// new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
		char[] resultCharArray =new char[byteArray.length * 2];

		// 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
		int index = 0;
		for (byte b : byteArray) {
			resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];
			resultCharArray[index++] = hexDigits[b& 0xf];
		}

		// 字符数组组合成字符串返回
		return new String(resultCharArray);
	}
}
