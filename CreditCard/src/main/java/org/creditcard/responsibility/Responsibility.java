package org.creditcard.responsibility;

import org.creditcard.handlers.AmExCCHandler;
import org.creditcard.handlers.DefaultHandler;
import org.creditcard.handlers.DiscoverCCHandler;
import org.creditcard.handlers.Handler;
import org.creditcard.handlers.MasterCCHandler;
import org.creditcard.handlers.VisaCCHandler;

public class Responsibility {
	public static Handler setResponsibility() {
		return new MasterCCHandler(new VisaCCHandler(new AmExCCHandler(new DiscoverCCHandler(new DefaultHandler(null)))));
	}
}
