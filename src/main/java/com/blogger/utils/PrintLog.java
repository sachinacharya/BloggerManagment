package com.blogger.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.blogger.constants.AppContants;

public class PrintLog {

	private static final Logger logger = LoggerFactory.getLogger(PrintLog.class);

	public static void logInfo(String msg) {
		logger.info(msg);
	}

	public static void logInfo(String name, String msg) {
		logger.info(name + AppContants.DIFFERENCTIATOR + msg);
	}

	public static void logInfo(String className, String methodName, String msg) {
		logger.info(className + AppContants.DIFFERENCTIATOR + methodName + AppContants.DIFFERENCTIATOR + msg);
	}

	public static void logError(String msg) {
		logger.error(msg);
	}

	public static void logError(String name, String msg) {
		logger.error(name + AppContants.DIFFERENCTIATOR + msg);
	}

	public static void logError(String className, String methodName, String msg) {
		logger.error(className + AppContants.DIFFERENCTIATOR + methodName + AppContants.DIFFERENCTIATOR + msg);
	}

}
