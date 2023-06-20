package google.GenericUtility;

import org.apache.log4j.Logger;

public final class LogUtilities {

	Logger log=Logger.getLogger( LogUtilities .class);
	public void message(String messgae)
	{
		log.info(messgae);
	}
}
