package server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Map {
  @WebMethod
  public String map(String from) {
    String result = "Hello world from " + from;
    System.out.println(result);
    return result;
  }
}
