package so.dvach.pr.faces;

import so.dvach.pr.store.TrainStore;

public class EditTrain extends ViewTrain{

	
public String doDelete() {
	
	if (train.isBlank()) {
		
		addError("Fill first");
		return "";
	}
	TrainStore.getInstance().removeTrain(train.getTrainNum());
	
	return "LIST_TRAINS";

}	
	
public String doSave() {
		
	System.out.println("train id="+train.getTrainNum()+",dest="+train.getDestName());
	
	
		if (train.isBlank()) {
			
			addError("Fill first");
			return "";
		}
		
		
		TrainStore.getInstance().updateTrain(train);
		
		return "LIST_TRAINS";
	}
	

}
