
package com.jaxb.test2.xsd.generatedBeans;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="networkName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FeatureCollection" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="featureMember" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Road">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="lineId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                                       &lt;element name="lineName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="passNodeIds" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                                       &lt;element name="passNodeNames" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                                       &lt;element name="passNodeCoordinates" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "networkName",
    "featureCollection"
})
@XmlRootElement(name = "Features")
public class Features {

    protected String networkName;
    @XmlElement(name = "FeatureCollection", required = true)
    protected List<Features.FeatureCollection> featureCollection;

    /**
     * 获取networkName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNetworkName() {
        return networkName;
    }

    /**
     * 设置networkName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNetworkName(String value) {
        this.networkName = value;
    }

    /**
     * Gets the value of the featureCollection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the featureCollection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeatureCollection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Features.FeatureCollection }
     * 
     * 
     */
    public List<Features.FeatureCollection> getFeatureCollection() {
        if (featureCollection == null) {
            featureCollection = new ArrayList<Features.FeatureCollection>();
        }
        return this.featureCollection;
    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="featureMember" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Road">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="lineId" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *                             &lt;element name="lineName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="passNodeIds" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *                             &lt;element name="passNodeNames" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *                             &lt;element name="passNodeCoordinates" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "featureMember"
    })
    @XmlRootElement(name = "FeatureCollection")
    public static class FeatureCollection {

        @XmlElement(required = true)
        protected List<Features.FeatureCollection.FeatureMember> featureMember;

        /**
         * Gets the value of the featureMember property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the featureMember property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFeatureMember().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Features.FeatureCollection.FeatureMember }
         * 
         * 
         */
        public List<Features.FeatureCollection.FeatureMember> getFeatureMember() {
            if (featureMember == null) {
                featureMember = new ArrayList<Features.FeatureCollection.FeatureMember>();
            }
            return this.featureMember;
        }


        /**
         * <p>anonymous complex type的 Java 类。
         * 
         * <p>以下模式片段指定包含在此类中的预期内容。
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Road">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="lineId" type="{http://www.w3.org/2001/XMLSchema}long"/>
         *                   &lt;element name="lineName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="passNodeIds" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
         *                   &lt;element name="passNodeNames" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
         *                   &lt;element name="passNodeCoordinates" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "road"
        })
        public static class FeatureMember {

            @XmlElement(name = "Road", required = true)
            protected Features.FeatureCollection.FeatureMember.Road road;

            /**
             * 获取road属性的值。
             * 
             * @return
             *     possible object is
             *     {@link Features.FeatureCollection.FeatureMember.Road }
             *     
             */
            public Features.FeatureCollection.FeatureMember.Road getRoad() {
                return road;
            }

            /**
             * 设置road属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link Features.FeatureCollection.FeatureMember.Road }
             *     
             */
            public void setRoad(Features.FeatureCollection.FeatureMember.Road value) {
                this.road = value;
            }


            /**
             * <p>anonymous complex type的 Java 类。
             * 
             * <p>以下模式片段指定包含在此类中的预期内容。
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="lineId" type="{http://www.w3.org/2001/XMLSchema}long"/>
             *         &lt;element name="lineName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="passNodeIds" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
             *         &lt;element name="passNodeNames" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
             *         &lt;element name="passNodeCoordinates" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "lineId",
                "lineName",
                "passNodeIds",
                "passNodeNames",
                "passNodeCoordinates"
            })
            public static class Road {

                protected long lineId;
                protected String lineName;
                @XmlElement(required = true)
                protected Object passNodeIds;
                @XmlElement(required = true)
                protected Object passNodeNames;
                @XmlElement(required = true)
                protected Object passNodeCoordinates;

                /**
                 * 获取lineId属性的值。
                 * 
                 */
                public long getLineId() {
                    return lineId;
                }

                /**
                 * 设置lineId属性的值。
                 * 
                 */
                public void setLineId(long value) {
                    this.lineId = value;
                }

                /**
                 * 获取lineName属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLineName() {
                    return lineName;
                }

                /**
                 * 设置lineName属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLineName(String value) {
                    this.lineName = value;
                }

                /**
                 * 获取passNodeIds属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link Object }
                 *     
                 */
                public Object getPassNodeIds() {
                    return passNodeIds;
                }

                /**
                 * 设置passNodeIds属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Object }
                 *     
                 */
                public void setPassNodeIds(Object value) {
                    this.passNodeIds = value;
                }

                /**
                 * 获取passNodeNames属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link Object }
                 *     
                 */
                public Object getPassNodeNames() {
                    return passNodeNames;
                }

                /**
                 * 设置passNodeNames属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Object }
                 *     
                 */
                public void setPassNodeNames(Object value) {
                    this.passNodeNames = value;
                }

                /**
                 * 获取passNodeCoordinates属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link Object }
                 *     
                 */
                public Object getPassNodeCoordinates() {
                    return passNodeCoordinates;
                }

                /**
                 * 设置passNodeCoordinates属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Object }
                 *     
                 */
                public void setPassNodeCoordinates(Object value) {
                    this.passNodeCoordinates = value;
                }

            }

        }

    }

}
