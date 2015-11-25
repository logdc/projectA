package com.jaxb.test1.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * double adapter for jaxb class config
 * Created by applec on 15/5/7.
 */
public class DoubleAdapter extends XmlAdapter<String, Double> {

	private static final DecimalFormat df = new DecimalFormat("0.##");

	@Override
	public Double unmarshal(String v) throws Exception {
		return (Double) df.parse(v);
	}

	@Override
	public String marshal(Double v) throws Exception {
		return new String(df.format(v));
	}
}