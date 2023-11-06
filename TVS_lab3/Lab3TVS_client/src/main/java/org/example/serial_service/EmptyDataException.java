
package org.example.serial_service;

import jakarta.xml.ws.WebFault;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 * 
 */
@WebFault(name = "EmptyDataException", targetNamespace = "http://tx.wsdl.java/")
public class EmptyDataException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private SerialServiceFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public EmptyDataException(String message, SerialServiceFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param cause
     * @param faultInfo
     * @param message
     */
    public EmptyDataException(String message, SerialServiceFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: org.example.SerialServiceFault
     */
    public SerialServiceFault getFaultInfo() {
        return faultInfo;
    }

}
