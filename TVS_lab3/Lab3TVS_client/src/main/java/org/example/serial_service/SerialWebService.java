
package org.example.serial_service;

import java.util.Date;
import java.util.List;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.FaultAction;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 *
 */
@WebService(name = "SerialWebService", targetNamespace = "http://tx.wsdl.java/")
@XmlSeeAlso({
        ObjectFactory.class
})
public interface SerialWebService {


    /**
     *
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @return
     *     returns java.lang.String
     * @throws InvalidDateException
     * @throws NegativeValueException
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertSerial", targetNamespace = "http://tx.wsdl.java/", className = "org.example.serial_service.InsertSerial")
    @ResponseWrapper(localName = "insertSerialResponse", targetNamespace = "http://tx.wsdl.java/", className = "org.example.serial_service.InsertSerialResponse")
    @Action(input = "http://tx.wsdl.java/SerialWebService/insertSerialRequest", output = "http://tx.wsdl.java/SerialWebService/insertSerialResponse", fault = {
            @FaultAction(className = NegativeValueException.class, value = "http://tx.wsdl.java/SerialWebService/insertSerial/Fault/NegativeValueException"),
            @FaultAction(className = InvalidDateException.class, value = "http://tx.wsdl.java/SerialWebService/insertSerial/Fault/InvalidDateException")
    })
    public String insertSerial(
            @WebParam(name = "arg0", targetNamespace = "")
            String arg0,
            @WebParam(name = "arg1", targetNamespace = "")
            String arg1,
            @WebParam(name = "arg2", targetNamespace = "")
            Integer arg2,
            @WebParam(name = "arg3", targetNamespace = "")
            Integer arg3,
            @WebParam(name = "arg4", targetNamespace = "")
            Date arg4)
            throws InvalidDateException, NegativeValueException
    ;

    /**
     *
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @return
     *     returns java.lang.String
     * @throws EmptyDataException
     * @throws InvalidDateException
     * @throws NegativeValueException
     * @throws NonExistentIdException
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateSerial", targetNamespace = "http://tx.wsdl.java/", className = "org.example.serial_service.UpdateSerial")
    @ResponseWrapper(localName = "updateSerialResponse", targetNamespace = "http://tx.wsdl.java/", className = "org.example.serial_service.UpdateSerialResponse")
    @Action(input = "http://tx.wsdl.java/SerialWebService/updateSerialRequest", output = "http://tx.wsdl.java/SerialWebService/updateSerialResponse", fault = {
            @FaultAction(className = NonExistentIdException.class, value = "http://tx.wsdl.java/SerialWebService/updateSerial/Fault/NonExistentIdException"),
            @FaultAction(className = EmptyDataException.class, value = "http://tx.wsdl.java/SerialWebService/updateSerial/Fault/EmptyDataException"),
            @FaultAction(className = NegativeValueException.class, value = "http://tx.wsdl.java/SerialWebService/updateSerial/Fault/NegativeValueException"),
            @FaultAction(className = InvalidDateException.class, value = "http://tx.wsdl.java/SerialWebService/updateSerial/Fault/InvalidDateException")
    })
    public String updateSerial(
            @WebParam(name = "arg0", targetNamespace = "")
            Integer arg0,
            @WebParam(name = "arg1", targetNamespace = "")
            String arg1,
            @WebParam(name = "arg2", targetNamespace = "")
            String arg2,
            @WebParam(name = "arg3", targetNamespace = "")
            Integer arg3,
            @WebParam(name = "arg4", targetNamespace = "")
            Integer arg4,
            @WebParam(name = "arg5", targetNamespace = "")
            Date arg5)
            throws EmptyDataException, InvalidDateException, NegativeValueException, NonExistentIdException
    ;

    /**
     *
     * @param arg0
     * @return
     *     returns java.lang.Integer
     * @throws NonExistentIdException
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteSerial", targetNamespace = "http://tx.wsdl.java/", className = "org.example.serial_service.DeleteSerial")
    @ResponseWrapper(localName = "deleteSerialResponse", targetNamespace = "http://tx.wsdl.java/", className = "org.example.serial_service.DeleteSerialResponse")
    @Action(input = "http://tx.wsdl.java/SerialWebService/deleteSerialRequest", output = "http://tx.wsdl.java/SerialWebService/deleteSerialResponse", fault = {
            @FaultAction(className = NonExistentIdException.class, value = "http://tx.wsdl.java/SerialWebService/deleteSerial/Fault/NonExistentIdException")
    })
    public Integer deleteSerial(
            @WebParam(name = "arg0", targetNamespace = "")
            Integer arg0)
            throws NonExistentIdException
    ;

    /**
     *
     * @return
     *     returns java.util.List<org.example.Serial>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getSerial", targetNamespace = "http://tx.wsdl.java/", className = "org.example.serial_service.GetSerial")
    @ResponseWrapper(localName = "getSerialResponse", targetNamespace = "http://tx.wsdl.java/", className = "org.example.serial_service.GetSerialResponse")
    @Action(input = "http://tx.wsdl.java/SerialWebService/getSerialRequest", output = "http://tx.wsdl.java/SerialWebService/getSerialResponse")
    public List<Serial> getSerial();

}
