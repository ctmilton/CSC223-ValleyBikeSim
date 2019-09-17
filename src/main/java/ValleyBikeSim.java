import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.TreeMap;
public class ValleyBikeSim {
    /**
     * We use exit to quit the program
     */
    public static void quit() {
           System.out.print("You have exited.");
           System.exit(0);
       } 
    /**
     * We use this to make a menu where the choices are visible. In our main class we take the choices.
     */
   public static void intro() {
       System.out.println("Please choose from one of the following menu options:");
       System.out.println("0. Quit Program.\n" +
               "1. View station list.\n" +
               "2. Add station.\n" +
               "3. Save station list.\n" +
               "4. Record ride.\n" +
               "5. Resolve ride data.\n" +
               "6. Equalize stations.\n"
               +"Please enter your selection (0-6): ");
   }
       /**
        * Assumption: We assume that the data file is from the data-file folder.
        * We read the file and organize the ID's by putting them into a Hashmap and then Treemap in order to sort out the table.
        * @param csvName
        * @throws IOException
        */
   
       private String currentrow;
       BufferedReader br;
      
       public void readcsv(String csvName) throws IOException {
           int iteration = 0;
           br = new BufferedReader(new FileReader(csvName));
           try { 
             
               Map<Integer, Station> hm = new HashMap<Integer,Station>();  
           while ((currentrow = br.readLine()) != null) { 
               
               if (iteration == 0) {
                   iteration ++;
                   continue;
               }
               
            String [] rowAfterSplit = currentrow.split(","); 
            Integer id = Integer.valueOf(rowAfterSplit[0]);
            Integer bike = Integer.valueOf(rowAfterSplit[2]);
            Integer pedelecs = Integer.valueOf(rowAfterSplit[3]);
            Integer availableDocks = Integer.valueOf(rowAfterSplit[4]);
            Integer maintainenceReq = Integer.valueOf(rowAfterSplit[5]);
            Integer capacity = Integer.valueOf(rowAfterSplit[6]);
            Integer kioskInt = Integer.valueOf(rowAfterSplit[7]);
            Boolean kiosk = (kioskInt==1) ? true : false;
            Station myStation = new Station(id,rowAfterSplit[1],bike,pedelecs,availableDocks,maintainenceReq,capacity,kiosk,rowAfterSplit[8]);
            hm.put(id, myStation);
            
           }
         
            Map<Integer, Station> sorted = new TreeMap<Integer,Station>(hm); 
            sorted.keySet();  
            
            System.out.println("ID | Name                              |Bike| Pedelecs | Available Docks | Maintaince Req | Capacity | Kiosk | Address");
            for (Integer sortedKey : sorted.keySet()) {
                sorted.get(sortedKey).printStation();
            }
        
           } 
           finally {
               br.close();
           } 
           
       }
/**
 * We view the list by creating an instance of the class Sim and
 * also we view the list by using the readcsv method to view the stations in a table format
 * @throws IOException
 */
     public static void ViewList() throws IOException {
           ValleyBikeSim sim = new ValleyBikeSim();
           sim.readcsv("data-files/station-data.csv");
     }
     
     /**
      * Our initial assumption was that an addToList method would add the new station information and auto-save it to the csv file.
      * This method takes in user input and is able to create a new line in the csv in order to add the new information to the one
      * already present.
      */
     public static void addToList() throws IOException {
         
          FileWriter csvFilename = new FileWriter ("data-files/station-data.csv",true);
          System.out.println("Enter your information in the following format: \n" + 
          "ID,Name,Bike,Pedelecs,Available Docks,Maintinance Request,Capacity,Kiosk,Address: ");
          Scanner newStation = new Scanner(System.in);             
          String s = newStation.nextLine();
          csvFilename.write("\n"+s);
          csvFilename.flush();
          csvFilename.close();
          
           
       }
     /**
      * Our initial assumption was that an addToList method would add the new station information and auto-save it to the csv file.
      * This method takes in  makes sure that the user is able to save the list by having it display information in the table using
      * their new station. If the station information is wrong the user can manually go to the csv file and try again.
      */
       public static void saveToList() throws IOException {
           ValleyBikeSim newStationList = new ValleyBikeSim();
           newStationList.readcsv("data-files/station-data.csv");
       }
       
     /**  Our assumption is that the formatting we included is the correct format in order to get the appropriate result for resolveRide()
       public static void recordRide() { 
           SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
           System.out.println("Enter your ride info in the following way: User,From,To,Start,End");
           Scanner recordedRide = new Scanner(System.in);
           String ride = null;
          
          We take in the information and store it in the simpledateformat to store into a new csv file
          
       }
     */  
  
    /**Our assumption is that the files are stored in the data-files as a csv.  
     *  public static void resolveRide() {
           System.out.println("Enter the file name (including extension) of the file located in data-files: ");
          From the csv separate the columns and convert to dates and numbers to find the average ride.
       }
    */
       
       /**pseudocode: Our assumptions include that all bikes are the same and pedelecs will not be taken into consideration 
        * public static void equalizer(){
        * 
        * read how many bikes are in each station
        * see how many bikes slots are in the stations
        * figure out a ratio
        * refresh the number of bikes
        * 
        * }
        */
       
       /**
        * The main class makes sure to take in the choices in the menu so that the appropriate action can occur.
        * @param args
        * @throws IOException
        */
       
   public static void main(String[] args) throws IOException {
       System.out.println("Welcome to the ValleyBike Simulator.");
       intro();
       Scanner input = new Scanner(System.in);
       int choice = input.nextInt();
           while(choice != 0) {
           if(choice == 1) {
               ViewList();
               intro();
           }
           else if(choice == 2) {
               addToList();
               intro();
           }
           else if (choice ==3) {
               saveToList();
               intro();
           }
//           else if(choice == 4) {
//             recordRide();
//             intro();
//           }
//           else if(choice == 5) {
//             resolveRide();
//             intro();
//           }
//           else if(choice == 6) {
//             equalizer();
//              intro();
//           }
           else {
               System.out.println("Error. Option unavailable.");
               quit();
           }
           choice = input.nextInt();
       }
           
   }
}