public abstract class Printjob implements Chargeable {
    String id;
    int pages;

    public Printjob( String id, int pages){
        if(pages <= 0){
            throw new IllegalArgumentException("Copies or Pages can't be negative!");
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
        if(copies <= 0){
            throw new IllegalArgumentException("copies or pages can't be negative!");
        }
        int total;
        total = copies*calculateCharge();
        return total;
    }

    void summary(){
        System.out.println(getId() + " | " + label() + " | " + calculateCharge());
    }

    @Override 
    public abstract int calculateCharge();

    public abstract String label();

}
