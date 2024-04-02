//This functions as our first step in which we
//create a Node for the rightWard items portion of the list
//This will be our most primitive Node type which will only hold 1 address
//each node of this type will hold an itemName, an itemPrice, and an itemQuantity

class Item{
    String name;
    double price;
    int quantity;
    Item next;
    public Item(String name, double price, int quantity){
        this.name =name;
        this.price =price;
        this.quantity =quantity;
        next=null;
    }
}
//List For ItemNodes
class ItemList{
    Item head;
    public ItemList(){
        head=null;
    }

    public void AddItem(String name, double price, int quantity){
        Item tmp = new Item(name,price,quantity);
        if (head!=null) tmp.next = head;
        head = tmp;
    }
    //--------------
    public void AddItem(Item toBeAdded){
        Item tmp = new Item(toBeAdded.name,toBeAdded.price,toBeAdded.quantity);
        if (head!=null) tmp.next = head;
        head = tmp;
    }
    //--------------

    //
    public void CopyingListItems(String name, ItemList made){
        Item tmp = this.head;
        while (tmp!=null){
            if (tmp.name.equals(name)){
                made.AddItem(tmp);
            }
            tmp=tmp.next;
        }
    }
    //-----


    //Should serve to add all matching nodes to the given list
    //--------------

    public void PrintItemList(){
        Item tmp = head;
        while (tmp!=null){
            System.out.println("My Item is: "+ tmp.name+ " and The Price is: "+ tmp.price + " and its available quantity is: "+ tmp.quantity);
            tmp=tmp.next;
        }
    }




    //Can Add items only through access of Item List head, which will be called through itemList.AddItem(); from TestCase

    void deleteItem(double key)
    {
        // Store head node
        Item temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.price == key) {
            head = temp.next; // Changed head
            return;
        }

        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.price != key) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null)
            return;

        // Unlink the node from linked list
        prev.next = temp.next;
    }






}