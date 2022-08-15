import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;

public class QuotationRequest extends CustomerInfo{
	private String requestID;
	private String propertyType;
	private double areaSize;
	private String contactNumber;
	private double budget;
	private LocalDate tcDate;
	private String renovationType;
	private int rooms;
	private int toilets;
	private String renovationStyle;
	private boolean urgent;
	private LocalDate requestDate;
	
	
	public QuotationRequest(String requestorName, String email, String requestID, String propertyType, double areaSize, String contactNumber, 
			double budget, LocalDate tcDate, String renovationType, int rooms, int toilets, String renovationStyle,
			boolean urgent, LocalDate requestDate) {
		super(requestorName, email);
		this.requestID = requestID;
		this.propertyType = propertyType;
		this.areaSize = areaSize;
		this.contactNumber = contactNumber;
		this.budget = budget;
		this.tcDate = tcDate;
		this.renovationType = renovationType;
		this.rooms = rooms;
		this.toilets = toilets;
		this.renovationStyle = renovationStyle;
		this.urgent = urgent;
		this.requestDate = requestDate;
	}
	
	
	public String getRequestID() {
		return requestID;
	}
	
	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}
	

	public String getPropertyType() {
		return propertyType;
	}


	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}


	public double getAreaSize() {
		return areaSize;
	}


	public void setAreaSize(double areaSize) {
		this.areaSize = areaSize;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public double getBudget() {
		return budget;
	}


	public void setBudget(double budget) {
		this.budget = budget;
	}


	public LocalDate getTcDate() {
		return tcDate;
	}


	public void setTcDate(LocalDate tcDate) {
		this.tcDate = tcDate;
	}


	public String getRenovationType() {
		return renovationType;
	}


	public void setRenovationType(String renovationType) {
		this.renovationType = renovationType;
	}


	public int getRooms() {
		return rooms;
	}


	public void setRooms(int rooms) {
		this.rooms = rooms;
	}


	public int getToilets() {
		return toilets;
	}


	public void setToilets(int toilets) {
		this.toilets = toilets;
	}


	public String getRenovationStyle() {
		return renovationStyle;
	}


	public void setRenovationStyle(String renovationStyle) {
		this.renovationStyle = renovationStyle;
	}


	public boolean getUrgent() {
		return urgent;
	}


	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}
	
	
	public LocalDate getRequestDate() {
		return requestDate;
	}//mk


	public void setRequestDate(LocalDate requestDate) {
		this.requestDate = requestDate;
	}
	
	
	public void urgentCheck(LocalDate tcDate) {
       LocalDate now = LocalDate.now();
       LocalDate after3M = requestDate.plusMonths(3);
//       DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
//       String tcDateString = tcDate.format(formatter);
//       String after3MString = after3M.format(formatter);
//       LocalDate unavailable_date = LocalDate.parse(after3M, formatter);
        
        if ((after3M.isAfter(now) || after3M.isEqual(now)) && after3M.isBefore(tcDate)){    
        	this.urgent = true;
        }
	}
}
//hello
