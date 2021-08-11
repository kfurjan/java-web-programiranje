package hr.algebra.util;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author Kevin
 */
public class NetworkUtils {
    
    private final static int PORT = 9999;
    private final static String URL = "8.8.8.8";

    /**
     * Get preferred outbound IP address of machine.
     * 
     * @return IP address or "Unknown"
     */
    public static String getIpAddress() {
        
        try (final DatagramSocket socket = new DatagramSocket()){
            socket.connect(InetAddress.getByName(URL), PORT);
            return socket.getLocalAddress().getHostAddress();
        } catch (SocketException | UnknownHostException ex) {
            return "Unknown";
        }
    }
}
