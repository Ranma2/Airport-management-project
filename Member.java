/**
 * A class that manages the reward member program
 *
 * @author Ranaelle Modo Modo
 * @version 8.0
 */

import java.util.ArrayList;


/**
 * The type Member.
 */
public class Member {

    //fields of the member class
    private String memberID;
    private ArrayList<String> memberDate;
    private ArrayList<String> memberMiles;

    /**
     * Instantiates a new Member.
     *no arg-constructor
     * initialises the fields
     */

    public Member() {
        memberID = " ";
        memberDate = new ArrayList<>();
        memberMiles = new ArrayList<>();
    }

    /**
     * Instantiates a new Member.
     * parameterized constructor
     * @param memberID    the member id
     * @param memberDate  the member date
     * @param memberMiles the member miles
     */
    public Member(String memberID, ArrayList<String> memberDate, ArrayList<String> memberMiles) {
        this.memberID = memberID;
        this.memberDate = memberDate;
        this.memberMiles = memberMiles;
    }

    /**
     * All dates.
     *this method takes all the dates linked to a member ID
     * @param memberID  the member id
     * @param dates     the dates
     * @param memberIDs the member i ds
     */
    public void allDates(String memberID, ArrayList<String> dates, ArrayList<String> memberIDs) {
        for (int i = 0; i < memberIDs.size(); i++) {
            if (memberID.equals(memberIDs.get(i))) {
                this.memberDate.add(dates.get(i));

            }
        }
    }

    /**
     * All miles.
     *this method gets all the miles linked to a member ID
     * @param memberID  the member id
     * @param miles     the miles
     * @param memberIDs the member i ds
     */
    public void allMiles(String memberID, ArrayList<String> miles, ArrayList<String> memberIDs) {
        for (int i = 0; i < memberIDs.size(); i++) {
            if (memberID.equals(memberIDs.get(i))) {
                this.memberMiles.add(miles.get(i));

            }
        }
    }

    /**
     * This year
     * @param currentYear
     * this method gets the current year of the file
     * @return last which a variable that is assigned the current year of the file
     */
    public String thisYear(ArrayList<String> currentYear){
        String last = currentYear.get(currentYear.size() - 1);
        return last;
    }

    /**
     * Miles of current year.
     * this method sums up the miles of the current year
     * linked to a specific member ID
     */
    public void milesOfCurrentYear(ArrayList<String> currentYear) {
        thisYear(currentYear);
        int sum = 0;
        int index = 0;

        //this for loop goes through the ArrayList memberDate and sum up the miles
        // of the currentYear according to the file
        for (String year : memberDate) {
            if (year.contains(thisYear(currentYear))) {
                index = memberDate.indexOf(year);
                sum += Integer.parseInt(memberMiles.get(index));
            }
        }
        System.out.println("You accumulated this year: " + sum + " miles");
    }


    /**
     * Miles since joining.
     * this method sums up all the miles linked
     * to a member ID
     */
    public void milesSinceJoining() {
        int sum = 0;
        for (int i = 0; i < this.memberMiles.size(); i++) {
            sum += Integer.parseInt(this.memberMiles.get(i));
        }
        System.out.println("The miles you accumulated since joining is: " + sum + " miles");
    }

    /**
     * Gets first date.
     * this method gets the first date that the member flew
     * with the airline
     */
    public void getFirstDate() {
        System.out.println("You joined " + this.memberDate.get(0));
    }

    /**
     * Check tiers method
     *this method used the sum of miles to check if the member belongs to any reward tier
     * @param sum the sum
     */
    public void checkTiers(int sum) {
        if (sum < 25000) {
            System.out.println("Your miles are: " + sum + " miles." + "\n You do not belong to any tiers");
        } else if (sum >= 25000 && sum < 50000) {
            System.out.println("Your miles are: " + sum + " miles." + "\n You are a Gold Tier member");
        } else if (sum >= 50000 && sum < 75000) {
            System.out.println("Your miles are: " + sum + " miles." + "\n You are a Platinum Tier member");
        } else if (sum >= 75000 && sum < 100000) {
            System.out.println("Your miles are: " + sum + " miles." + "\n You are a Platinum pro Tier member");
        } else if (sum >= 100000 && sum < 150000) {
            System.out.println("Your miles are: " + sum + " miles." + "\n You are a Executive Platinum Tier member");
        } else if (sum >= 150000) {
            System.out.println("Your miles are: " + sum + " miles." + "\n You are a Super Executive Platinum Tier member");
        }
    }

    /**
     * Current Year Tier
     * this method sums up the miles of the current year according to the file
     * then uses the method checkTiers to display number of miles
     * and the tiers that the user belongs to
     * @param currentYear
     */
   public void currentYearTier(ArrayList<String> currentYear) {
        int previousYear = Integer.parseInt(thisYear(currentYear)) - 1;
        String convertPreviousYear = String.valueOf(previousYear);
        int sum = 0;
        int index = 0;

        for (String year : memberDate) {
            if (year.contains(convertPreviousYear)) {
                index = memberDate.indexOf(year);
                sum += Integer.parseInt(memberMiles.get(index));
            }
        }
        checkTiers(sum);
    }

    /**
     * Reward of prior year.
     * this method sums up the miles of a year given by the user
     * then uses the method checkTiers to display number of miles
     *and the tiers that the user belongs to that year
     * @param year the num of years
     */
    public void rewardOfPriorYear(String year) {
        int lastYear = (Integer.parseInt(year)) - 1;
        String convertYear = String.valueOf(lastYear);

        int sum = 0;
        int index = 0;

        for (String years : memberDate) {
            if (years.contains(convertYear)) {
                index = memberDate.indexOf(years);
                sum += Integer.parseInt(memberMiles.get(index));
            }
        }
        checkTiers(sum);
    }


}
