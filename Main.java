import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws IOException {
        Scanner input = null;
        try {
            input = new Scanner(new BufferedReader(new FileReader("data.txt")));
            input.useLocale(Locale.US);
            int number_of_cases = Integer.valueOf(input.nextLine());
            for (int i = 0; i < number_of_cases; i++) {//CASES
                System.out.println("-----------------------------Case-"+(i+1)+"--------------------------");
                TestCase case1 = null;
                int number_of_stores = Integer.valueOf(input.nextLine());
                case1 = new TestCase();
                for (int j = 0; j < number_of_stores; j++) {

                    int number_of_items_sold_at_store = Integer.valueOf(input.nextLine());
                    case1.AddHead(number_of_items_sold_at_store);

                    for (int k = 0; k < number_of_items_sold_at_store; k++) {
                        String line = input.nextLine();
                        String[] s = line.split(" ");
                        String itemsName = s[0];
                        double price = Double.valueOf(s[1]);
                        int itemsQuantities = Integer.valueOf(s[2]);
                        case1.head.first.AddItem(itemsName, price, itemsQuantities);
                    }

                }

                int itemsNeeded = Integer.valueOf(input.nextLine());
                GroceryList myGrList = new GroceryList(itemsNeeded);
                for (int index = 0; index < itemsNeeded; index++) {
                    String grocerLine = input.nextLine();
                    if (grocerLine.equals(null)) break;
                    String[] s = grocerLine.split(" ");
                    String itemName = s[0];
                    int itemQuantity = Integer.valueOf(s[1]);
                    myGrList.AddHead(itemName, itemQuantity);

                }

                double myTotal = case1.GetMyGroceryReceipt(myGrList);
                PrintWriter out=null;
                String inputfile = "My_output.txt";
                try {
                    out = new PrintWriter(new FileWriter(inputfile, true));//true for append
                    out.println("\nThe total of case "+ (i+1) +" is: "+myTotal);
                } finally {
                    if (out != null)
                        out.close();
                }


                System.out.println(myTotal);



            }

        } finally {
            if (input != null) {
                input.close();
            }

        }

    }


}