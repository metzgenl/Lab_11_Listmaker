import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        //Declare Variables
        Scanner in = new Scanner(System.in);
        Boolean quit = false;
        ArrayList<String> myArrList = new ArrayList<>();
        String choice = "";
        String userInput = "";
        int location = 0;
        Boolean done = false;
        do {
            //Get the choice from the user
            choice = SafeInput.getRegExString(in, "Choose an option: Add (A), Delete (D), Insert (I), Print (P), or Quit (Q)", "[AaDdIiPpQq]");

            switch(choice) {
                //Add
                case "A":
                case "a":
                {
                    userInput = SafeInput.getNonZeroLenString(in, "Enter string to add to the end of the array");
                    myArrList.add(userInput);
                }
                break;

                //Delete
                case "D":
                case "d":
                {
                    if (myArrList.size() > 0) {
                        numberedVersion(myArrList);
                        location = SafeInput.getRangedInt(in, "Which item would you like to delete?", 0, myArrList.size() - 1);
                        myArrList.remove(location);
                        in.nextLine();
                    }
                    else{
                        System.out.println("No items in list to delete.");
                    }
                }
                break;

                //Insert
                case "I":
                case "i":
                {
                    if(myArrList.size() > 0) {
                        numberedVersion(myArrList);
                        location = SafeInput.getRangedInt(in, "Where would you like to insert the element?", 0, myArrList.size() - 1);
                        in.nextLine();
                        userInput = SafeInput.getNonZeroLenString(in, "Enter string that you would like to insert");
                        myArrList.add(location, userInput);
                    }
                    else{
                        System.out.println("No items in list to replace with Insert.");
                    }
                }
                break;

                //Print
                case "P":
                case "p":
                {
                    printList(myArrList);
                }
                break;

                //Quit
                case "Q":
                case "q":
                {
                    //Confirm Quit
                    done = SafeInput.getYNConfirm(in, "Are you sure you want to quit (Y or N)?");
                }
                break;
            }

        }while(!done);
    }
    private static void printList(ArrayList<String> myArrList){
        System.out.print(myArrList);
        System.out.println();
    }
    private static void numberedVersion(ArrayList<String> myArrList){
        System.out.print("[");
        for (int i = 0; i < myArrList.size(); i++) {
            System.out.print(i);
            if (i < myArrList.size() - 1) {  // Avoid extra comma at the end
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }
}