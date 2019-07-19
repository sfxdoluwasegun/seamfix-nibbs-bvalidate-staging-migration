/**
 * BVNValidationWebServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.nibss.bvn.validation;

public class BVNValidationWebServiceLocator extends org.apache.axis.client.Service implements com.nibss.bvn.validation.BVNValidationWebService {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BVNValidationWebServiceLocator() {
    }


    public BVNValidationWebServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BVNValidationWebServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BVNValidationWebServicePort
    private java.lang.String BVNValidationWebServicePort_address = "http://196.6.103.58:8080/bvnV/bvnV";

    public java.lang.String getBVNValidationWebServicePortAddress() {
        return BVNValidationWebServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BVNValidationWebServicePortWSDDServiceName = "BVNValidationWebServicePort";

    public java.lang.String getBVNValidationWebServicePortWSDDServiceName() {
        return BVNValidationWebServicePortWSDDServiceName;
    }

    public void setBVNValidationWebServicePortWSDDServiceName(java.lang.String name) {
        BVNValidationWebServicePortWSDDServiceName = name;
    }

    public com.nibss.bvn.validation.IBVNValidationService getBVNValidationWebServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BVNValidationWebServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBVNValidationWebServicePort(endpoint);
    }

    public com.nibss.bvn.validation.IBVNValidationService getBVNValidationWebServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.nibss.bvn.validation.BVNValidationWebServiceSoapBindingStub _stub = new com.nibss.bvn.validation.BVNValidationWebServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getBVNValidationWebServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBVNValidationWebServicePortEndpointAddress(java.lang.String address) {
        BVNValidationWebServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(@SuppressWarnings("rawtypes") Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.nibss.bvn.validation.IBVNValidationService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.nibss.bvn.validation.BVNValidationWebServiceSoapBindingStub _stub = new com.nibss.bvn.validation.BVNValidationWebServiceSoapBindingStub(new java.net.URL(BVNValidationWebServicePort_address), this);
                _stub.setPortName(getBVNValidationWebServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, @SuppressWarnings("rawtypes") Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BVNValidationWebServicePort".equals(inputPortName)) {
            return getBVNValidationWebServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://validation.bvn.nibss.com/", "BVNValidationWebService");
    }

    @SuppressWarnings("rawtypes") private java.util.HashSet ports = null;

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://validation.bvn.nibss.com/", "BVNValidationWebServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BVNValidationWebServicePort".equals(portName)) {
            setBVNValidationWebServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
