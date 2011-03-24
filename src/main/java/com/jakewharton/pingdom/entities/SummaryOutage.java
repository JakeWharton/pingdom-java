package com.jakewharton.pingdom.entities;

import java.util.Date;
import java.util.List;
import com.jakewharton.pingdom.PingdomEntity;
import com.jakewharton.pingdom.enumerations.StateStatus;

public final class SummaryOutage implements PingdomEntity {
	private static final long serialVersionUID = -6524469170240039400L;

	public static final class State implements PingdomEntity {
		private static final long serialVersionUID = -875880227361545768L;
		
		private StateStatus status;
		private Date timeFrom;
		private Date timeTo;
		
		public StateStatus getStatus() {
			return this.status;
		}
		public Date getTimeFrom() {
			return this.timeFrom;
		}
		public Date getTimeTo() {
			return this.timeTo;
		}
	}
	
	private List<State> states;
	
	public List<State> getStates() {
		return this.states;
	}
}
