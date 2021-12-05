import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements MyInterface {

    public Server() throws RemoteException {
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Server server = new Server();

        java.rmi.registry.LocateRegistry.createRegistry(1250);

        Naming.rebind("rmi://127.0.0.1:1250/server", server);

    }

    @Override
    public String Reverse(String s) throws RemoteException {
        StringBuffer sbf = new StringBuffer(s);
        sbf.reverse();
        String resultat = sbf.toString();
        return resultat;
    }

    @Override
    public char MinChar(String s) throws RemoteException {

        int min = (int)s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
           if ((int)s.charAt(i)<min){
               min=(int)s.charAt(i);
           }
        }
        return (char)min ;
    }
    @Override
    public String CaseChanger(String s) throws RemoteException{

         String newS="";
        // Conversion according to ASCII values
        for (int i = 0; i <s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                // Convert lowercase to uppercase
                newS = newS + (char)(s.charAt(i) - 32);
            else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                // Convert uppercase to lowercase
                newS = newS + (char) (s.charAt(i) + 32);
            else newS = newS + (char) (s.charAt(i));
        }
        return newS ;
    }

}



