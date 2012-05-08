package so.dvach.pr.faces;

import java.util.Collection;

import so.dvach.pr.store.TrainStore;

public class ListTrains extends BasePage{

	public Collection getTrains() {
		return TrainStore.getInstance().getTrains();
	}
}
