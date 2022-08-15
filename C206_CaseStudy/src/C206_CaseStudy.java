import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class C206_CaseStudy {
	
	static ArrayList<CustomerInfo> cInfo = new ArrayList<CustomerInfo>();
	static ArrayList<Package> packageList = new ArrayList<Package>();
	static ArrayList<Quotation> quotationList = new ArrayList<Quotation>();
	static ArrayList<QuotationRequest> qrList = new ArrayList<QuotationRequest>();
	
	public static void main(String[] args) {

		
		cInfo.add(new CustomerInfo("Chester", "chester@gmail.com", "chester123","Customer","New"));
		cInfo.add(new CustomerInfo("Gloria", "gloria@gmail.com", "gloria123","Customer","New"));
		cInfo.add(new CustomerInfo("Owen", "owen@gmail.com", "owen123","Customer","New"));
		cInfo.add(new CustomerInfo("Tom","tom@gmail.com", "tom123","Customer","New"));

		packageList.add(new Package("P011", "Restrooms", convertDate("2022-09-09"),convertDate("2022-11-11"), 5000.00));
		packageList.add(new Package("P012", "Kitchen Only", convertDate("2022-10-10"),convertDate("2022-12-12"), 7500.00));
		packageList.add(new Package("P013", "Whole Place", convertDate("2022-11-11"),convertDate("2022-12-30"), 15000.00));
		
		qrList.add(new QuotationRequest("Chester", "chester@gmail.com", "R011", "HDB", 1280, "86543210", 100000, convertDate("2022-09-10"), "Whole House", 4, 2, "Vintage", true, convertDate("2022-11-10")));
		qrList.add(new QuotationRequest("Gloria", "gloria@gmail.com", "R012", "Private Property", 1600, "87654321", 10000, convertDate("2022-09-10"), "Room", 1, 0, "Retro", false, convertDate("2023-01-10")));
		qrList.add(new QuotationRequest("Owen", "owen@gmail.com", "R013", "Landed Property", 2160, "98765432", 1000000, convertDate("2022-09-10"), "Whole House", 6, 3, "Modern", false, convertDate("2023-04-10")));

		quotationList.add(new Quotation("R011","Q1","Kitchen","Urban style", "Keyon", "2022-12-25", 6300.59));
		quotationList.add(new Quotation("R012","Q2","Bedroom","Urban style", "Keyon", "2022-11-25", 4700.50));

		Admin admin = new Admin(1, "Genesis", "Genesis123");
		Designer designer = new Designer(1, "Keyon", "Keyon123");
		
		while(true) {
			Helper.line(30, "=");
			System.out.println("Renovation ACE - LOGIN");
			Helper.line(30, "=");
			
			String username = Helper.readString("Enter username > ");
			String password = Helper.readString("Enter password > ");
			
			boolean isAdmin = C206_CaseStudy.login(admin, username, password);
			boolean isDesigner = DesignerMenu.loginD(designer, username, password); // if match will become true
			boolean isCustomer = C206_CaseStudy.loginC(cInfo, username, password); // if match will become true
			
			if (isAdmin == true && isDesigner == false && isCustomer == false) {
				System.out.println("Logged in as Admin!");
			} else if (isAdmin == false && isDesigner == true && isCustomer == false) {
				System.out.println("Logged in as Designer!");
			} else if (isAdmin == false && isDesigner == false && isCustomer == true) {
				System.out.println("Logged in as Customer!");
				
			} else {
				System.out.println("Invalid username or password! Please try again.");
			}
				

			while (isAdmin) {

				C206_CaseStudy.mainMenu();
				int menuOption = Helper.readInt("Enter an option > ");
				
				while (menuOption != 4) {
					if (menuOption == 1) {
						
						C206_CaseStudy.customerMenu();
						int customerOption = Helper.readInt("Enter an option > ");

							String output = "";
							if (customerOption == 1) {
								// View all items
								C206_CaseStudy.viewAllCustomersInfo(cInfo);

							} else if (customerOption == 2) {
							
								C206_CaseStudy.setHeader("ADD MEMBER");		
								// Add a new member
								CustomerInfo ci = inputCustomer();
								C206_CaseStudy.addCustomerInfo(cInfo, ci);
								System.out.println("Member added");
							
							}else if (customerOption == 3) {
							
								C206_CaseStudy.setHeader("REMOVE MEMBER");	
								// Remove a new member
								int intOfMember = removeMemberInput();
								removeMember(cInfo, intOfMember);

							} else if (customerOption == 4 ) {

								
								System.out.println("Returning to main menu...");
								C206_CaseStudy.mainMenu();
								menuOption = Helper.readInt("Enter a menu option > ");

								} else {
								System.out.println("Invalid option");
								
						}
							System.out.println(output + "\n");
					
					} else if (menuOption == 2) {
						C206_CaseStudy.packageMenu();
						int packageOption = Helper.readInt("Enter option > ");
						String output = "";
						
							if (packageOption == 1) {
								viewAllPackage(packageList);
								
							} else if (packageOption == 2) {
								C206_CaseStudy.setHeader("ADD PACKAGE");		
								Package pi = packageInput();
								C206_CaseStudy.addPackage(packageList, pi);
								
								System.out.println("Package added");
							} else if (packageOption == 3) {
								setHeader("DELETE PACKAGES");
								int intOfPackage = deletePackageInput();
								deletePackage(packageList, intOfPackage);
								
							} else if (packageOption == 4 ) {

								System.out.println("Returning to main menu...");
								C206_CaseStudy.mainMenu();
								menuOption = Helper.readInt("Enter a menu option > ");

							} else {
								System.out.println("Invalid option.");
							}
							System.out.println(output);
						}  if (menuOption == 3) {
							C206_CaseStudy.qrMenu();
							int qrOption = Helper.readInt("Enter an option > ");
							String output = "";
							
							if (qrOption == 1) {
								C206_CaseStudy.setHeader("VIEW ALL QUOTATION REQUESTS");
								viewAllQuotationRequest(qrList);
							}
							
							else if (qrOption == 2) {
								C206_CaseStudy.setHeader("ADD QUOTATION REQUEST");
								QuotationRequest qr = inputQuotationRequest();
								addQuotationRequest(qrList, qr);
							}
							else if (qrOption == 3) {
								C206_CaseStudy.setHeader("DELETE QUOTATION REQUESTS");
								int intOfQR = deleteQuotationRequestInput();
								deleteQuotationRequest(qrList, intOfQR);
							}
							
							else if (qrOption == 4) {
								System.out.println("Returning to main menu...");
								C206_CaseStudy.mainMenu();
								menuOption = Helper.readInt("Enter a menu option > ");
							}
							
							else {
								System.out.println("Invalid option.");
							}
							System.out.print(output);
						}
						
	
					}
				System.out.println("Thank you for using Renovation Ace App!");
				break;
					}	
		
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
						setHeader("DELETE Quotation");
						int intOfQuotation = removeQuotationInput();
						removeQuotation(quotationList, intOfQuotation);

						
						
						
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
			
			while(isCustomer) {
				int option = -1;

				while (option != 3) {
					cMenu();
					option = Helper.readInt("Enter choice > ");

					if (option == 1) {
						//Add QUotation Request DING ZHANG
						setHeader("Request for Quotation");
						QuotationRequest qr = inputQuotationRequest();
						addQuotationRequest(qrList, qr);
							}
			
					else if (option == 2) {
					
					//VIEW ALL QUOTATION;
					Helper.line(80, "-");	
					System.out.println("Display All Quotation");
					Helper.line(80, "-");	
					String rID = C206_CaseStudy.findRID(username, qrList);
					String output = C206_CaseStudy.viewCustomerQuotation(quotationList, rID);
					System.out.print(output);
				//Call View All quotation method
					viewAllQuotationRequest(qrList);
					}
					
					else if (option == 3) {
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
		} 

	public static boolean login(Admin admin, String username, String password) {
		//using if so that it can check whether username and
		//password is the same as the one in the array
		//for username we can ignore case but password has to be exactly the same
		if (username.equalsIgnoreCase(admin.getUsername()) && password.equals(admin.getPassword())) {
			return true;
		}else {
			return false;
		
	}
	}
	
	public static boolean loginC(ArrayList<CustomerInfo> cInfo, String email, String password) {
		//using if so that it can check whether username and
		boolean isFound = false;
		for (CustomerInfo c : cInfo) {
			if (c.getEmail().equals(email) && c.getPassword().equals(password)) {
				isFound = true;
				return isFound;
			} else {
				isFound = false;
			}
			
		}return isFound; 
	}

	
	public static void mainMenu() {
		C206_CaseStudy.setHeader("RenoAce APP");
		System.out.println("1. Manage Customer Details");
		System.out.println("2. Manage Package Details");
		System.out.println("3. Manage Quotations Request Details");
		System.out.println("4. Quit");

	}

	public static void customerMenu() {
		C206_CaseStudy.setHeader("RenoAce APP");
		System.out.println("1. View Customer details");
		System.out.println("2. Add New Customer");
		System.out.println("3. Remove Current Customer");
		System.out.println("4. Return to Main Menu");

	}
	
	public static void packageMenu() {
		System.out.println("PACKAGE SELECTION SCREEN");
		System.out.println("1. Display All Packages");
		System.out.println("2. Add Package");
		System.out.println("3. Delete Package");
		System.out.println("4. Return to Main Menu");
		Helper.line(80, "-");
	
}
	public static void qrMenu() {
		C206_CaseStudy.setHeader("QUOTATION REQUEST SELECTION SCREEN");
		System.out.println("1. Display All Quotation Requests");
		System.out.println("2. Add Quotation Request");
		System.out.println("3. Delete Quotation Request");
		System.out.println("4. Return to Main Menu");
		Helper.line(80, "-");
	
	}
	
	public static void cMenu() {
		C206_CaseStudy.setHeader("RenoAce APP");
		System.out.println("1. Request for Quotation");
		System.out.println("2. View Quotation");
		System.out.println("3. Return to Main Menu");

	}

	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	//================================= Option 1 View member list =================================
	public static String retrieveAllCustomers(ArrayList<CustomerInfo> cInfo) {
		String output = "";

		for (int i = 0; i < cInfo.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-10s %-20s\n", cInfo.get(i).getName(),
					cInfo.get(i).getEmail(), cInfo.get(i).getPassword(),cInfo.get(i).getRole(),cInfo.get(i).getStatus());
					
		}
		return output;
	}
	public static void viewAllCustomersInfo(ArrayList<CustomerInfo> cInfo) {
		C206_CaseStudy.setHeader("CUSTOMERS LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "NAME", "EMAIL",
				"PASSWORD", "ROLE","STATUS");
		 output += retrieveAllCustomers(cInfo);	
		System.out.println(output);
	}

	//================================= Option 2 Add a member =================================
	public static CustomerInfo inputCustomer() {
		String name = Helper.readString("Enter name > ");
		checkEmptyName(name);
		
		String email = Helper.readString("Enter email > ");
		checkDuplicateOrEmptyEmail(email);
		
		String password = Helper.readString("Enter password > ");
		checkEmptyPassword(password);
		
		String passwordConfirm = Helper.readString("Re-enter password > ");
		
		checkEmptyOrIncorrectPassword(password, passwordConfirm);

		String role = "Customer";
		String status = "New";

		CustomerInfo ci= new CustomerInfo(name,email, password,role ,status);
		return ci;
		
	}
	public static void addCustomerInfo(ArrayList<CustomerInfo> cInfo, CustomerInfo ci) {
		
		cInfo.add(ci);
		
	}
	
	public static void checkEmptyOrIncorrectPassword(String password, String passwordConfirm) {
		while (!password.equals(passwordConfirm) || ((password == null || password.trim().length() == 0 || passwordConfirm == null || passwordConfirm.trim().length() == 0))) {
			System.out.println("Invalid entry. Incorrect entry of password or no input detected. Please try again");
			password = Helper.readString("Enter password > ");
			passwordConfirm = Helper.readString("Re-enter password > ");
		}
	}
	
	public static void checkDuplicateOrEmptyEmail (String email) {
		
		for (CustomerInfo c : cInfo) {
			while (c.getEmail().equals(email) || email == null || email.trim().length() == 0) {
				System.out.println("Invalid input. Email already exists or no input detected");
				email = Helper.readString("Enter email > "); 
		}
	}
		
	}
	
	//================================= Option 3 Remove a member =================================
	public static int removeMemberInput() {
		String name = Helper.readString ("Enter name > ");
		
		int memberFound = -1;
		for (CustomerInfo c : cInfo) {
			if (c.getName().equals(name)) {
				memberFound = cInfo.indexOf(c);
			}
		}
			return memberFound;
		}
	public static void removeMember(ArrayList<CustomerInfo>cInfo, int memberFound) {
		
		if (memberFound != -1) {
				cInfo.remove(memberFound);
				System.out.println("Member successfully removed");
				
			} else {
				System.out.println("Invalid Input. Code package does not exist");
			}

}
	//=================================Zhong Rui General Check Methods=================================
	public static void checkEmptyName(String name) { 
		while (name == null || name.trim().length() == 0) {
			System.out.println("No input detected. Please try again.");
			name = Helper.readString("Enter name > ");
		}
	}
	
	public static void checkEmptyPassword(String password) { 
		while (password == null || password.trim().length() == 0) {
			System.out.println("No input detected. Please try again.");
			password = Helper.readString("Enter password > ");
		}
	}
	
	//=================================Chester General Methods=================================


	//=================================Chester Package Option 1 = View=================================
	
	public static String retrieveAllPackage(ArrayList<Package> packageList) {
		String output = "";

		for (Package p : packageList) {
			output += String.format("%-20s %-20s %-20s %-20s %-20s\n", p.getCode(), p.getDescription(),
					p.getStartDate(), p.getEndDate(), p.getAmount()) ;	
		}
		return output;
	}

	public static void viewAllPackage(ArrayList<Package> packageList) {
		C206_CaseStudy.setHeader("CUSTOMERS LIST");
		String output = String.format("%-20s %-20s %-20s %-20s %-20s\n", "CODE", "DESCRIPTION", "START DATE",
				"END DATE", "AMOUNT");
		 output += retrieveAllPackage(packageList);	
		System.out.print(output);
	}
	
	//=================================Chester Package Option 2 = Add=================================	
	public static Package packageInput() {
		String output = "";
		System.out.println("ADD PACKAGE");
		String code = Helper.readString("Enter code > "); 
		checkDuplicateOrEmptyCode(code);
		
		String description = Helper.readString("Enter description > ");
		checkEmptyDescription(description);
		
		String startDate = Helper.readString("Enter start date > ");
		checkEmptyStartDate(startDate);
		
		String endDate = Helper.readString("Enter end date > ");
		checkEmptyEndDate(endDate);
		checkDateDuration(startDate, endDate);
		
		String amount  = Helper.readString("Enter amount > ");
		checkEmptyAmount(amount);
		
		double parseAmount = Double.parseDouble(amount);
		
		Package pi = new Package(code, description, convertDate(startDate),convertDate(endDate), parseAmount);
		
		output = String.format("New Package added!\n%-20s %-20s %-20s %-20s %-20s\n", "CODE", "DESCRIPTION",
				"START DATE", "END DATE", "AMOUNT");
		output += String.format("%-20s %-20s %-20s %-20s $%-20s\n", code, description, startDate, endDate, amount);
		
		System.out.println(output);
		return pi;
	}
	
	public static void addPackage(ArrayList<Package> packageList, Package pi) {
		packageList.add(pi);

	}
	
	//=================================Chester Package Option 3 = Delete=================================
	
	public static int deletePackageInput() {
		String code = Helper.readString("Enter code > ");

		int codeFound = -1;
		for (Package c : packageList) {
			if (c.getCode().equals(code)) {
				codeFound = packageList.indexOf(c);
			}
	}

		return codeFound;
	}
		
	public static void deletePackage(ArrayList<Package> packageList, int codeFound) {

			if (codeFound != -1) {
				packageList.remove(codeFound);
				System.out.println("Package successfully removed");
				
			} else {
				System.out.println("Invalid Input. Code package does not exist");
			}

	}
	
	
	//=================================Chester Package Checker Methods=================================

	public static LocalDate convertDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
		
		LocalDate convertStringDate = LocalDate.parse(date, formatter);
		
		return convertStringDate;
	}
	
	public static void checkDateDuration(String startDate, String endDate) {
		LocalDate convertStartDate = convertDate(startDate);
		LocalDate convertEndDate = convertDate(endDate);
		
		while (convertStartDate.isAfter(convertEndDate)) {
			System.out.println("Invalid input. End date should not be before Start date.");
			startDate = Helper.readString("Enter start date > ");
			endDate = Helper.readString("Enter end date > ");
			convertStartDate = convertDate(startDate);
			convertEndDate = convertDate(endDate);
		}
		
	}
	
	public static void checkDuplicateOrEmptyCode (String code) {
		
		for (Package c : packageList) {
			while ((c.getCode().equals(code) || code == null || code.trim().length() == 0)) {
				System.out.println("Invalid input. Code already exists or no input detected");
				code = Helper.readString("Enter code > "); 
		}
	}
		
	}
	
	public static void checkEmptyDescription(String description) { 
		while (description == null || description.trim().length() == 0) {
			System.out.println("No input detected. Please try again.");
			description = Helper.readString("Enter description > ");
		}
	}
	
	public static void checkEmptyStartDate(String startDate) { 
		while (startDate == null || startDate.trim().length() == 0) {
			System.out.println("No input detected. Please try again.");
			startDate = Helper.readString("Enter startDate > ");
		}
	}
	
	public static void checkEmptyEndDate(String endDate) { 
		while (endDate == null || endDate.trim().length() == 0) {
			System.out.println("No input detected. Please try again.");
			endDate = Helper.readString("Enter endDate > ");
		}
	}
	
	public static void checkEmptyAmount(String amount) { 
		while (amount == null || amount.trim().length() == 0) {
			System.out.println("No input detected. Please try again.");
			amount = Helper.readString("Enter amount > ");
		}
	}
	
	//==========================Methods YI JIN===================================
	
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
									quotationList.get(i).getQuotationID(),quotationList.get(i).getCategory(), quotationList.get(i).getDescriptions(),quotationList.get(i).getDesignerName(), 
									quotationList.get(i).getStartDate(), quotationList.get(i).getQuotationAmt() ) ;
									
						}
						return output;
					}
					public static void viewAllQuotation(ArrayList<Quotation> quotationList) {
						
						String output = String.format("%-15s %-15s %-20s %-30s %-20s %-20s %-20s\n", "Request ID", "Quotation ID",
								"Category", "Description","Designer Name", "Start Date", "Quotation Amount");
						 output += retrieveAllQuotation(quotationList);	
						System.out.println(output);
					}
					
					//================================= Option 2 Add a Quotation =================================
					public static Quotation newQuotation() {
						String requestID = Helper.readString("Enter Request ID > ");
						String quotationID = Helper.readString("Enter quotation ID > ");
						String category = Helper.readString("Enter category > ");  //(Kitchen, Living Room, Bedroom, etc)
						String descriptions = Helper.readString("Enter description >");
						String designerName = Helper.readString("Enter designer name > ");
						String startDate = Helper.readString("Enter start date > ");
						double quotationAmt = Helper.readDouble("Enter quotation amount > ");
						Quotation q = new Quotation(requestID, quotationID, category, descriptions, designerName, startDate, quotationAmt);
						return q;

					}
					
					
					public static void addQuotation(ArrayList<Quotation> quotationList,Quotation q) {
						quotationList.add(q);						
					}
				
					//======================Customer view quotation============================
					// First search the quotation request list for the username and password details, if found, 
					public static String findRID(String email,  ArrayList<QuotationRequest> qrList) {
						String rID = "Error";
						
						for (QuotationRequest qr : qrList) {
							if (qr.getEmail().equals(email) ) {
							rID = qr.getRequestID();
						}
						
						}
						return rID;
					}

					public static String viewCustomerQuotation(ArrayList<Quotation> quotationList, String rID) {
						
						String output = "";

						int qCount = 0;
						for (int i = 0; i < quotationList.size(); i++) {
							if (quotationList.get(i).getRequestID().equals(rID)) {
							output += String.format("%-15s %-15s %-20s %-30s %-20s %-20s $%-20.2f\n", quotationList.get(i).getRequestID(),
									quotationList.get(i).getQuotationID(),quotationList.get(i).getCategory(), quotationList.get(i).getDescriptions(),quotationList.get(i).getDesignerName(), quotationList.get(i).getStartDate(), quotationList.get(i).getQuotationAmt() ) ;
									qCount++;
						
						}}
						if (qCount ==0) {
							output = "No Quotation Found";
						}
						return output;
					
						
					}
					//================================= Option 3 Remove a Quotation =================================
					public static int removeQuotationInput() {
						String qID = Helper.readString ("Enter Quotation ID > ");
						
						int idFound = -1;
						for (Quotation q : quotationList) {
							if (q.getQuotationID().equals(qID)) {
								idFound = quotationList.indexOf(q);
							}
						}
							return idFound;
						}
					public static void removeQuotation(ArrayList<Quotation> quotationList, int idFound) {
						
						if (idFound != -1) {
								quotationList.remove(idFound);
								System.out.println("Quotation successfully removed");
								
							} else {
								System.out.println("Invalid Input. Quotation does not exist");
							}

				}
					

				//=================================Ding Zhang General Check Methods=================================			

				public static void checkID (String requestID) {
					
					for (QuotationRequest qr : qrList) {
						while ((qr.getRequestID().equals(requestID) || requestID == null || requestID.trim().length() == 0)) {
							System.out.println("Error! Request ID is either used or empty, please re-enter.");
							requestID = Helper.readString("Enter ID > "); 
					}
				}			
			}
			
			public static void checkEmptyNumber(String contactNumber) { 
				while (contactNumber == null || contactNumber.trim().length() == 0) {
					System.out.println("No input detected. Please try again.");
					contactNumber = Helper.readString("Enter contact number > ");
				}
			}
			
			public static void checkEmptyEmail(String email) { 
				while (email == null || email.trim().length() == 0) {
					System.out.println("No input detected. Please try again.");
					email = Helper.readString("Enter email > ");
				}
			}
			
			public static void checkEmptyPropertyType(String propertyType) { 
				while (propertyType == null || propertyType.trim().length() == 0) {
					System.out.println("No input detected. Please try again.");
					propertyType = Helper.readString("Enter property type > ");
				}
			}
			
			public static void checkEmptyRenovationType(String renovationType) { 
				while (renovationType == null || renovationType.trim().length() == 0) {
					System.out.println("No input detected. Please try again.");
					renovationType = Helper.readString("Enter renovation type > ");
				}
			}
			
			
			public static void checkEmptyRequestDate(String requestDate) { 
				while (requestDate == null || requestDate.trim().length() == 0) {
					System.out.println("No input detected. Please try again.");
					requestDate = Helper.readString("Enter request date > ");
				}
			}
			
			
			public static void checkEmptyTCDate(String tcDate) { 
				while (tcDate == null || tcDate.trim().length() == 0) {
					System.out.println("No input detected. Please try again.");
					tcDate = Helper.readString("Enter target completion date > ");
				}
			}
			
			
			public static void checkDates(String requestDate, String tcDate) {
				LocalDate convertRequestDate = convertDate(requestDate);
				LocalDate convertTCDate = convertDate(tcDate);
				
				while (convertRequestDate.isAfter(convertTCDate)) {
					System.out.println("Invalid input. Target completion date should not be before Request date.");
					requestDate = Helper.readString("Enter start date > ");
					tcDate = Helper.readString("Enter end date > ");
					convertRequestDate = convertDate(requestDate);
					convertTCDate = convertDate(tcDate);
				}
			}
			
			
			public static void 	checkEmptyRenovationStyle(String renovationStyle) { 
				while (renovationStyle == null || renovationStyle.trim().length() == 0) {
					System.out.println("No input detected. Please try again.");
					renovationStyle = Helper.readString("Enter renovation style > ");
				}
			}
			
			//================================= Option 1 View quotation requests  =================================
			
			public static String retrieveAllQuotationRequest(ArrayList<QuotationRequest> qrList) {
				String output = "";

				for (QuotationRequest qr : qrList) {

					output += String.format("%-30s %-30s %-30s %-30s %-30s %-30.2f %-30.2f %-30s %-30s %-30s %-30s %-30b %-30d %-30d\n", qr.getRequestID(), qr.getName(), qr.getContactNumber(), qr.getEmail(),
							qr.getPropertyType(), qr.getAreaSize(), qr.getBudget(), qr.getTcDate().toString(), qr.getRequestDate().toString(), qr.getRenovationType(), qr.getRenovationStyle(), qr.getUrgent(), qr.getRooms(), qr.getToilets());
							
				}
				return output;
			}
			public static void viewAllQuotationRequest(ArrayList<QuotationRequest> qrList) {
				C206_CaseStudy.setHeader("Quotation Request LIST");
				String output = String.format("%-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s\n", "REQUEST ID", "REQUESTOR NAME",
						"CONTACT NUMBER", "EMAIL", "PROPERTY TYPE", "AREA SIZE(in sq. ft.)", "BUDGET", "REQUEST DATE", "TARGET COMPLETION DATE", "RENOVATION TYPE", "RENOVATION STYLE", "URGENT", "ROOMS", "TOILETS");
				 output += retrieveAllQuotationRequest(qrList);	
				System.out.println(output);
			}
						
			//================================= Option 2 ADD quotation list =================================
				public static QuotationRequest inputQuotationRequest() {
					String requestID = Helper.readString("Enter request ID > ");
					checkID(requestID);
					
					String requestorName = Helper.readString("Enter requestor name > ");
					checkEmptyName(requestorName);
					
					String NUMpattern = "[89][0-9]{7}";
					String contactNumber = Helper.readStringRegEx("Enter contact number > ", NUMpattern);
//					String contactNumber = Helper.readString("Enter contact number > ");
					checkEmptyNumber(contactNumber);
					
					String EMAILpattern = "^(.+)@(.+)$";
					String email = Helper.readStringRegEx("Enter email > ", EMAILpattern);
//					String email = Helper.readString("Enter email > ");
					checkEmptyEmail(email);
					
					String propertyType = Helper.readString("Enter property type (HDB/Private/Landed) > ");
					checkEmptyPropertyType(propertyType);
					
					double areaSize = Helper.readDouble("Enter size (in sq. ft.) > ");
					double budget = Helper.readDouble("Enter budget > ");
					
					String requestDate = Helper.readString("Enter request date > ");
					checkEmptyRequestDate(requestDate);

					String tcDate = Helper.readString("Enter target completion date >");
					checkEmptyTCDate(tcDate);
					checkDates(requestDate, tcDate);
					
					String renovationType = Helper.readString("Enter renovation type > ");
					checkEmptyRenovationType(renovationType);
					
					String renovationStyle = Helper.readString("Enter renovation style > ");
					checkEmptyRenovationStyle(renovationStyle);
					
					boolean urgent = Helper.readBoolean("Complete within 3 months (Yes/No) > ");
					int rooms = Helper.readInt("No. of rooms to renovate > ");
					int toilets = Helper.readInt("No. of toilets to renovate > ");
					
					 QuotationRequest qr = new QuotationRequest(requestorName, email, requestID, propertyType, areaSize, contactNumber, budget, convertDate(tcDate), renovationType, rooms, toilets, renovationStyle, urgent, convertDate(requestDate));

					return qr;

				}
				public static String addQuotationRequest(ArrayList<QuotationRequest> qrList, QuotationRequest qr) {
					qrList.add(qr);
					String output = "New quotation request added!";
					return output;
				}
				
				//================================= Option 3 Delete quotation list =================================
				public static int deleteQuotationRequestInput() {
					String requestID = Helper.readString("Enter request id > ");

					int idFound = -1;
					for (QuotationRequest qr : qrList) {
						if (qr.getRequestID().equals(requestID)) {
							idFound = qrList.indexOf(qr);
						}
				}

					return idFound;
				}

				public static void deleteQuotationRequest(ArrayList<QuotationRequest> qrList, int idFound) {

						if (idFound != -1) {
							qrList.remove(idFound);
							System.out.println("Quotation Request successfully removed");
							
						} else {
							System.out.println("Invalid Input. Quotation Request does not exist");
						}

				}
				
}

	
	
//hello	
	
