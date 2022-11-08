/**
 * This main class displays menu for the user to
 * check the reward program and the member reward program
 *
 * @author Ranaelle  Modo Modo
 * @version 8.0
 */

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The type Main.
 */
public class Main {

    /**
     * Main menu.
     * This method display the first menu
     * where the user can either choose the general information of reward program
     * or the reward member.
     */
    public static void mainMenu() {
        System.out.println("\n                 -MAIN MENU-");
        System.out.println("Choose an option or type exit to leave the program.");
        System.out.println("1. General information for the reward program");
        System.out.println("2. Reward member program\n");
    }

    /**
     * reward program
     * This method displays the reward program menu
     * and allows the user to see each reward tier and its perks
     */
    public static void rewardProgram() {
        Scanner scnr = new Scanner(System.in);

        int rewardPro;

        while (true) {
            System.out.println("               -REWARD PROGRAM MENU-");
            System.out.println("Select a tier to explore its perks");

            System.out.println("1. Gold" +
                    "\n2. Platinum" +
                    "\n3. Platinum Pro" +
                    "\n4. Executive Platinum" +
                    "\n5. Super Executive" +
                    "\n6. Back to main menu\n");
            rewardPro = scnr.nextInt();

            if (rewardPro == 6) {
                break;
            }

            switch (rewardPro) {
                case 1:
                    System.out.println("\nWelcome to Gold!");
                    System.out.println("This tier includes a seat in during the flight.\n\n");
                    break;

                case 2:
                    System.out.println("\nWelcome to Platinum!");
                    System.out.println("This tier offers complementary upgrades to padded seats.\n\n");
                    break;


                case 3:
                    System.out.println("\nWelcome to Platinum Pro!");
                    System.out.println("This tier offers padded seats with arm rests.\n\n");
                    break;

                case 4:
                    System.out.println("\nWelcome to Executive Platinum!");
                    System.out.println("This tier offers complementary upgrades from cargo hold to main cabin.\n\n");
                    break;

                case 5:
                    System.out.println("\nWelcome to Super Executive Platinum!");
                    System.out.println("This tier upgrades your regular seat to the co-pilot's seat.\n\n");
                    break;

                default:
                    System.out.println("This is not a valid entry! Please re-enter another. \n");
                    break;

            }

        }


    }


    /**
     * Menu option 2.
     *
     * @throws IOException the io exception
     * this method reads the file that contains dates, members IDs and number of miles
     *divides the file into an array of three elements
     *then add each element in different ArrayLists
     *creates the object member of the class Member to access the methods of Member class
     *displays the reward member program menu
     */
// method that manages the member reward. It displays
    public static void menuOption2() throws IOException {
        FileInputStream openFile = new FileInputStream("input.txt"); // open the file "input.txt" .
        Scanner file = new Scanner(openFile);
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter member ID: ");
        String memberID = scnr.nextLine();
        //creates different ArrayLists that will contain the information of the file
        ArrayList<String> dates = new ArrayList<>();
        ArrayList<String> memberIds = new ArrayList<>();
        ArrayList<String> miles = new ArrayList<>();
        ArrayList<String> currentYear = new ArrayList<>();

        while (file.hasNextLine()) { //this loop reads the file line by line
            String verify = file.nextLine();

            String[] pieces = verify.split(" ");// splits each line of file in 3 elements of an array called pieces

            //each element of the array is added to an ArrayListS
            dates.add(pieces[0]);
            memberIds.add(pieces[1]);
            miles.add(pieces[2]);


            String[] onlyDates = pieces[0].split("-");// this line splits the array pieces[0] into three elements, years
            //months and dates
            currentYear.add(onlyDates[0]);// add the year element in the array list called currentYear
        }


        Member member = new Member();//creates the object member of the class Member
        member.allDates(memberID, dates, memberIds);//calls the method allDates from the Member class
        member.allMiles(memberID, miles, memberIds);//calls the method allMiles from the Member class

        // checks if the user is a member and display a welcome message
        if (memberIds.contains(memberID)) {
            System.out.println("\nHello member " + memberID + "!");
        }


        while (true) // this while loop is used to display the reward member program
            if (memberIds.contains(memberID)) {
                System.out.println("\nchoose an option: ");
                System.out.println("a. Miles accumulated in the current year.");
                System.out.println("b. Total miles accumulated since joining the rewards program.");
                System.out.println("c. Join date of the rewards Program.");
                System.out.println("d. Current reward tier.");
                System.out.println("e. Reward tier of a given year.");
                System.out.println("f. Go to main menu.");

                char memberinput = scnr.next().charAt(0);

                if (memberinput == 'f') {
                    break;
                }

                switch (memberinput) {

                    case 'a':
                    case 'A':
                        member.milesOfCurrentYear(currentYear);
                        break;

                    case 'b':
                    case 'B':
                        member.milesSinceJoining();
                        break;

                    case 'c':
                    case 'C':
                        member.getFirstDate();
                        break;

                    case 'd':
                    case 'D':
                        member.currentYearTier(currentYear);
                        break;

                    case 'e':
                    case 'E':
                        System.out.println("What year do you want to check?");
                        scnr.nextLine();
                        String givenYear = scnr.nextLine();
                        member.rewardOfPriorYear(givenYear);
                        break;

                    default:
                        System.out.println("This is not a valid entry! Please re-enter another.");
                }
            } else {
                System.out.println("Your are not a member, you cannot access the reward member program!");
                break;
            }

    }

    /**
     * The entry point of application.
     * this method uses a while loop to call
     * methods that displays menus
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    /*Main method that display te*/
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("****************WELCOME!!!*******************");
        System.out.println("*************** ALABASTA AIRLINE *****************");

        while (true) { // this while loop is used to call methods that display menus
            mainMenu();
            String inputmenu1 = keyboard.nextLine();
            if (inputmenu1.equals("exit")) {
                break;
            }
            if (inputmenu1.equals("1")) {
                rewardProgram();

            } else {
                menuOption2();

            }
        }


    }
}