package com.jakewharton.pingdom.services;

import java.util.List;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.pingdom.PingdomApiBuilder;
import com.jakewharton.pingdom.PingdomApiService;
import com.jakewharton.pingdom.entities.Message;
import com.jakewharton.pingdom.entities.ReportShared;
import com.jakewharton.pingdom.enumerations.SharedReportType;

/**
 * Represents Pingdom's remote shared reports service.
 */
public class ReportsSharedService extends PingdomApiService {
	/**
	 * Returns shared reports (banners).
	 * 
	 * @return Builder instance.
	 * @since 2.0
	 */
	public GetBuilder get() {
		return new GetBuilder(this);
	}
	
	/**
	 * Request builder for {@link ReportsSharedService#get()}.
	 */
	public static final class GetBuilder extends PingdomApiBuilder<List<ReportShared>> {
		private static final String URI = "/reports.shared";
		
		private GetBuilder(ReportsSharedService service) {
			super(service, new TypeToken<List<ReportShared>>() {}, URI);
		}
		
		@Override
		protected JsonElement execute() {
			return super.execute().getAsJsonObject().get("shared");
		}
	}
	
	/**
	 * Create a shared report (banner).
	 * 
	 * @return Builder instance.
	 * @since 2.0
	 */
	public CreateBuilder create() {
		return new CreateBuilder(this);
	}
	
	/**
	 * Request builder for {@link ReportsSharedService#create()}.
	 */
	public static final class CreateBuilder extends PingdomApiBuilder<Message> {
		private static final String POST_SHARED_TYPE = "sharedtype";
		private static final String POST_CHECK_ID = "checkid";
		private static final String POST_AUTO = "auto";
		private static final String POST_FROM_YEAR = "fromyear";
		private static final String POST_FROM_MONTH = "frommonth";
		private static final String POST_FROM_DAY = "fromday";
		private static final String POST_TO_YEAR = "toyear";
		private static final String POST_TO_MONTH = "tomonth";
		private static final String POST_TO_DAY = "today";
		
		private static final String URI = "/reports.shared";
		
		private CreateBuilder(ReportsSharedService service) {
			super(service, new TypeToken<Message>() {}, URI, HttpMethod.Post);
		}
		
		/**
		 * Shared report type.
		 * 
		 * @param sharedType Value.
		 * @return Builder instance.
		 */
		public CreateBuilder sharedType(SharedReportType sharedType) {
			this.postParameter(POST_SHARED_TYPE, sharedType);
			return this;
		}
		
		/**
		 * Identifier of target check.
		 * 
		 * @param checkId Value.
		 * @return Builder instance.
		 */
		public CreateBuilder checkId(int checkId) {
			this.postParameter(POST_CHECK_ID, checkId);
			return this;
		}
		
		/**
		 * <p>Automatic period.</p>
		 * 
		 * <p>If false, requires: fromyear, frommonth, fromday, toyear, tomonth,
		 * today.</p>
		 * 
		 * @param auto Value.
		 * @return Builder instance.
		 */
		public CreateBuilder auto(boolean auto) {
			this.postParameter(POST_AUTO, auto);
			return this;
		}
		
		/**
		 * Period start: year.
		 * 
		 * @param fromYear Value.
		 * @return Builder instance.
		 */
		public CreateBuilder fromYear(int fromYear) {
			this.postParameter(POST_FROM_YEAR, fromYear);
			return this;
		}
		
		/**
		 * Period start: month.
		 * 
		 * @param fromMonth Value.
		 * @return Builder instance.
		 */
		public CreateBuilder fromMonth(int fromMonth) {
			this.postParameter(POST_FROM_MONTH, fromMonth);
			return this;
		}
		
		/**
		 * Period start: day.
		 * 
		 * @param fromDay Value.
		 * @return Builder instance.
		 */
		public CreateBuilder fromDay(int fromDay) {
			this.postParameter(POST_FROM_DAY, fromDay);
			return this;
		}
		
		/**
		 * Period end: year.
		 * 
		 * @param toYear Value.
		 * @return Builder instance.
		 */
		public CreateBuilder toYear(int toYear) {
			this.postParameter(POST_TO_YEAR, toYear);
			return this;
		}
		
		/**
		 * Period end: month.
		 * 
		 * @param toMonth Value.
		 * @return Builder instance.
		 */
		public CreateBuilder toMonth(int toMonth) {
			this.postParameter(POST_TO_MONTH, toMonth);
			return this;
		}
		
		/**
		 * Period end: day.
		 * 
		 * @param toDay Value.
		 * @return Builder instance.
		 */
		public CreateBuilder toDay(int toDay) {
			this.postParameter(POST_TO_DAY, toDay);
			return this;
		}
	}
	
	/**
	 * Delete a shared report (banner).
	 * 
	 * @param reportId Report ID.
	 * @return Builder instance.
	 * @since 2.0
	 */
	public DeleteBuilder delete(int reportId) {
		return new DeleteBuilder(this, reportId);
	}

	/**
	 * Request builder for {@link ReportsSharedService#delete(int)}.
	 */
	public static final class DeleteBuilder extends PingdomApiBuilder<Message> {
		private static final String FIELD_REPORT_ID = "reportid";
		
		private static final String URI = "/reports.shared/{" + FIELD_REPORT_ID + "}";
		
		private DeleteBuilder(ReportsSharedService service, int reportId) {
			super(service, new TypeToken<Message>() {}, URI, HttpMethod.Delete);
			
			this.field(FIELD_REPORT_ID, reportId);
		}
	}
}
