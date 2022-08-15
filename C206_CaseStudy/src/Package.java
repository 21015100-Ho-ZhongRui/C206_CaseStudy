import java.time.LocalDate;


public class Package {
	
	private String code;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	private double amount;
		
	public Package(String code, String description, LocalDate startDate, LocalDate endDate, double amount) {
		this.code = code;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
	
}
