package client;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

public class Client {
    public static void main (String args[]) throws RemoteException {
        WeatherSoapBindingStub binding;
        try {
            binding = (WeatherSoapBindingStub)
                    new WeatherServiceLocator().getWeather();
        }
        catch (ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }

        binding.setTimeout(6000);

        String value = null;
        value = binding.getWeather("上海");
        System.out.println(value);
    }
}
