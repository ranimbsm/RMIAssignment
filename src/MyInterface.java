import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyInterface extends Remote {
    public String Reverse (String s) throws RemoteException ;
    public char MinChar (String s) throws RemoteException ;
    public String CaseChanger(String s) throws RemoteException ;

}
