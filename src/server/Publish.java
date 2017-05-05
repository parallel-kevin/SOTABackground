package server;

import javax.xml.ws.Endpoint;

public class Publish {
    public static void main(String args[]) throws Exception {
        Object implementor = new Map();
        String address = "http://localhost:8080//services/Map";     //发布到的地址
        Endpoint.publish(address, implementor);
        implementor = new Weather();
        address = "http://localhost:8080//services/Weather";     //发布到的地址
        Endpoint.publish(address, implementor);
        System.out.println("发布成功");
    }
}
