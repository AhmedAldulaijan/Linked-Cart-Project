import java.util.Scanner;

class GroceryItem{
    double cheapestTotalForQuantity;

    int recievedQuantity;
    String name;
    int quantity;
    GroceryItem next;
    //Two VALUES REQUIRED for creating an item type & next will always be set to "null"
    public GroceryItem(String name, int quantity){
        this.name=name;
        this.quantity=quantity;
        next=null;
    }
}

public class GroceryList {
    int itemsNeeded;
    GroceryItem head;
    //Should get an idea of the amount of items we actually need but the head may be set to null for now
    //This will be need for iterating and filling loop in main
    public GroceryList(int itemsNeeded){
        this.itemsNeeded=itemsNeeded;
        head=null;
    }

    public void AddHead(String itemName, int itemAmount){
        GroceryItem tmp = new GroceryItem(itemName,itemAmount);
        if (head!=null) tmp.next=head;
        head = tmp;
    }

//    public void FillGroceryList(){
//        Scanner keyboard = new Scanner(System.in);
//        String myItemsName;
//        int myItemAmount;
//        for (int i = 0; i < itemsNeeded ; i++) {
//            System.out.println("Enter Item Name");
//            myItemsName=keyboard.next();
//            System.out.println("Enter Item Amount");
//            myItemAmount= keyboard.nextInt();
//            AddHead(myItemsName,myItemAmount);
//        }
//        PrintList();
//    }
//    //To be looped Through Based on items Needed

//    public void FillGroceryListInput(){
//        Scanner keyboard = new Scanner(System.in);
//        String holdLine;
//        String myItemsName;
//        int myItemAmount;
//        for (int i = 0; i < itemsNeeded ; i++) {
//            System.out.println("Enter Item Name");
//            myItemsName=keyboard.next();
//            System.out.println("Enter Item Amount");
//            myItemAmount= keyboard.nextInt();
//            AddHead(myItemsName,myItemAmount);
//        }
//    }


    public void PrintList(){
        if (head==null)return;
        GroceryItem tmp = head;
        int count = 0;
        while (tmp!=null){
            count++;
            System.out.println("item " + count +" is: " + tmp.name + " & The Quantity is: " + tmp.quantity);
            tmp=tmp.next;
        }
    }







}












