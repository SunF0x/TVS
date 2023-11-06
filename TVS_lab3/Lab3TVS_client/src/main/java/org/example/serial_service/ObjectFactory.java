
package org.example.serial_service;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

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

    private static final QName _DeleteSerial_QNAME = new QName("http://tx.wsdl.java/", "deleteSerial");
    private static final QName _DeleteSerialResponse_QNAME = new QName("http://tx.wsdl.java/", "deleteSerialResponse");
    private static final QName _GetSerial_QNAME = new QName("http://tx.wsdl.java/", "getSerial");
    private static final QName _GetSerialResponse_QNAME = new QName("http://tx.wsdl.java/", "getSerialResponse");
    private static final QName _InsertSerial_QNAME = new QName("http://tx.wsdl.java/", "insertSerial");
    private static final QName _InsertSerialResponse_QNAME = new QName("http://tx.wsdl.java/", "insertSerialResponse");
    private static final QName _UpdateSerial_QNAME = new QName("http://tx.wsdl.java/", "updateSerial");
    private static final QName _UpdateSerialResponse_QNAME = new QName("http://tx.wsdl.java/", "updateSerialResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteSerial }
     * 
     * @return
     *     the new instance of {@link DeleteSerial }
     */
    public DeleteSerial createDeleteSerial() {
        return new DeleteSerial();
    }

    /**
     * Create an instance of {@link DeleteSerialResponse }
     * 
     * @return
     *     the new instance of {@link DeleteSerialResponse }
     */
    public DeleteSerialResponse createDeleteSerialResponse() {
        return new DeleteSerialResponse();
    }

    /**
     * Create an instance of {@link org.example.GetSerial }
     * 
     * @return
     *     the new instance of {@link org.example.GetSerial }
     */
    public GetSerial createGetSerial() {
        return new GetSerial();
    }

    /**
     * Create an instance of {@link org.example.GetSerialResponse }
     * 
     * @return
     *     the new instance of {@link org.example.GetSerialResponse }
     */
    public GetSerialResponse createGetSerialResponse() {
        return new GetSerialResponse();
    }

    /**
     * Create an instance of {@link org.example.InsertSerial }
     * 
     * @return
     *     the new instance of {@link org.example.InsertSerial }
     */
    public InsertSerial createInsertSerial() {
        return new InsertSerial();
    }

    /**
     * Create an instance of {@link org.example.InsertSerialResponse }
     * 
     * @return
     *     the new instance of {@link org.example.InsertSerialResponse }
     */
    public InsertSerialResponse createInsertSerialResponse() {
        return new InsertSerialResponse();
    }

    /**
     * Create an instance of {@link UpdateSerial }
     * 
     * @return
     *     the new instance of {@link UpdateSerial }
     */
    public UpdateSerial createUpdateSerial() {
        return new UpdateSerial();
    }

    /**
     * Create an instance of {@link UpdateSerialResponse }
     * 
     * @return
     *     the new instance of {@link UpdateSerialResponse }
     */
    public UpdateSerialResponse createUpdateSerialResponse() {
        return new UpdateSerialResponse();
    }

    /**
     * Create an instance of {@link Serial }
     * 
     * @return
     *     the new instance of {@link Serial }
     */
    public Serial createSerial() {
        return new Serial();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSerial }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteSerial }{@code >}
     */
    @XmlElementDecl(namespace = "http://tx.wsdl.java/", name = "deleteSerial")
    public JAXBElement<DeleteSerial> createDeleteSerial(DeleteSerial value) {
        return new JAXBElement<>(_DeleteSerial_QNAME, DeleteSerial.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSerialResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteSerialResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://tx.wsdl.java/", name = "deleteSerialResponse")
    public JAXBElement<DeleteSerialResponse> createDeleteSerialResponse(DeleteSerialResponse value) {
        return new JAXBElement<>(_DeleteSerialResponse_QNAME, DeleteSerialResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.example.GetSerial }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link org.example.GetSerial }{@code >}
     */
    @XmlElementDecl(namespace = "http://tx.wsdl.java/", name = "getSerial")
    public JAXBElement<GetSerial> createGetSerial(GetSerial value) {
        return new JAXBElement<>(_GetSerial_QNAME, GetSerial.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.example.GetSerialResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link org.example.GetSerialResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://tx.wsdl.java/", name = "getSerialResponse")
    public JAXBElement<GetSerialResponse> createGetSerialResponse(GetSerialResponse value) {
        return new JAXBElement<>(_GetSerialResponse_QNAME, GetSerialResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.example.InsertSerial }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link org.example.InsertSerial }{@code >}
     */
    @XmlElementDecl(namespace = "http://tx.wsdl.java/", name = "insertSerial")
    public JAXBElement<InsertSerial> createInsertSerial(InsertSerial value) {
        return new JAXBElement<>(_InsertSerial_QNAME, InsertSerial.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.example.InsertSerialResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link org.example.InsertSerialResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://tx.wsdl.java/", name = "insertSerialResponse")
    public JAXBElement<InsertSerialResponse> createInsertSerialResponse(InsertSerialResponse value) {
        return new JAXBElement<>(_InsertSerialResponse_QNAME, InsertSerialResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateSerial }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateSerial }{@code >}
     */
    @XmlElementDecl(namespace = "http://tx.wsdl.java/", name = "updateSerial")
    public JAXBElement<UpdateSerial> createUpdateSerial(UpdateSerial value) {
        return new JAXBElement<>(_UpdateSerial_QNAME, UpdateSerial.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateSerialResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateSerialResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://tx.wsdl.java/", name = "updateSerialResponse")
    public JAXBElement<UpdateSerialResponse> createUpdateSerialResponse(UpdateSerialResponse value) {
        return new JAXBElement<>(_UpdateSerialResponse_QNAME, UpdateSerialResponse.class, null, value);
    }

}
