package so.dvach.pr.listener;

import java.util.Calendar;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import so.dvach.pr.model.Train;
import so.dvach.pr.store.TrainStore;

public class StartupListener implements ServletContextListener  {


	public void contextInitialized(ServletContextEvent arg0) {

			Train t = new Train();
			t.setDestName("Хуево-Кукуево");
			
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DAY_OF_MONTH, 1);
			
			t.setStartDT(c.getTime());
			t.setTrainNum(new Integer(666));
		
			TrainStore.getInstance().updateTrain(t);
			
		
	}
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

}
