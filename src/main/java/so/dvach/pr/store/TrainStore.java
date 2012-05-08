package so.dvach.pr.store;

import java.util.Collection;

import javolution.util.FastMap;
import so.dvach.pr.model.Train;

public class TrainStore {

	private FastMap store = new FastMap().shared();
	
	public Collection getTrains() {
		return store.values();
	}
	
	public void removeTrain(Integer num) {
		if (!containsTrain(num)) {
			return;
		}
		store.remove(num);
	}
	
	public void updateTrain(Train t) {
		store.put(t.getTrainNum(), t);
	}
	
	public Train getTrain(Integer num) {
		if (!containsTrain(num)) {
			return null;
		}
		return (Train)store.get(num);
	}
	
	public boolean containsTrain(Integer num) {
		return store.containsKey(num);
	}
	
	private static final TrainStore instance = new TrainStore();
	
	public static TrainStore getInstance() {
		return instance;
	}
}
