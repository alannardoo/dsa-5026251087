import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("parcels.txt"));

        int num = sc.nextInt();
        int[] parcels = new int[num];
        for(int i=0; i< num ; i++){
            parcels[i] = sc.nextInt();
        }

        int targets = sc.nextInt();
        int[] targetArr = new int[targets];
        for(int i=0; i<targets; i++){
            targetArr[i]= sc.nextInt();
        }
        int[] after2Pass= new int[num];
        for(int i=0; i < num;i++){
            after2Pass[i] =parcels[i];
        }
        bubbleSort(after2Pass, 2);

        bubbleSort(parcels, num - 1);
        System.out.println("==== After 2 Passes ====");
        for(int i=0; i <after2Pass.length; i++){
            System.out.print(after2Pass[i] + " ");
        }
        System.out.println();

        System.out.println("==== Fully Sorted ====");
        for(int i=0; i< parcels.length;i++){
            System.out.print(parcels[i] + " ");
        }
        System.out.println();

        System.out.println("==== Search Results ====");
        for(int i = 0; i<targetArr.length; i++){
            int steps =BinarySearchSteps(parcels, targetArr[i]);
            int result=BinarySearch(parcels, targetArr[i]);
            
            if(result == -1){
                System.out.println(targetArr[i] + ": NOT FOUND (steps: " + steps + ")");
            }else{
                System.out.println(targetArr[i] + ": FOUND at index " + result + " (steps: " + steps + ")");
            }
        }
    }

        //bubbelesort
        public static void bubbleSort(int[] parcels, int passes){
        int n = parcels.length;
        for(int i=0; i <passes; i++){
            for(int j =0; j< n - 1 - i; j++){
                if(parcels[j] < parcels[j + 1]){
                    int temp =parcels[j];
                    parcels[j] =parcels[j + 1];
                    parcels[j + 1] =temp;
                }
            }
        }
    }
    public static int BinarySearch(int[] parcels, int target){
        int low=0;
        int high =parcels.length - 1;
        while(low <=high){
            int mid = (low +high) / 2;
            if(parcels[mid] == target){
                return mid;
            }else if(parcels[mid] < target){
                high =mid - 1;
            }else{
                low=mid + 1;
            }
        }
        return -1;
    }
    public static int BinarySearchSteps(int[] parcels, int target){
        int low =0;
        int high=parcels.length - 1;
        int steps=0;
        while(low <= high){
            steps++;
            int mid= (low + high) / 2;
            if(parcels[mid] == target){
                return steps;
            }else if(parcels[mid] < target){
                high= mid - 1;
            }else{
                low =mid + 1;
            }
        }
        return steps;
    }
}

    
    


        
