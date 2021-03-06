package com.jaxb.test1.sampleObj;

import com.jaxb.test1.adapters.DateAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@XmlRootElement(name="products")
public class Products implements Serializable{
	private static final long serialVersionUID = -1741379744111211199L;
	private Date testAttr;
	private String testAttr_lab;
	private List<Product> productList;

	public Date getTestAttr() {
		return testAttr;
	}
	@XmlElement
	@XmlJavaTypeAdapter(DateAdapter.class)
	public void setTestAttr(Date testAttr) {
		this.testAttr = testAttr;
	}

	public String getTestAttr_lab() {
		return this.getTestAttr().toString();
	}
	@XmlElement
	public void setTestAttr_lab(String testAttr_lab) {
		this.testAttr_lab = testAttr_lab;
	}

	public List<Product> getProductList() {
		return productList;
	}
	@XmlElement(name="product")
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "Products{" +
				"testAttr=" + testAttr +
				", testAttr_lab='" + testAttr_lab + '\'' +
				", productList=" + productList +
				'}';
	}
}
