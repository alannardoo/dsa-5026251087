
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(Main.class.getResourceAsStream("/soal.txt"));
            ArrayList<Printjob> keranjang = new ArrayList<>();


            while (sc.hasNext()) { 
                String type = sc.next();
                String id = sc.next();
                int pages = sc.nextInt();

                if( type.equals("COLOUR")){
                    Printjob job = new ColorPrint(id, pages);
                    keranjang.add(job);
                }else if( type.equals( "MONO")){
                    Printjob job = new MonoPrint(id, pages);
                    keranjang.add(job);
                }

                
            }
            for(Printjob job : keranjang){
                    job.summary();
                }




    }
}
