package thms.model;
import java.util.Date;

public class Country {
	
	
	private Date startdate;
	private Date enddate;
	private int differenceInDays;
	
	public Country() {}
	
	public Country( Date startdate, Date enddate, int differenceInDays) {
		
		this.startdate = startdate;
		this.enddate = enddate;
		this.differenceInDays = differenceInDays;
	}
	
	
	public Date getStartDate() {
		return startdate;
	}
	public void setStartDate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEndDate() {
		return enddate;
	}
	public void setEndDate(Date enddate) {
		this.enddate = enddate;
	}

	public int getDifferenceInDays() {
		return differenceInDays;
	}

	public void setDifferenceInDays(int differenceInDays) {
		this.differenceInDays = differenceInDays;
	}

}
