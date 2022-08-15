
import java.util.ArrayList;

public class DesignerMenu {
	//ArrayList
	static ArrayList<Quotation> quotationList = new ArrayList<Quotation>();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//INITIALIZE OBJECTS

		//Quotation
		quotationList.add(new Quotation("R1","Q1","Kitchen","Urban style", "Keyon", "2022-12-25", 6300.59));
		quotationList.add(new Quotation("R2","Q2","Bedroom","Urban style", "Keyon", "2022-11-25", 4700.50));
		//(String requestID, String quotationID, String category, String descriptions, String designerName, 
		//String startDate, double quotationAmt)
		
		String username = Helper.readString("Enter username > ");
		String password = Helper.readString("Enter password > ");
		
		Designer designer = new Designer(1, "Keyon", "Keyon123");
			
		
		
		username = Helper.readString("Enter username > ");
		password = Helper.readString("Enter password > ");
		
		
		boolean isDesigner = DesignerMenu.loginD(designer, username, password); // if match will become true
	
		while(isDesigner) {
		
		int option = -1;

		while (option != 4) {
			quotationMenu();
			option = Helper.readInt("Enter choice > ");

			if (option == 1) {
				//VIEW ALL QUOTATION;
				Helper.line(80, "-");	
				System.out.println("Display All Quotation");
				Helper.line(80, "-");	
				DesignerMenu.viewAllQuotation(quotationList); //Call View All quotation method
			}
	
			else if (option == 2) {
				//
				Helper.line(80, "-");	
				System.out.println("Add Quotation");
				Helper.line(80, "-");	
				
				
			DesignerMenu.addQuotation(quotationList);
			DesignerMenu.viewAllQuotation(quotationList);
				
			}

			else if (option == 3) {
				//
				Helper.line(80, "-");	
				System.out.println("Delete Quotation");
				Helper.line(80, "-");	
				removeQuotation();
				
				
				
			} else if (option == 4) {
				//System.out.println("Exiting Program!");
				//Helper.line(80, "-");	
				//System.out.println("Return to Main Menu");
				//Helper.line(80, "-");	
				System.out.println("End of Program"); //To be modified into the Main Application
				
			} 
			
		} 
		break;
		}
		
	}
//==========================Methods===================================
	
	public static void quotationMenu() {
		System.out.println("QUOTATION SCREEN");
		System.out.println("Designer Menu");
		System.out.println("1. Display All Quotation");
		System.out.println("2. Add Quotation");
		System.out.println("3. Delete Quotation");
		System.out.println("4. Return to Main Menu");
		Helper.line(80, "-");	
	}
	
	public static boolean loginD(Designer designer, String username, String password) {
		//using if so that it can check whether username and
		//password is the same as the one in the array
		//for username we can ignore case but password has to be exactly the same
		if (username.equalsIgnoreCase(designer.getUsername()) && password.equals(designer.getPassword())) {
			return true;
		}else {
			return false;
		
	}
	}
	//================================= Option 1 View quotation list =================================
			public static String retrieveAllQuotation(ArrayList<Quotation> quotationList) {
				String output = "";

				for (int i = 0; i < quotationList.size(); i++) {

					output += String.format("%-15s %-15s %-20s %-30s %-20s %-20s $%-20.2f\n", quotationList.get(i).getRequestID(),
							quotationList.get(i).getQuotationID(),quotationList.get(i).getCategory(), quotationList.get(i).getDescriptions(),quotationList.get(i).getDesignerName(), quotationList.get(i).getStartDate(), quotationList.get(i).getQuotationAmt() ) ;
							
				}
				return output;
			}
			public static void viewAllQuotation(ArrayList<Quotation> quotationList) {
				C206_CaseStudy.setHeader("CUSTOMERS LIST");
				String output = String.format("%-15s %-15s %-20s %-30s %-20s %-20s %-20s\n", "Request ID", "Quotation ID",
						"Category", "Description","Designer Name", "Start Date", "Quotation Amount");
				 output += retrieveAllQuotation(quotationList);	
				System.out.println(output);
			}
			//================================= Option 2 Add a Quotation =================================
			public static void addQuotation(ArrayList<Quotation> quotationList) {
				String requestID = Helper.readString("Enter Request ID > ");
				String quotationID = Helper.readString("Enter quotation ID > ");
				String category = Helper.readString("Enter category > ");  //(Kitchen, Living Room, Bedroom, etc)
				String descriptions = Helper.readString("Enter description >");
				String designerName = Helper.readString("Enter designer name > ");
				String startDate = Helper.readString("Enter start date > ");
				double quotationAmt = Helper.readDouble("Enter quotation amount > ");
				

				
				Quotation q = new Quotation(requestID, quotationID, category, descriptions, designerName, startDate, quotationAmt);
				quotationList.add(q);
		
				
			}
			
			

			//================================= Option 3 Remove a Quotation =================================
			public static void removeQuotation() {

				String QID = Helper.readString("Enter Quotation ID to delete > ");
				
				int qFound = -1;
				for (Quotation q : quotationList) {
					if (q.getQuotationID().equals(QID)) {
						qFound = quotationList.indexOf(q);
					}
					
					} if (qFound != -1) {
						quotationList.remove(qFound);
						System.out.println("Quotation successfully removed");
						
					} else {
						System.out.println("Invalid Input. Quotation ID does not exist");
					}

		}
		
	
	
	
}
//hello