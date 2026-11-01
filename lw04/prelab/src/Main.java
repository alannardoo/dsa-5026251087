import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        int num = sc.nextInt();
        int[] branches = new int[num];
        for(int i=0; i < num; i++){
            branches[i] = sc.nextInt();
        }
        
        int stabilize = sc.nextInt();
        int[] targets = new int[stabilize];
        for(int i=0; i < stabilize; i++){
            targets[i] = sc.nextInt();
        }
        insertionSort(branches);

        //pemanggilan sorting dadn searching
        for(int i=0; i< branches.length; i++){
            System.out.print(branches[i] + " ");
        }
        System.out.println();

        for(int i = 0; i < targets.length; i++){
            int result = LinearSearch(branches, targets[i]);
            if(result == -1){
                System.out.println(targets[i] + ": NOT FOUND");
            }else{
                System.out.println(targets[i] + ": FOUND at index " + result);
            }
        }
    }

        //insertion
        public static void insertionSort(int[] branches){
            
            for(int i=1; i <= 3; i++){
                int key = branches[i];
                int j = i - 1;

                while(j >= 0 && branches[j] < key){
                    branches[j + 1] = branches[j];
                    j--; 
                }
                branches[j + 1] = key;
            }
        }

        //searching
        public static int LinearSearch(int[] branches, int target){
            int i= 0;
            while(i < branches.length){
                if(branches[i] == target){
                    return i;
                }
                i++;
            }
            return -1;
        }
    }


