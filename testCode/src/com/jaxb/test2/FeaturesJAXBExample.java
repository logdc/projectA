package com.jaxb.test2;

import com.jaxb.test2.xsd.generatedBeans.Features;
import com.jaxb.test2.xsd.generatedBeans.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.Date;

public class FeaturesJAXBExample {

	public static Features getSampleFeatures(){
		ObjectFactory of = new ObjectFactory();
		Features features = of.createFeatures();
		features.setNetworkName("net1");

		Features.FeatureCollection featureCollection = of.createFeaturesFeatureCollection();

		Features.FeatureCollection.FeatureMember featureMember = of.createFeaturesFeatureCollectionFeatureMember();
		Features.FeatureCollection.FeatureMember.Road road = of.createFeaturesFeatureCollectionFeatureMemberRoad();
//		road.setLineId(new Long(23));
		road.setLineName("lineName11");
		road.setPassNodeCoordinates(new Date());
		featureMember.setRoad(road);

		for (int i = 0; i < 1; i++) {
			featureCollection.getFeatureMember().add(featureMember);
		}

		features.getFeatureCollection().add(featureCollection);

		return features;
	}

	private static final String XML_PATH = "/Users/applec/Documents/IdeaProjects/projectA/tmp/FeaturesJAXBExample.xml";

	private static void normalMarshal(){
		Features features = getSampleFeatures();

		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(Features.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
//			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //编码格式
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xm头声明信息

			jaxbMarshaller.marshal(features, new File(XML_PATH));
//			jaxbMarshaller.marshal(features, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	private static void streamMarshal() throws JAXBException, FileNotFoundException, XMLStreamException {
		// Step 1. 创建JAXB上下文

		JAXBContext context = JAXBContext.newInstance(Features.class);

		// Step 2. 创建Marshaller
		Marshaller marshaller = context.createMarshaller();
//		marshaller.setProperty(Marshaller.JAXB_ENCODING, "GBK");
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
		//marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "");

		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

		// Step 3. 使用StAX写入开始标签和基本信息。
//		XmlSchema xmlSchema = Features.class.getPackage().getAnnotation(
//				XmlSchema.class);
//		String ns = xmlSchema.namespace();
//		System.out.println(xmlSchema.namespace());
		ObjectFactory of = new ObjectFactory();

		XMLOutputFactory output = XMLOutputFactory.newInstance();
//		output.setProperty(XMLOutputFactory.IS_REPAIRING_NAMESPACES, true);
		File file = new File(XML_PATH);
		OutputStream out = new FileOutputStream(file);
		XMLStreamWriter writer = output.createXMLStreamWriter(out, "UTF-8");

		writer.writeStartDocument();
//		writer.setDefaultNamespace(ns);
		writer.writeStartElement("Features");

		// Step 4. 使用JaXB写入循环的大量记录
		for (int i = 0; i < 3; i++) {

			// Step 4.1. 准备需要的JavaBean（比如查询数据库）
			Features.FeatureCollection featureCollection = of.createFeaturesFeatureCollection();

			Features.FeatureCollection.FeatureMember featureMember = of.createFeaturesFeatureCollectionFeatureMember();
			Features.FeatureCollection.FeatureMember.Road road = of.createFeaturesFeatureCollectionFeatureMemberRoad();
//		road.setLineId(new Long(23));
			road.setLineName("lineName11");
			road.setPassNodeCoordinates(new Date());
			featureMember.setRoad(road);

			for (int ij = 0; ij < 2; ij++) {
				featureCollection.getFeatureMember().add(featureMember);
			}

			// 计算当前记录转换成XML后的长度（注意:会)
//			StringWriter w = new StringWriter();
//			marshaller.marshal(featureCollection, w);
//			int curRecLength = w.getBuffer().length();
//			System.out.println("当前记录的长度为(含xmlns)：" + curRecLength);
//			System.out.println(w);

			// Step 4. 转换并输出
			marshaller.marshal(featureCollection, writer);

			writer.flush();
//			System.out.println("XML 文件当前记录长度 (仅根元素含xmlns)= " + file.length());

		}
		// 写入结束标签
		writer.writeEndElement();
		writer.writeEndDocument();
		writer.flush();
	}

	public static void main(String[] args) {
//		normalMarshal();
		try {
			streamMarshal();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
}