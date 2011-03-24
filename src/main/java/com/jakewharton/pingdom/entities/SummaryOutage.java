package com.jakewharton.pingdom.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jakewharton.pingdom.HasValue;
import com.jakewharton.pingdom.PingdomEntity;

public final class SummaryOutage implements PingdomEntity {
	private static final long serialVersionUID = -6524469170240039400L;

	public static final class State implements PingdomEntity {
		private static final long serialVersionUID = -875880227361545768L;
		
		public enum Status implements HasValue {
			Up("up"),
			Down("down"),
			Unknown("unknown");
			
			private final String value;
			
			private Status(String value) {
				this.value = value;
			}

			@Override
			public String value() {
				return this.value;
			}
			
			private static final Map<String, Status> stringToEnum = new HashMap<String, Status>();

			static {
				for (Status status : values()) {
					stringToEnum.put(status.value(), status);
				}
			}
			
			public static Status fromValue(String value) {
				return stringToEnum.get(value);
			}
		}
		
		private Status status;
		private Date timeFrom;
		private Date timeTo;
		
		public Status getStatus() {
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
