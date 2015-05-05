
package com.jaxb.test2.xsd.generatedBeans;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.jaxb.test1.xsd.generatedBeans package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.jaxb.test1.xsd.generatedBeans
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Features }
     * 
     */
    public Features createFeatures() {
        return new Features();
    }

    /**
     * Create an instance of {@link Features.FeatureCollection }
     * 
     */
    public Features.FeatureCollection createFeaturesFeatureCollection() {
        return new Features.FeatureCollection();
    }

    /**
     * Create an instance of {@link Features.FeatureCollection.FeatureMember }
     * 
     */
    public Features.FeatureCollection.FeatureMember createFeaturesFeatureCollectionFeatureMember() {
        return new Features.FeatureCollection.FeatureMember();
    }

    /**
     * Create an instance of {@link Features.FeatureCollection.FeatureMember.Road }
     * 
     */
    public Features.FeatureCollection.FeatureMember.Road createFeaturesFeatureCollectionFeatureMemberRoad() {
        return new Features.FeatureCollection.FeatureMember.Road();
    }

}
