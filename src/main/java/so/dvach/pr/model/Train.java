package so.dvach.pr.model;

import java.util.Date;

public class Train {

	private String destName;
	
	private Integer trainNum;
	
	private Date startDT;

	public boolean isBlank() {
		return trainNum==null;
	}
	
	public String getDestName() {
		return destName;
	}

	public void setDestName(String destName) {
		this.destName = destName;
	}

	public Integer getTrainNum() {
		return trainNum;
	}

	public void setTrainNum(Integer trainNum) {
		this.trainNum = trainNum;
	}

	public Date getStartDT() {
		return startDT;
	}

	public void setStartDT(Date startDT) {
		this.startDT = startDT;
	}
	
	
	
}
