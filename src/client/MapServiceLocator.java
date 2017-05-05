/**
 * MapServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package client;

public class MapServiceLocator extends org.apache.axis.client.Service implements client.MapService {

    public MapServiceLocator() {
    }


    public MapServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MapServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Map
    private java.lang.String Map_address = "http://localhost:8080//services/Map";

    public java.lang.String getMapAddress() {
        return Map_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MapWSDDServiceName = "Map";

    public java.lang.String getMapWSDDServiceName() {
        return MapWSDDServiceName;
    }

    public void setMapWSDDServiceName(java.lang.String name) {
        MapWSDDServiceName = name;
    }

    public client.Map_PortType getMap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Map_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMap(endpoint);
    }

    public client.Map_PortType getMap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            client.MapSoapBindingStub _stub = new client.MapSoapBindingStub(portAddress, this);
            _stub.setPortName(getMapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMapEndpointAddress(java.lang.String address) {
        Map_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (client.Map_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                client.MapSoapBindingStub _stub = new client.MapSoapBindingStub(new java.net.URL(Map_address), this);
                _stub.setPortName(getMapWSDDServiceName());
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
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Map".equals(inputPortName)) {
            return getMap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://server", "MapService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://server", "Map"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Map".equals(portName)) {
            setMapEndpointAddress(address);
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
