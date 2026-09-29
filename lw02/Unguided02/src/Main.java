import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> orders = new LinkedList<>();
        LinkedList<String[]> foodStock = new LinkedList<>();
        LinkedList<String[]> drinkStock = new LinkedList<>();
        LinkedList<String[]> successOrders = new LinkedList<>();
        
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();
        
        //food
        foodStock.add(new String[]{"Bakso", "2"});
        foodStock.add(new String[]{"Sate","1"});
        foodStock.add(new String[]{"Soto","2"});
        
        //drink
        drinkStock.add(new String[]{"EsTeh","4"});
        drinkStock.add(new String[]{"EsJeruk","2"});
        Scanner sc = new Scanner(Main.class.getResourceAsStream("orders.txt"));
        while (sc.hasNext()) {
            String[] order = new String[4];
            order[0] = sc.next(); 
            order[1] = sc.next(); 
            order[2] = sc.next(); 
            order[3] = sc.next(); 
            orders.add(order);
        }
        queue.addAll(orders);
        while (!queue.isEmpty()) {
            String[] order = queue.poll();
            
            String name = order[0];
            String foodName = order[1];
            String drinkName = order[2];
            String table = order[3];
            
            String[] foodItem = null;
            if (!foodName.equals("-")) {
                for (String[] f : foodStock) {
                    if (f[0].equals(foodName)) {
                        foodItem = f;
                        break;
                    }
                }
            }
            String[] drinkItem = null;
            if (!drinkName.equals("-")) {
                for (String[] d : drinkStock) {
                    if (d[0].equals(drinkName)) {
                        drinkItem = d;
                        break;
                    }
                }
            }
            
            boolean foodAvailable = foodName.equals("-") || (foodItem != null && Integer.parseInt(foodItem[1]) > 0);
            boolean drinkAvailable = drinkName.equals("-") || (drinkItem != null && Integer.parseInt(drinkItem[1]) > 0);
            
            
            if (foodAvailable && drinkAvailable) {
                if (!foodName.equals("-") && foodItem != null) {
                    int stock = Integer.parseInt(foodItem[1]);
                    foodItem[1] = String.valueOf(stock - 1);
                }

                if (!drinkName.equals("-") && drinkItem != null) {
                    int stock = Integer.parseInt(drinkItem[1]);
                    drinkItem[1] = String.valueOf(stock - 1);
                }
                
                successOrders.add(order);
            } else {
                failed.push(order);
            }
        }
    
        System.out.println("=== Successfully Processed Orders ===");
        for (String[] order : successOrders) {
            System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
        }
        System.out.println("=== Remaining Food Stock ===");
        for (String[] f : foodStock) {
            System.out.println(f[0] + ": " + f[1]);
        }
        
        System.out.println("=== Remaining Drink Stock ===");
        for (String[] d : drinkStock) {
            System.out.println(d[0] + ": " + d[1]);
        }
        System.out.println("=== Failed Orders ===");
        while (!failed.isEmpty()) {
            String[] order = failed.pop();
            System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
        }
    }
    
}