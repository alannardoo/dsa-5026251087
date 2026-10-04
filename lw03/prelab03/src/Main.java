import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //problem 1
        Scanner sc = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        List<String> musicList = new ArrayList<>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] part = line.split(" ");
            String music = "";
            int i;

            if(part[0].equalsIgnoreCase("INSERT")){
                i = 2;
            }else{
                i = 1;
            }
            for(; i<part.length; i++){
                music = music + " " +  part[i];
            }

            if(part[0].equalsIgnoreCase("ADD")){
                musicList.add(music);
            }else if(part[0].equalsIgnoreCase("REMOVE")){
                musicList.remove(music);
            }else if(part[0].equalsIgnoreCase("INSERT")){
                musicList.add(Integer.parseInt(part[1]), music);
            }
        }
        int nomor=0;
        System.out.println("===== Problem 1 =====");
        System.out.println(" Total Songs : " + musicList.size());
        for(String music : musicList){
            nomor++;
            System.out.println(nomor + ": " + music);
            sc.close();
        }
        System.out.println();

        //problem 2
        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Set<String> participantList = new LinkedHashSet<>();
        int uniqueParticipant = 0;
        int duplicate = 0;
        while(sc2.hasNextLine()){
            String name = sc2.nextLine();
            if(participantList.add(name)){
                uniqueParticipant++;
            }else{
                duplicate++;
            }

        }
        int nums=1;
        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + uniqueParticipant);
        for(String participant : participantList){
            System.out.println( nums++ + ". " + participant);
        }
        System.out.println("Duplicate registrations: " + duplicate);
        sc2.close();
        System.out.println();

        //problem 3
        Scanner sc3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        Map<String, Integer> itemList = new LinkedHashMap<String, Integer>();
        int failedSales=0;
        
        while(sc3.hasNextLine()){
            String lines = sc3.nextLine();
            String[] parts = lines.split(" ");

            if(parts[0].equalsIgnoreCase("ADD")){
                if(itemList.containsKey(parts[1])) {
                    itemList.put(parts[1], itemList.get(parts[1]) + Integer.parseInt(parts[2]));
                }else{
                    itemList.put(parts[1], Integer.parseInt(parts[2]));
                }
            }else if(parts[0].equalsIgnoreCase("SELL")){
                if(itemList.containsKey(parts[1])){
                     if(itemList.get(parts[1]) >= Integer.parseInt(parts[2])) {
                    itemList.put(parts[1], itemList.get(parts[1]) - Integer.parseInt(parts[2]));
                }else{
                    failedSales++;
                }
            }else{
                failedSales++;

            }
        }
    }
    int number=1;
        System.out.println("===== Problem 3 =====");
        for (Map.Entry<String, Integer> item : itemList.entrySet()){
            System.out.println(item.getKey() +  " : " + item.getValue());
        }
        System.out.println("Failed sales: " + failedSales);

        sc3.close();
    }
}
    


                   
                
                     
            
        
        
    
        


        


        
