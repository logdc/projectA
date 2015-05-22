package com.jaxb.test1.sampleObj;

import com.jaxb.test1.adapters.DoubleAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

//@XmlType (propOrder = {"typeName", "id", "name"})
@XmlRootElement (name="product")
public class Product implements Serializable{
	private static final long serialVersionUID = 1887374656241035767L;
	private long id;
	private String name;
	private String typeName;
	private Double price;
	private Boolean isGood;

	public long getId() {
		return id;
	}
	@XmlElement
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getTypeName() {
		return typeName;
	}
	@XmlElement
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@XmlElement
	@XmlJavaTypeAdapter(DoubleAdapter.class)
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean isGood() {
		return isGood;
	}

	@XmlElement
	public void setGood(Boolean isGood) {
		this.isGood = isGood;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", typeName='" + typeName + '\'' +
				", price=" + price +
				'}';
	}
}
