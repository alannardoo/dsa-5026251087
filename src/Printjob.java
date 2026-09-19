public abstract class Printjob implements Chargeable {
    String id;
    int pages;

    public Printjob( String id, int pages){
        if(pages <= 0){
            throw new IllegalArgumentException("Copies or Pages must at least 1 !");
    }
        
        this.id = id;
        this.pages = pages;
    }
    
    String getId(){
        return id;
    }

    int getPages(){
        return pages;
    }
    int calculateCharge(int copies){
        int total;
        total = copies*calculateCharge();
        return total;
    }

    void summary(){
        System.out.println(getId() + " | " + label() + " | " + calculateCharge());
    }

    public abstract int calculateCharge();
    public abstract String label();

}
