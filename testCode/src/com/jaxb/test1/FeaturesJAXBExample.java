package com.jaxb.test1;

import com.jaxb.test1.xsd.pojo.Features;
import com.jaxb.test1.xsd.pojo.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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

		featureCollection.getFeatureMember().add(featureMember);

		features.getFeatureCollection().add(featureCollection);

		return features;
	}

	public static void main(String[] args) {
		Features features = getSampleFeatures();

		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(Features.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(features, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}