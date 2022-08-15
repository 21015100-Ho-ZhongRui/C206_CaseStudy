import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private CustomerInfo cm1;
	private CustomerInfo cm2;
	private CustomerInfo cm3;
	
	private Package p1;
	private Package p2;
	private Package p3;
	
	private Quotation q1;
	private Quotation q2;
	private Quotation q3;
	

    private QuotationRequest qr1;
    private QuotationRequest qr2;
    private QuotationRequest qr3;
	
	private ArrayList<Package> packageList;
	private ArrayList<CustomerInfo> cInfo;
	private ArrayList<Quotation> quotationList;
    private ArrayList<QuotationRequest> qrList;
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		cm1 = new CustomerInfo("Chester", "chester@gmail.com", "chester123","Customer","New");
		cm2 = new CustomerInfo("Gloria", "gloria@gmail.com", "gloria123","Customer","New");
		cm3 = new CustomerInfo("Owen","owen@gmail.com","owen123","Customer","New");
		
		p1 = (new Package("P011", "Restrooms", C206_CaseStudy.convertDate("2022-09-09"),C206_CaseStudy.convertDate("2022-11-11"), 5000.00));
		p2 = (new Package("P012", "Kitchen Only", C206_CaseStudy.convertDate("2022-10-10"),C206_CaseStudy.convertDate("2022-12-12"), 7500.00));
		p3 = (new Package("P013", "Whole Place", C206_CaseStudy.convertDate("2022-11-11"),C206_CaseStudy.convertDate("2022-12-30"), 15000.00));
		
		q1 = new Quotation("R011","Q1","Kitchen","Urban style", "Keyon", "2022-12-25", 6300.69);
		q2 = new Quotation("R012","Q2","Bedroom","Urban style", "Keyon", "2022-11-25", 7700.70);
		q3 = new Quotation("R012","Q2","Living Room","Urban style", "Keyon", "2022-10-25", 8500.80);
		
        qr1 = new QuotationRequest("Chester", "chester@gmail.com", "R011", "HDB", 1280, "86543210", 100000, C206_CaseStudy.convertDate("2022-09-10"), "Whole House", 4, 2, "Vintage", true, C206_CaseStudy.convertDate("2022-11-10"));        
        qr2 = new QuotationRequest("Gloria", "gloria@gmail.com", "R012", "Private Property", 1600, "87654321", 10000, C206_CaseStudy.convertDate("2022-09-10"), "Room", 1, 0, "Retro", false, C206_CaseStudy.convertDate("2023-01-10"));
        qr3 = new QuotationRequest("Owen", "owen@gmail.com", "R013", "Landed Property", 2160, "98765432", 1000000, C206_CaseStudy.convertDate("2022-09-10"), "Whole House", 6, 3, "Modern", false, C206_CaseStudy.convertDate("2023-04-10"));
        
        qrList = new ArrayList<QuotationRequest>();
		quotationList = new ArrayList<Quotation>();
		packageList = new ArrayList<Package>();
		cInfo = new ArrayList<CustomerInfo>();
	}
	@Test
	public void testAddCustomer() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid customer arraylist to add to", cInfo);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addCustomerInfo(cInfo, cm1);
		assertEquals("Check that cInfo arraylist size is 1", 1, cInfo.size());
		assertSame("Check that Customerr is added", cm1, cInfo.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		//C206_CaseStudy.addCustomerInfo(cInfo, cm2);
		//assertEquals("Check that cInfo arraylist size is 1", 1, cInfo.size());
		//assertSame("Check that Customer is added", cm2, cInfo.get(0));

	}
	@Test
	public void testRetrieveAllCustomers() {
		//fail("Not yet implemented"); 
		assertNotNull("Test if there is valid customers arraylist to retrieve customer info", cInfo);
		
		
		//test if the list of customers retrieved from C206_CaseStudy is empty - boundary
		String allCustomer = C206_CaseStudy.retrieveAllCustomers(cInfo);
		String testOutput = "";
		assertEquals("Check that ViewAllCustomers",testOutput,allCustomer);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addCustomerInfo(cInfo, cm1);
		C206_CaseStudy.addCustomerInfo(cInfo, cm2);
		assertEquals("Test that Customer arraylist size is 2", 2, cInfo.size());
				
		//test if the expected output string same as the list of customers retrieved from the C206_CaseStudy
		allCustomer= C206_CaseStudy.retrieveAllCustomers(cInfo);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","Chester", "chester@gmail.com", "chester123","Customer","New");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","Gloria", "gloria@gmail.com", "gloria123","Customer","New");
			
		assertEquals("Test that ViewAllcInfo", testOutput, allCustomer);
	}
	@Test
	public void testDeleteCustomer() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Customer arraylist to delete package from", cInfo);
		
		//test if the list of customer retrieved from the C206_CaseStudy is empty - boundary
		String allCustomers= C206_CaseStudy.retrieveAllCustomers(cInfo);
		String testOutput = "";
		assertEquals("Check that ViewAllCustomers", testOutput, allCustomers);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addCustomerInfo(cInfo, cm1);
		C206_CaseStudy.addCustomerInfo(cInfo, cm2);
		
		assertEquals("Test that Customer arraylist size is 2", 2, cInfo.size());
		
		//Given that there are now 2 items in the list, delete one of the items and test if the size is 1
		C206_CaseStudy.removeMember(cInfo, 0);
		
		assertEquals("Test that Customer arraylist size is 1", 1, cInfo.size());
		
		//test if the expected output string same as the list of Customers retrieved from the C206_CaseStudy	
		allCustomers= C206_CaseStudy.retrieveAllCustomers(cInfo);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","Gloria", "gloria@gmail.com", "gloria123","Customer","New");
	
		assertEquals("Test that ViewAllMembers is the equal to output", testOutput, allCustomers);
		// Test
	}
	@Test
	public void testAddPackage() {
		//fail("Not yet implemented"); 
		// Package list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Package arraylist to add to", packageList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		C206_CaseStudy.addPackage(packageList, p1);
		assertEquals("Check that Package arraylist size is 1", 1, packageList.size());
		//The item just added is as same as the first item of the list
		assertSame("Check that Package is added", p1, packageList.get(0));
	}
	@Test
	public void testRetrieveAllPackage() {
		// Test if Item list is not null but empty -boundary
				assertNotNull("Test if there is valid package arraylist to retrieve Package", packageList);
				
				//test if the list of package retrieved from the C206_CaseStudy is empty - boundary
				String allPackage= C206_CaseStudy.retrieveAllPackage(packageList);
				String testOutput = "";
				assertEquals("Check the ViewAllPackage", testOutput, allPackage);
				
				//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
				C206_CaseStudy.addPackage(packageList, p1);
				C206_CaseStudy.addPackage(packageList, p2);
				
				assertEquals("Test that Package arraylist size is 2", 2, packageList.size());
				
				//test if the expected output string same as the list of packages retrieved from the C206_CaseStudy	
				allPackage= C206_CaseStudy.retrieveAllPackage(packageList);
				testOutput = String.format("%-20s %-20s %-20s %-20s %-20s\n","P011", "Restrooms", 
						C206_CaseStudy.convertDate("2022-09-09"),C206_CaseStudy.convertDate("2022-11-11"), 5000.00);
				testOutput += String.format("%-20s %-20s %-20s %-20s %-20s\n","P012", "Kitchen Only", 
						C206_CaseStudy.convertDate("2022-10-10"),C206_CaseStudy.convertDate("2022-12-12"), 7500.00);
			
				assertEquals("Test that ViewAllPackage is the equal to output", testOutput, allPackage);
				// Test
	}
	@Test
	public void testDeletePackage() {
		// Test if Item list is not null but empty -boundary
				assertNotNull("Test if there is valid Package arraylist to delete package from", packageList);
				
				//test if the list of package retrieved from the C206_CaseStudy is empty - boundary
				String allPackage= C206_CaseStudy.retrieveAllPackage(packageList);
				String testOutput = "";
				assertEquals("Check that ViewAllPackagelist", testOutput, allPackage);
				
				//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
				C206_CaseStudy.addPackage(packageList, p1);
				C206_CaseStudy.addPackage(packageList, p2);
				
				assertEquals("Test that Package arraylist size is 2", 2, packageList.size());
				
				//Given that there are now 2 items in the list, delete one of the items and test if the size is 1
				C206_CaseStudy.deletePackage(packageList, 0);
				
				assertEquals("Test that Package arraylist size is 1", 1, packageList.size());
				
				//test if the expected output string same as the list of packages retrieved from the C206_CaseStudy	
				allPackage= C206_CaseStudy.retrieveAllPackage(packageList);
				testOutput += String.format("%-20s %-20s %-20s %-20s %-20s\n","P012", "Kitchen Only", C206_CaseStudy.convertDate("2022-10-10"),
						C206_CaseStudy.convertDate("2022-12-12"), 7500.00);
			
				assertEquals("Test that ViewAllPackage is the equal to output", testOutput, allPackage);
				// Test
	}
	@Test
	public void testAddQuotation() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Quotation arraylist to add to", quotationList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addQuotation(quotationList, q1);		
		assertEquals("Test if that Quotation arraylist size is 1?", 1, quotationList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Quotation added is same as 1st item of the list?", q1, quotationList.get(0));
		
		//Add another item. test The size of the list is 2?
		C206_CaseStudy.addQuotation(quotationList, q2);
		C206_CaseStudy.addQuotation(quotationList, q3);
		assertEquals("Test that quotation arraylist size is 3?", 3, quotationList.size());
		assertSame("Test that quotation is added same as 3rd item of the list?", q3, quotationList.get(2));
	}
	
	
	@Test
	public void testRetrieveAllQuotation() {
		//fail("Not yet implemented");
		// write your code here
		assertNotNull("Test if there is valid quotation arraylist to add to", quotationList);
		
		//test if the list of quotation retrieved from the SourceCentre is empty
		String allQuotation= C206_CaseStudy.retrieveAllQuotation(quotationList);
		String testOutput = "";
		assertEquals("Check that ViewAllQUotation list", testOutput, allQuotation);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addQuotation(quotationList, q1);
		C206_CaseStudy.addQuotation(quotationList, q2);
		assertEquals("Test if that Quotation arraylist size is 2?", 2, quotationList.size());
		
		//test if the expected output string same as the list of quotation retrieved from the SourceCentre
		allQuotation= C206_CaseStudy.retrieveAllQuotation(quotationList);

		testOutput += String.format("%-15s %-15s %-20s %-30s %-20s %-20s $%-20.2f\n", "R011","Q1","Kitchen","Urban style", "Keyon", "2022-12-25", 6300.69) ;
		testOutput += String.format("%-15s %-15s %-20s %-30s %-20s %-20s $%-20.2f\n", "R012","Q2","Bedroom","Urban style", "Keyon", "2022-11-25", 7700.70);
		assertEquals("Check that ViewAllQUotation list", testOutput, allQuotation);
		
	}
	
	@Test
	public void testDeleteQuotation() {
		//fail("Not yet implemented");
		// write your code here
		assertNotNull("test if there is valid quotation arraylist to loan from",quotationList);		
		
		//test if the list of package retrieved from the C206_CaseStudy is empty - boundary
		String allQuotation= C206_CaseStudy.retrieveAllQuotation(quotationList);
		String testOutput = "";
		assertEquals("Check that ViewAllQuotationlist", testOutput, allQuotation);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addQuotation(quotationList, q1);
		C206_CaseStudy.addQuotation(quotationList, q2);
		
		assertEquals("Test that Quotation arraylist size is 2", 2, quotationList.size());
		
		//Given that there are now 2 items in the list, delete one of the items and test if the size is 1
		C206_CaseStudy.removeQuotation(quotationList, 0);
		
		//assertEquals("Test that Quotation arraylist size is 1", 1, quotationList.size());
		
		//test if the expected output string same as the list of quotation retrieved from the C206_CaseStudy	
		allQuotation = C206_CaseStudy.retrieveAllQuotation(quotationList);
		testOutput += String.format("%-15s %-15s %-20s %-30s %-20s %-20s $%-20.2f\n", "R012","Q2","Bedroom","Urban style", "Keyon", "2022-11-25", 7700.70);
	
		assertEquals("Test that ViewAllQuotation is the equal to output", testOutput, allQuotation);
		// Test
	}
	
	 @Test
	    public void testAddQuotationRequest() {
	        // Item list is not null, so that can add a new item - boundary
	        assertNotNull("Check if there is valid Quotation Request arraylist to add to", qrList);

	        //Given an empty list, after adding 1 item, the size of the list is 1 - normal
	        //The item just added is as same as the first item of the list
	        C206_CaseStudy.addQuotationRequest(qrList, qr1);
	        assertEquals("Check that Quotation Request arraylist size is 1", 1, qrList.size());        

	        //Add another item. test The size of the list is 2? -normal
	        C206_CaseStudy.addQuotationRequest(qrList, qr2);
	        C206_CaseStudy.addQuotationRequest(qrList, qr3);

	        assertEquals("Check that Quotation Request arraylist size is 3", 3, qrList.size());
	        assertSame("Check that Quotation Request is added", qr3, qrList.get(2));
	    }

		
	    @Test
	    public void testRetrieveAllQuotationRequest() {
	        //fail("Not yet implemented");
	        // write your code here
	        assertNotNull("Test if there is valid quotation request arraylist to add to", qrList);

	        //test if the list of quotation request retrieved from the C206_CaseStudy is empty
	        String allQR= C206_CaseStudy.retrieveAllQuotationRequest(qrList);
	        String testOutput = "";
	        assertEquals("Check that ViewAllQUotationRequest list", testOutput, allQR);

	        //Given an empty list, after adding 2 items, test if the size of the list is 2
	        C206_CaseStudy.addQuotationRequest(qrList, qr1);
	        C206_CaseStudy.addQuotationRequest(qrList, qr2);

	        assertEquals("Test if that Quotation arraylist size is 2?", 2, qrList.size());

	        //test if the expected output string same as the list of quotation retrieved from the C206_CaseStudy
	        allQR= C206_CaseStudy.retrieveAllQuotationRequest(qrList);

	        testOutput += String.format("%-30s %-30s %-30s %-30s %-30s %-30.2f %-30.2f %-30s %-30s %-30s %-30s %-30b %-30d %-30d\n", 
	        		"R011", "Chester", "86543210", "chester@gmail.com",  "HDB", 1280.00, 100000.00, C206_CaseStudy.convertDate("2022-09-10"),
	        		 C206_CaseStudy.convertDate("2022-11-10"), "Whole House", "Vintage", true, 4, 2);
	        testOutput += String.format("%-30s %-30s %-30s %-30s %-30s %-30.2f %-30.2f %-30s %-30s %-30s %-30s %-30b %-30d %-30d\n",
	                 "R012", "Gloria" ,"87654321", "gloria@gmail.com", "Private Property", 1600.00, 10000.00, C206_CaseStudy.convertDate("2022-09-10"),
	                  C206_CaseStudy.convertDate("2023-01-10"), "Room", "Retro",false, 1, 0);	  

	        assertEquals("Check that ViewAllQuotationRequest list", testOutput, allQR);

	    }
	    
	    @Test
		public void testDeleteQuotationRequest() {
			// Test if Item list is not null but empty -boundary
					assertNotNull("Test if there is valid Quotation Request arraylist to delete Quotation Request from", qrList);
					
					//test if the list of package retrieved from the C206_CaseStudy is empty - boundary
					String allQR= C206_CaseStudy.retrieveAllQuotationRequest(qrList);
					String testOutput = "";
					assertEquals("Check that ViewAllQRlist", testOutput, allQR);
					
					//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
					C206_CaseStudy.addQuotationRequest(qrList, qr1);
					C206_CaseStudy.addQuotationRequest(qrList, qr2);
					
					assertEquals("Test that Quotation Request arraylist size is 2", 2, qrList.size());
					
					//Given that there are now 2 items in the list, delete one of the items and test if the size is 1
					C206_CaseStudy.deleteQuotationRequest(qrList, 0);
					
					assertEquals("Test that QR arraylist size is 1", 1, qrList.size());
					
					//test if the expected output string same as the list of QR retrieved from the C206_CaseStudy	
					allQR= C206_CaseStudy.retrieveAllQuotationRequest(qrList);
					testOutput += String.format("%-30s %-30s %-30s %-30s %-30s %-30.2f %-30.2f %-30s %-30s %-30s %-30s %-30b %-30d %-30d\n",
			                 "R012", "Gloria" ,"87654321", "gloria@gmail.com", "Private Property", 1600.00, 10000.00, C206_CaseStudy.convertDate("2022-09-10"),
			                  C206_CaseStudy.convertDate("2023-01-10"), "Room", "Retro",false, 1, 0);
				
					assertEquals("Test that ViewAllPackage is the equal to output", testOutput, allQR);
					// Test
		}
	
	
	@After
	public void tearDown() throws Exception {
		cm1 = null;
		cm2 = null;
		
		p1 = null;
		p2 = null;
		
		q1 = null;
		q2 = null;
		q3 = null;
		
        qr1 = null;
        qr2 = null;
        qr3 = null;
        
        
        qrList = null;
		packageList = null;
		cInfo = null;
		quotationList = null;
	}

}
