import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("===== Event Check-In Results =====");
        
        Scanner sc = new Scanner(Main.class.getResourceAsStream("registrations.txt"));
        Set<String> registStud = new LinkedHashSet<>();

        while(sc.hasNextLine()){
            String id = sc.nextLine();
            registStud.add(id);
        }
        sc.close();

        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("checkins.txt"));
        Set<String> absentList = new LinkedHashSet<>();
        int sucess = 0;
        int reject= 0;

        while(sc2.hasNextLine()){
            String id = sc2.nextLine();

            if(!registStud.contains(id)){
                System.out.println(id + ": Rejected(not registered)");
                reject++;
            }else if(absentList.contains(id)){
                System.out.println(id + ": Rejected(already checked in)");
                reject++;
            }else{
                absentList.add(id);
                System.out.println(id + ": Checked in");
                sucess++;
            }
        
        }
            sc2.close();
            System.out.println();
            System.out.println("===== Final Event Summary =====");
            System.out.println("Registered students: " + registStud.size() );
            System.out.println("Successful check-ins: " + sucess);
            System.out.println("Absent students: " + (registStud.size() - absentList.size()));
            System.out.println("Rejected attempts: " + reject);

    }
}
