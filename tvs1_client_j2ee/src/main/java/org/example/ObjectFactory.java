
package org.example;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example package. 
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

    private final static QName _GetSerial_QNAME = new QName("http://example.org/", "getSerial");
    private final static QName _GetSerialResponse_QNAME = new QName("http://example.org/", "getSerialResponse");
    private final static QName _Serial_QNAME = new QName("http://example.org/", "serial");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetSerial }
     * 
     */
    public GetSerial createGetSerial() {
        return new GetSerial();
    }

    /**
     * Create an instance of {@link GetSerialResponse }
     * 
     */
    public GetSerialResponse createGetSerialResponse() {
        return new GetSerialResponse();
    }

    /**
     * Create an instance of {@link Serial }
     * 
     */
    public Serial createSerial() {
        return new Serial();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSerial }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "getSerial")
    public JAXBElement<GetSerial> createGetSerial(GetSerial value) {
        return new JAXBElement<GetSerial>(_GetSerial_QNAME, GetSerial.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSerialResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "getSerialResponse")
    public JAXBElement<GetSerialResponse> createGetSerialResponse(GetSerialResponse value) {
        return new JAXBElement<GetSerialResponse>(_GetSerialResponse_QNAME, GetSerialResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Serial }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "serial")
    public JAXBElement<Serial> createSerial(Serial value) {
        return new JAXBElement<Serial>(_Serial_QNAME, Serial.class, null, value);
    }

}
