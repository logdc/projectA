package com.md5.test1;

import com.transfer.object.ObjectUtil;
import com.jaxb.test1.sampleObj.Customer;
import com.jaxb.test1.JAXBExample;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class BASE64Test {
	public static void main(String[] args) {

		Customer customer = JAXBExample.getSampleCustomer();


		// test base64 encoding and decoding
		try {

			// encode from obj to string
			BASE64Encoder encoder = new BASE64Encoder();
			String codeStr = encoder.encode(ObjectUtil.serialize(customer));

			// show encoded string
			System.out.println("---------------------------------");
			System.out.println(codeStr);

			// try to decode string to original object.
			BASE64Decoder base64Decoder = new BASE64Decoder();
			byte[] b = base64Decoder.decodeBuffer(codeStr);

			// TODO code below can be replaced by ObjectUtil#deserialize
			ByteArrayInputStream bis = new ByteArrayInputStream(b);
			ObjectInputStream ois = new ObjectInputStream(bis);
			ois.readObject();
			System.out.println("---------------------------------");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}



	}
}