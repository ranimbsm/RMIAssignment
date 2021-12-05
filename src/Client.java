import java.rmi.Naming;

public class Client {

    public static void main(String[] args) {
        try {
           MyInterface service = (MyInterface) Naming.lookup("rmi://127.0.0.1:1250/server");
            System.out.println(service.Reverse("RAGNAR"));
            System.out.println(service.MinChar("heisenberg"));
            System.out.println(service.CaseChanger("Jon Snow"));
        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e);
        }
    }
}
