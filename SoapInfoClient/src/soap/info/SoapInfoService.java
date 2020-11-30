/**
 * SoapInfoService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package soap.info;

public interface SoapInfoService extends javax.xml.rpc.Service {
    public java.lang.String getSoapInfoAddress();

    public soap.info.SoapInfo getSoapInfo() throws javax.xml.rpc.ServiceException;

    public soap.info.SoapInfo getSoapInfo(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
