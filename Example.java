
import java.util.*;
class Example{
    //-----------------CREATE ARRAYS-----------------
    public static String[] generateContactArray = new String[0];
    public static String[] nameArray = new String[0];
    public static String[] phoneNumberArray = new String[0];
    public static String[] companyArray = new String[0];
    public static double[] salaryArray = new double[0];
    public static String[] birthdayArray = new String[0];

	// generate id
	public static int generateContactIdCount = 0;
	public static String generateContactId() {
        generateContactIdCount++;
        String contactId = null;

        if (generateContactIdCount < 10) {
            contactId = " C000" + generateContactIdCount;
        } else if (generateContactIdCount < 100) {
            contactId = " C00" + generateContactIdCount;
        } else if (generateContactIdCount < 1000) {
            contactId = " C0" + generateContactIdCount;
        } else if (generateContactIdCount < 10000) {
            contactId = " C" + generateContactIdCount;
        }
        return contactId;

    }
    
    //check valid date
     public static boolean isValidBirthday(String birthday) {
		if (birthday.length() != 10) {
            return false;
        }
        
        String yearStr = birthday.substring(0, 4);
        String monthStr = birthday.substring(5, 7);
        String dayStr = birthday.substring(8, 10);
        
        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);
        int day = Integer.parseInt(dayStr);
        if (year < 1000 || year > 9999 || month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }
        int currentYear = java.time.LocalDate.now().getYear();
        if (year > currentYear) {
            return false;
        }

        return true;  
	}
 
	
	//check phone number 
	public static  boolean isValidPhoneNumber(String number){
		String numberStr = String.valueOf(number);
		char ch= numberStr.charAt(0);
		if (ch=='0')
		{
			return numberStr.length() == 10;
		}
		return false;
	}

	
	// clear console
	public final static void clearConsole(){
		try {   
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c","cls").inheritIO().start().waitFor();
			}else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		}catch (final Exception e) {
			e.printStackTrace();
		}
	}
	
	//delete id elemnet 
	public static void deleteID(int index){
		//int elementToDelete = index;
		String[] newIdArray = new String[generateContactArray.length-1];
		String[] newNameArray = new String[nameArray.length-1];
		String[] newPhoneNumberArray = new String[phoneNumberArray.length-1];
		String[] newCompanyArray = new String[companyArray.length-1];
		double[] newSalaryArray = new double[salaryArray.length-1];
		String[] newBirthdayArray = new String[birthdayArray.length-1];
		
		for(int i=0, k=0;i<generateContactArray.length;i++){
            if(i!=index){
                newIdArray[k]=generateContactArray[i];
                newNameArray[k]=nameArray[i];
                newPhoneNumberArray[k]=phoneNumberArray[i];
                newCompanyArray[k]=companyArray[i];
                newSalaryArray[k]=salaryArray[i];
                newBirthdayArray[k]=birthdayArray[i];
                k++;
            }
        }
			generateContactArray = newIdArray;
			nameArray = newNameArray;
			phoneNumberArray = newPhoneNumberArray;
			companyArray = newCompanyArray;
			salaryArray = newSalaryArray;
			birthdayArray = newBirthdayArray;

	}
	
	// extend arrays
	public static void extendArrays(){
        String[] tempContactIdArray = new String[generateContactArray.length+1];
        String[] tempNameArray = new String[generateContactArray.length+1];
        String[] tempphoneNumberArray = new String[generateContactArray.length+1];
        String[] tempCompanyArray = new String[generateContactArray.length+1];
        double[] tempSalaryArray = new double[generateContactArray.length+1];
        String[] tempBirthdayArray = new String[generateContactArray.length+1];

        for(int i = 0; i<generateContactArray.length; i++ ){
            tempContactIdArray[i] = generateContactArray[i];
            tempNameArray[i] = nameArray[i];
            tempphoneNumberArray[i] = phoneNumberArray[i];
            tempCompanyArray[i] = companyArray[i];
            tempSalaryArray[i] = salaryArray[i];
            tempBirthdayArray[i] = birthdayArray[i];
        }
        generateContactArray = tempContactIdArray;
        nameArray = tempNameArray;
        phoneNumberArray = tempphoneNumberArray;
        companyArray = tempCompanyArray;
        salaryArray = tempSalaryArray;
        birthdayArray = tempBirthdayArray;

    }
    
    //check valid salary
    public static boolean isValidSalary(double salary){
        return salary > 0;
    }
    
    //search 
    public static int search(String nameOrNumber){
		for (int i = 0; i < nameArray.length; i++)
		{
			if (nameArray[i].equals(nameOrNumber) || phoneNumberArray[i].equals(nameOrNumber))
			{
				return i;
			}
		}
		return -1;
	}


	//updateName
	public static int updateName(int index){
		Scanner input = new Scanner(System.in);
		System.out.println("=======Update Name=========");
		System.out.println();
		
		System.out.print("Input new name - : ");
        String newName = input.next();
        
        nameArray[index] = newName;
        System.out.println("Contact has been updated ");
        
        System.out.print("Do you want to Update another contact (Y/N) : ");
				char ch1 = input.next().charAt(0);
				clearConsole();
				if(ch1 == 'Y' || ch1 == 'y'){
					updateContact();
				}else if(ch1 == 'N' || ch1 == 'n'){
					homePage();
					
				}
				
        return index;
	}
	
	//updatePhone number
	public static int updatePhoneNumber(int index){
		Scanner input = new Scanner(System.in);
		System.out.println("=======Update Number=========");
		System.out.println();
		
		System.out.print("Input new Phone number - : ");
        String newNumber = input.next();
        
        phoneNumberArray[index] = newNumber;
        
        System.out.println("Contact has been updated ");
        
        System.out.print("Do you want to Update another contact (Y/N) : ");
				char ch1 = input.next().charAt(0);
				clearConsole();
				if(ch1 == 'Y' || ch1 == 'y'){
					updateContact();
				}else if(ch1 == 'N' || ch1 == 'n'){
					homePage();
					
				}
				
        return index;
	}
	
		//update company name
	public static int updateCompanyName(int index){
		Scanner input = new Scanner(System.in);
		System.out.println("=======Update Company Name=========");
		System.out.println();
		
		System.out.print("Input new Phone number - : ");
        String newCompanyName = input.next();
        
        companyArray[index] = newCompanyName;
        
        System.out.println("Contact has been updated ");
        
        System.out.print("Do you want to Update another contact (Y/N) : ");
				char ch1 = input.next().charAt(0);
				clearConsole();
				if(ch1 == 'Y' || ch1 == 'y'){
					updateContact();
				}else if(ch1 == 'N' || ch1 == 'n'){
					homePage();
					
				}
				
        return index;
	}
	
	
		//update salary
	public static int updateSalary(int index){
		Scanner input = new Scanner(System.in);
		System.out.println("=======Update Salary=========");
		System.out.println();
		
		System.out.print("Input new Salary - : ");
        Double newSalary = input.nextDouble();
        
        salaryArray[index] = newSalary;
        
        System.out.println("Contact has been updated ");
        
        System.out.print("Do you want to Update another contact (Y/N) : ");
				char ch1 = input.next().charAt(0);
				clearConsole();
				if(ch1 == 'Y' || ch1 == 'y'){
					updateContact();
				}else if(ch1 == 'N' || ch1 == 'n'){
					homePage();
					
				}
				
        return index;
	}


    //-----------------HOME PAGE-----------------
    public static void homePage(){
        Scanner input = new Scanner(System.in);
        //System.out.println("===============iFRIEND CONTACTS ORGANIZER===================");
        System.out.println("\n[01] ADD Contact");
        System.out.println("\n[02] Update Contacts");
        System.out.println("\n[03] Delete Contacts");
        System.out.println("\n[04] Search Contacts");
        System.out.println("\n[05] List Contacts");
        System.out.println("\n[06] Exit");
        System.out.println("\nEnter option to continue : ");
        int option = input.nextInt();
        clearConsole();
        switch(option) {
            case 1 : addContact();break;
            case 2 : updateContact();break;
            case 3 : deleteContact();break;
            case 4 : searchContact();break; 
            case 5 : sortContact();break; 
            case 6 : break;
            default : System.out.println("Invalid option");System.exit(0);
        }
        
    }
    
        //-----------------ADD CONTACTS-----------------
    public static void addContact(){
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("================ADD Contact =================");
			System.out.println();
            String contactIdPrint = generateContactId();
			System.out.println(contactIdPrint);
            
            
            
            System.out.print("Customer name : ");
            String name = input.next();
            String number;
            do
			{
				System.out.print("Phone Number : ");
				number = input.next();
				if (!isValidPhoneNumber(number))
				{
					System.out.println("Invalid Phone number...!");
					System.out.print("Do you want to add phone number again (Y/N) : ");
					char ch1 = input.next().charAt(0);
					clearConsole();
					if(ch1 == 'Y' || ch1 == 'y'){
						System.out.print("\033[4A");
						System.out.print("\033[0J");
						
					}else if(ch1 == 'N' || ch1 == 'n'){
						homePage();
						break;
					}
				}
			} while (!isValidPhoneNumber(number));
			
			System.out.print("Enter Company: ");
            String company = input.next();
            
            double salary;
            do{
                System.out.print("Salary : ");
                salary = input.nextDouble();
                if(!isValidSalary(salary)){
                    System.out.println("Invalid salary...");
                    System.out.print("\nDo you want to input salary again ? ");
                    char ch = input.next().charAt(0);
                    if(ch=='Y'|ch=='y'){
                        System.out.print("\033[4A");
                        System.out.print("\033[0J");

                    }else if(ch=='N'|ch=='n'){
                        homePage();
                        break;
                    }
                }
            }while(!isValidSalary(salary));
            
            
            String birthday;
            do
			{
				System.out.print("Enter Birthday (YYYY-MM-DD): ");
				birthday = input.next();
				if (!isValidBirthday(birthday)) {
					System.out.println("Invalid Date format ...!");
					System.out.print("Do you want to add Birthday again (Y/N) : ");
					char ch1 = input.next().charAt(0);
					clearConsole();
					if(ch1 == 'Y' || ch1 == 'y'){
						System.out.print("\033[4A");
						System.out.print("\033[0J");
						
					}else if(ch1 == 'N' || ch1 == 'n'){
						homePage();
						break;
					}
				}
			} while (!isValidBirthday(birthday));
			

            extendArrays();

            generateContactArray[generateContactArray.length - 1] = contactIdPrint;
            nameArray[nameArray.length-1] = name;
            phoneNumberArray[phoneNumberArray.length-1] = number;
            companyArray[companyArray.length-1] = company;
            salaryArray[salaryArray.length-1] = salary;
            birthdayArray[birthdayArray.length-1] = birthday;
            
        
            System.out.println("\nContact added successfully...");
            System.out.print("\nDo you want to add another Contact ? ");
            char ch = input.next().charAt(0);
            clearConsole();
            if(ch == 'Y' || ch == 'y'){
                continue;
                
            }else if(ch == 'N' || ch == 'n'){
                homePage();
                break;
            }


        }while(true);

        
    } 
    
   
    //-----------------Update CONTACTS-----------------
    public static int updateContact(){
		Scanner input = new Scanner(System.in);
		do
		{
			System.out.println("================Update Contact =================");
			System.out.println();
			System.out.print("Search contact by Name ot Phone Number - : ");
			System.out.println();
			String nameOrNumber = input.next();
			
            int index = search(nameOrNumber);
             
             System.out.println("Contact ID : " + generateContactArray[index]);
			 System.out.println("Name : " + nameArray[index]);
			 System.out.println("Phone number : " + phoneNumberArray[index]);
			 System.out.println("Company name : " + companyArray[index]);
			 System.out.println("Salary : " + salaryArray[index]);
			 System.out.println("B' Day(YYYY-MM-DD) : " + birthdayArray[index]);
             
            //return index;
            System.out.println();
            System.out.print("What do you want to update... : ");
			System.out.println();
			System.out.println("\n[01] Name");
			System.out.println("\n[02] Phone Number");
			System.out.println("\n[03] Compnay Name");
			System.out.println("\n[04] Salary");
			System.out.println("\nEnter option to continue : ");
			int option = input.nextInt();
			clearConsole();
			switch(option) {
				case 1 : updateName(index);break;
				case 2 : updatePhoneNumber(index);break;
				case 3 : updateCompanyName(index);break;
				case 4 : updateSalary(index);break;
				default : System.out.println("Invalid option");System.exit(0);
			}
        
		} while (true);
		
	}
   
   
       //-----------------Delete CONTACTS-----------------
    public static int deleteContact(){
		Scanner input = new Scanner(System.in);
		do
		{
			System.out.println("================Delete Contact =================");
			System.out.println();
			System.out.print("Search contact by Name ot Phone Number - : ");
			System.out.println();
			String nameOrNumber = input.next();
			
            int index = search(nameOrNumber);
             
            if (index==-1)
			{
				System.out.println("No contact found " +nameOrNumber  );
			}else{
				System.out.println("Contact ID : " + generateContactArray[index]);
				System.out.println("Name : " + nameArray[index]);
				System.out.println("Phone number : " + phoneNumberArray[index]);
				System.out.println("Company name : " + companyArray[index]);
				System.out.println("Salary : " + salaryArray[index]);
				System.out.println("B' Day(YYYY-MM-DD) : " + birthdayArray[index]);
				
				
				System.out.println();
				System.out.print("Do you want to delete this contact (Y/N) : ");
				char ch1 = input.next().charAt(0);
				clearConsole();
				if(ch1 == 'Y' || ch1 == 'y'){
						deleteID(index);
						System.out.println("Contact deleted successfully.");
				}else if(ch1 == 'N' || ch1 == 'n'){
						System.out.println("Deletion cancelled.");
						homePage();
				}
			
			}
             
            
			
			
			
			
		} while (true);
		
	}
	
	
   
   
   //-----------------SEARCH CONTACTS-----------------
	public static void searchContact(){
		Scanner input = new Scanner(System.in);
		do
		{
			System.out.println("================SEARCH Contact =================");
			System.out.println();
			System.out.print("Search contact by Name ot Phone Number - : ");
            String nameOrNumber = input.next();
            
            int index = search(nameOrNumber);
            
            if (index==-1)
			{
				System.out.println("Invalid Name or Number ...!");
				System.out.print("Do you want to Search contact again (Y/N) : ");
				char ch1 = input.next().charAt(0);
				clearConsole();
				if(ch1 == 'Y' || ch1 == 'y'){
					System.out.print("\033[3A");
					System.out.print("\033[0J");
				}else if(ch1 == 'N' || ch1 == 'n'){
					homePage();
					break;
				}
			}else{
				System.out.println("Contact ID : " + generateContactArray[index]);
				System.out.println("Name : " + nameArray[index]);
				System.out.println("Phone number : " + phoneNumberArray[index]);
				System.out.println("Company name : " + companyArray[index]);
				System.out.println("Salary : " + salaryArray[index]);
				System.out.println("B' Day(YYYY-MM-DD) : " + birthdayArray[index]);
				
				System.out.print("Do you want to Search another contact (Y/N) : ");
				char ch1 = input.next().charAt(0);
				clearConsole();
				if(ch1 == 'Y' || ch1 == 'y'){
					System.out.print("\033[7A");
					System.out.print("\033[0J");
				}else if(ch1 == 'N' || ch1 == 'n'){
					homePage();
					break;
				}
				//return index;
			}
			
			 
		} while (true);
		
	}
	
	
	    //-----------------Sort CONTACTS-----------------
    public static void sortContact(){
		Scanner input = new Scanner(System.in);
		L2: do
		{
			System.out.println("================SORT Contact =================");
			System.out.println();
			System.out.println("\n[01] Sorting by Name");
			System.out.println("\n[02] Sorting by Salary");
			System.out.println("\n[03] Sorting by Birthday");
			System.out.println("\nEnter option to continue : ");
			int option = input.nextInt();
			clearConsole();
			switch(option) {
				case 1 : sortByNames();break;
				case 2 : sortBySalary();break;
				case 3 : sortByBirthday();break;
				default : return;
			}
			while (true){
				System.out.print("Do you want to go Home Page (Y/N) : ");
				char ch1 = input.next().toUpperCase().charAt(0);
				clearConsole();
				if(ch1 == 'Y' || ch1 == 'y'){
					homePage();
				}else {
					continue L2;
				}
			}
		} while (true);
	}
	
	
	public static void sortByNames(){
		for (int i=1; i<nameArray.length; i++){
			for (int j=0; j<i; j++){
				if (nameArray[j].compareTo(nameArray[i])>0){
					commonSort(i,j);
				}
			}
		}
		printSortList("Name");
	}
	
	public static void sortBySalary(){
		
		for (int i=1; i<salaryArray.length; i++){
			for (int j=0; j<i; j++){
				if (salaryArray[j]>salaryArray[i]){
					commonSort(i,j);
				}
			}
		}
		printSortList("Salary");
	}
	
	public static void sortByBirthday(){
		for (int i=1; i<birthdayArray.length; i++){
			for (int j=0; j<i; j++){
				if (birthdayArray[j].compareTo(birthdayArray[i])>0){
					commonSort(i,j);
				}
			}
		}
		printSortList("Birthday");
	}
	
	
	
	
	
	
	public static void commonSort(int i,int j){
		//----swap ID
		String tempId = generateContactArray[i];
		generateContactArray[i] = generateContactArray[j];
		generateContactArray[j] = tempId;
					
		//----swap name
		String tempName = nameArray[i];
		nameArray[i] = nameArray[j];
		nameArray[j] = tempName;
		
				
		String tempPhone = phoneNumberArray[i];
		phoneNumberArray[i] = phoneNumberArray[j];
		phoneNumberArray[j] = tempPhone;
					

		String tempCompany = companyArray[i];
		companyArray[i] = companyArray[j];
		companyArray[j] = tempCompany;
					
		
		double tempSalary = salaryArray[i];
		salaryArray[i] = salaryArray[j];
		salaryArray[j] = tempSalary;
					
		
		String tempBirthDay = birthdayArray[i];
		birthdayArray[i] = birthdayArray[j];
		birthdayArray[j] = tempBirthDay;
					
	}
	
	
		//PrintList
		public static void printSortList(String str){
		
		System.out.printf("|List Contact by %-8s\t\n", str );
		System.out.println("+-----------------------+\n");
		
		System.out.println("+----------------------------------------------------------------------------------------+");
		System.out.println("| Contact ID  |     Name     | Phone Number |   Company    |    Salary    |   Birthday   |");
		System.out.println("+----------------------------------------------------------------------------------------+");
		for(int i=0; i<generateContactArray.length;i++){
			System.out.printf("| %-12s| %-13s| %-13s| %-13s| %-13s| %-13s|\n",generateContactArray[i],nameArray[i],phoneNumberArray[i],companyArray[i],salaryArray[i],birthdayArray[i]);
		}
		System.out.println("+----------------------------------------------------------------------------------------+");
		
	}
	
	

   
   
    //-----------------MAIN METHOD-----------------
    public static void main(String[] args){
				System.out.println("	 /$$$$$$ /$$$$$$$$ /$$$$$$$  /$$$$$$ /$$$$$$$$ /$$   /$$ /$$$$$$$ \n" +
                 "	|_  $$_/| $$_____/| $$__  $$|_  $$_/| $$_____/| $$$ | $$| $$__  $$\n" +
                 "	  | $$  | $$      | $$  \\ $$  | $$  | $$      | $$$$| $$| $$  \\ $$\n" +
                 "	  | $$  | $$$$$   | $$$$$$$/  | $$  | $$$$$   | $$ $$ $$| $$  | $$\n" +
                 "	  | $$  | $$__/   | $$__  $$  | $$  | $$__/   | $$  $$$$| $$  | $$\n" +
                 "	  | $$  | $$      | $$  \\ $$  | $$  | $$      | $$\\  $$$| $$  | $$\n" +
                 "	 /$$$$$$| $$      | $$  | $$ /$$$$$$| $$$$$$$$| $$ \\  $$| $$$$$$$/\n" +
                 "	|______/|__/      |__/  |__/|______/|________/|__/  \\__/|_______/ ");
                 
         System.out.println("\n\n\n  ____            _             _           \n" +
                 " / ___|___  _ __ | |_ __ _  ___| |_ ___      / _ \\ _ __ __ _  __ _ _ __ (_)_______ _ __\n" +
                 "| |   / _ \\| '_ \\| __/ _` |/ __| __/ __|    | | | | '__/ _` |/ _` | '_ \\| |_  / _ \\ '__|\n" +
                 "| |__| (_) | | | | || (_| | (__| |_\\__ \\    | |_| | | | (_| | (_| | | | | |/ /  __/ |   \n" +
                 " \\____\\___/|_| |_|\\__\\__,_|\\___|\\__|___/     \\___/|_|  \\__, |\\__,_|_| |_|_/___\\___|_|   \n" +
                 "\t\t\t\t\t               |___/             ");
                 
                 
        homePage();
    }



}


