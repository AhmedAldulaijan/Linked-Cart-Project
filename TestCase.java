import java.util.GregorianCalendar;

class StoreNode{
    int itemCount;
    StoreNode next;
    ItemList first;
    public StoreNode(int itemCount){
        this.itemCount = itemCount;
        first = new ItemList();
        next = null;
    }
}

public class TestCase {
    StoreNode head;

    public TestCase(){
        head=null;
    }
    public void AddHead(int count){
        StoreNode tmp = new StoreNode(count);
        if (head!=null) tmp.next=head;
        head=tmp;
    }
    public void AddItems(String name, double price, int quantity){

    }

    public void print(){
        StoreNode tmp = head;
        while (tmp!=null){
        //    System.out.println("The number of Items in this Store is: "+tmp.itemCount);
            tmp.first.PrintItemList();
            tmp=tmp.next;
        }
    }

    public ItemList MakeListForSpecifics(String itemName){
        ItemList uniformItemList = new ItemList();
        StoreNode tmp = head;
        while (tmp!=null){
            tmp.first.CopyingListItems(itemName,uniformItemList);
            tmp=tmp.next;
        }
        return uniformItemList;
    }

    public Item CheapestValue(ItemList myList){
        Item cheapestItem = null;
        Item iterator = myList.head;
        cheapestItem = myList.head;

        while (iterator!=null){
      //      System.out.println("price for "+ iterator.name +" is: "+ iterator.price);

            if (iterator.price< cheapestItem.price){



                cheapestItem = iterator;
            }
            iterator=iterator.next;
        }

        return cheapestItem;
    }

    public void AllInOne(ItemList myList, GroceryItem myItem){
        Item cheap = CheapestValue(myList);
        int amountAvailible = cheap.quantity;
        int amountRequired  = myItem.quantity - myItem.recievedQuantity;
        if (amountAvailible > amountRequired){
            myItem.cheapestTotalForQuantity += (amountRequired * cheap.price);
            myItem.recievedQuantity += amountRequired;
            myList.deleteItem(cheap.price);
        } else if (amountAvailible == amountRequired) {
            myItem.cheapestTotalForQuantity += (amountRequired * cheap.price);
            myItem.recievedQuantity += amountRequired;
            myList.deleteItem(cheap.price);
        } else if (amountAvailible<amountRequired) {
            myItem.cheapestTotalForQuantity += (amountAvailible * cheap.price);
            myItem.recievedQuantity += amountAvailible;
            myList.deleteItem(cheap.price);

        }
    }
    public void myTotal(GroceryItem myItem){
        ItemList specificList = MakeListForSpecifics(myItem.name);
        while (myItem.recievedQuantity < myItem.quantity) {
            AllInOne(specificList, myItem);
        }
 //       System.out.println("Shopping completed");
    }

    public double GetMyGroceryReceipt(GroceryList myList){
        double totalAmount=0;
        GroceryItem myIndex = myList.head;
        while (myIndex!=null){
            myTotal(myIndex);
            totalAmount+=myIndex.cheapestTotalForQuantity;
            myIndex=myIndex.next;

        }
        return totalAmount;
    }








}




































//This will be the glue that holds everything together,
//This list will use both types of nodes
//One myList to iterate through both dimensions
//it will have a next for the next store "myList.next" and will have a next that links us to our store node "myList.first"
//but to iterate through our "first", we cannot just use a "myList.first.first" as the "myList.first" merely connects us to
//a node of different type. we probably need to do the following "myList.first.next" in which the "first" functions as our "myList"
//So myList.next is for downward iteration
//and h.first is for rightward iteration
//after that point iterating through both will be done using .next