package so.dvach.pr.faces;

import so.dvach.pr.model.Train;
import so.dvach.pr.store.TrainStore;

public class ViewTrain extends BasePage{

	protected Train train = new Train();
	
	
	
	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public void setTrainId(String id) {
		
		System.out.println("setTrainId "+id);
		if (!isValid(id)) {
			return;
		}
		train = TrainStore.getInstance().getTrain(Integer.valueOf(id));
		System.out.println("train id ="+train.getTrainNum());
	}
	
	public String getTrainId() {		
		return train!=null ? String.valueOf(train.getTrainNum()) : null;
	}
	
	}
