package com.jaxb.test1;

import com.jaxb.test1.sampleObj.Customer;
import com.jaxb.test1.sampleObj.Product;
import com.jaxb.test1.sampleObj.Products;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * main test class to test object (with date and double convert) to xml string
 * @author clb
 */
public class JAXBExampleTest {

	public static Customer getSampleCustomer(){

		Customer customer = new Customer();
		customer.setId(10);
		customer.setName("benson11111");
		customer.setAge(23);
		Products products = new Products();
		products.setTestAttr(Calendar.getInstance().getTime());
		List<Product> productList = new ArrayList<Product>();
		Product product1 = new Product();
		product1.setId(99);
		product1.setName("pro1");
		product1.setTypeName("A");
		product1.setPrice(new Double(23.235234235325323242));
		product1.setGood(true);
		productList.add(product1);
		Product product2 = new Product();
		product2.setId(199);
		product2.setName(null);
		product2.setTypeName("B");
		product2.setPrice(new Double(44.22*4321));
//		product2.setGood(false);
		productList.add(product2);
		products.setProductList(productList);
		customer.setProducts(products);

		return customer;
	}

	public static void main(String[] args) {
		Customer customer = getSampleCustomer();

		try {

		//	File file = new File("/Users/applec/Documents/IdeaProjects/zhengze_test/file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		//	jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);

			System.out.println(customer.toString());

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}