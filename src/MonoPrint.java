public class MonoPrint extends Printjob{

    public MonoPrint(String id, int pages){
        super(id, pages);
    }
    
    public int calculateCharge(){
        int total;
        total = pages*500;
        return total;
    };
    public String label(){
        String label = "Mono";
        return label;
    };
    

    
}
