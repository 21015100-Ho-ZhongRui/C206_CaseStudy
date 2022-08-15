
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Quotation {

	//Fields
	private String requestID;
	private String quotationID;
	private String category;  // (Kitchen, Living Room, Bedroom, etc)
	private String descriptions;
	private String designerName;
	private String startDate;
	private double quotationAmt;
	
	//Constructor
	public Quotation(String requestID, String quotationID, String category, String descriptions, String designerName,
			String startDate, double quotationAmt) {

		this.requestID = requestID;
		this.quotationID = quotationID;
		this.category = category;
		this.descriptions = descriptions;
		this.designerName = designerName;
		this.startDate = startDate;
		this.quotationAmt = quotationAmt;
	}

	public String getRequestID() {
		return requestID;
	}

	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}

	public String getQuotationID() {
		return quotationID;
	}

	public void setQuotationID(String quotationID) {
		this.quotationID = quotationID;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public String getDesignerName() {
		return designerName;
	}

	public void setDesignerName(String designerName) {
		this.designerName = designerName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public double getQuotationAmt() {
		return quotationAmt;
	}

	public void setQuotationAmt(double quotationAmt) {
		this.quotationAmt = quotationAmt;
	}

	//Getter & Setter
	
	
}
//hello