/**
 * WeatherServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package client;

public class WeatherServiceLocator extends org.apache.axis.client.Service implements client.WeatherService {

    public WeatherServiceLocator() {
    }


    public WeatherServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WeatherServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Weather
    private java.lang.String Weather_address = "http://localhost:8080//services/Weather";

    public java.lang.String getWeatherAddress() {
        return Weather_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WeatherWSDDServiceName = "Weather";

    public java.lang.String getWeatherWSDDServiceName() {
        return WeatherWSDDServiceName;
    }

    public void setWeatherWSDDServiceName(java.lang.String name) {
        WeatherWSDDServiceName = name;
    }

    public client.Weather_PortType getWeather() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Weather_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWeather(endpoint);
    }

    public client.Weather_PortType getWeather(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            client.WeatherSoapBindingStub _stub = new client.WeatherSoapBindingStub(portAddress, this);
            _stub.setPortName(getWeatherWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWeatherEndpointAddress(java.lang.String address) {
        Weather_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (client.Weather_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                client.WeatherSoapBindingStub _stub = new client.WeatherSoapBindingStub(new java.net.URL(Weather_address), this);
                _stub.setPortName(getWeatherWSDDServiceName());
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
        if ("Weather".equals(inputPortName)) {
            return getWeather();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://server", "WeatherService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://server", "Weather"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Weather".equals(portName)) {
            setWeatherEndpointAddress(address);
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
