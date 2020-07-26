import java.util.ArrayList; 
import java.util.List; 


public interface Internet 
{ 
    public void connectTo(String serverhost) throws Exception; 
} 


public class RealInternet implements Internet 
{ 
    public void connectTo(String serverhost) 
    { 
        System.out.println("Connecting to "+ serverhost); 
    } 
}   
  
public class ProxyInternet implements Internet 
{ 
    private Internet internet = new RealInternet(); 
    private static List<String> bannedSites; 
      
    static
    { 
        bannedSites = new ArrayList<String>(); 
        bannedSites.add("abc.com"); 
        bannedSites.add("def.com"); 
        bannedSites.add("ijk.com"); 
        bannedSites.add("lnm.com"); 
    } 
      
    public void connectTo(String serverhost) throws Exception 
    { 
        if(bannedSites.contains(serverhost.toLowerCase())) 
        { 
            throw new Exception("Access Denied"); 
        } 
          
        internet.connectTo(serverhost); 
    } 
  
} 


public class ProxyPattern 
{ 
    public static void main (String[] args) 
    { 
        Internet internet = new ProxyInternet(); 
        try
        { 
            internet.connectTo("geeksforgeeks.org"); 
            internet.connectTo("abc.com"); 
        } 
        catch (Exception e) 
        { 
            System.out.println(e.getMessage()); 
        } 
    } 
} 