package SBV_utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {

	private static Logger log=LogManager.getLogger(Logs.class.getClass());
	public static void startTestCase(String TestCaseName) {
		log.info("**********************************************************************************************");
		log.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+TestCaseName+"      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		log.info("***********************************************************************************************");
		
	}
	
	public static void endTestCase() {
		log.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+"---END---"+"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		log.info("    ");
	}
	
	public static void info(String message) {
		log.info(message);
	}

	public static void warn(String message) {
		log.info(message);
	}

	public static void error(String message) {
		log.info(message);
	}
	public static void fatal(String message) {
		log.info(message);
	}
	public static void debug(String message) {
		log.info(message);
	}
}
