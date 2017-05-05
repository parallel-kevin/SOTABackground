/**
 * WeatherService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package client;

public interface WeatherService extends javax.xml.rpc.Service {
    public java.lang.String getWeatherAddress();

    public client.Weather_PortType getWeather() throws javax.xml.rpc.ServiceException;

    public client.Weather_PortType getWeather(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
