public class ColorPrint extends Printjob{
    
    
    public ColorPrint(String id, int pages){
        super(id, pages);
    }

    public String label(){
        String label = "Colour";
        return label;
    }


    public int calculateCharge(){
        int total;
        if(pages <= 10){
            total = (pages * 1500) + 2000;
            return total;
        }else{
            total  = (10*1500) + ((pages - 10)*1000) + 2000;
            return total;
        }
    }

    

    
}
