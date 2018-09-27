package de.wennersonline.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import de.wennersonline.jms.Receiver;
import de.wennersonline.jms.Sender;

@Configuration
@Component
public class ScheduledTasks {

	@Autowired
	private Receiver receiver;

	@Autowired
	private Sender sender;

	@Scheduled(fixedRateString = "${scheduledTasks.send-task-fixedRate}")
	public void outputTask() {
		sender.send();

	}
	
	@Scheduled(fixedRateString = "${scheduledTasks.recieve-task-fixedRate}")
	public void inputTask() {
		receiver.recieve();
	}

}
