import java.util.HashMap;
import java.util.Scanner;
public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student ID and name (type -1 to stop):");
        while (true) {
            System.out.print("ID: ");
            int id = sc.nextInt();
            if (id == -1){
                break;
            }
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            studentMap.put(id, name);
        }
        System.out.print("Enter ID to search: ");
        int searchId = sc.nextInt();
        if (studentMap.containsKey(searchId)) {
            System.out.println("Name: " + studentMap.get(searchId));
        } 
        else {
            System.out.println("ID not found.");
        }
        sc.close();
    }
}
