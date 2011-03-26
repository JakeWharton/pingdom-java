package com.jakewharton.pingdom;

import java.util.Date;
import com.google.gson.Gson;
import com.jakewharton.pingdom.entities.Check.CheckTypeWrapper;
import com.jakewharton.pingdom.entities.SummaryAverage.ResponseTime.AvgResponseWrapper;
import com.jakewharton.pingdom.enumerations.AlertStatus;
import com.jakewharton.pingdom.enumerations.AlertVia;
import com.jakewharton.pingdom.enumerations.BannerType;
import com.jakewharton.pingdom.enumerations.CheckStatus;
import com.jakewharton.pingdom.enumerations.CheckType;
import com.jakewharton.pingdom.enumerations.PerformanceResolution;
import com.jakewharton.pingdom.enumerations.PublicReportMonths;
import com.jakewharton.pingdom.enumerations.ReportFrequency;
import com.jakewharton.pingdom.enumerations.SharedReportType;
import com.jakewharton.pingdom.enumerations.SmsProvider;
import com.jakewharton.pingdom.enumerations.StateStatus;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestPingdomApiService extends TestCase {
	private Gson gson;

	@Override
	protected void setUp() throws Exception {
		this.gson = PingdomApiService.getGsonBuilder().create();
	}
	
	/**
	 * Test deserialization of the {@link Date} type.
	 */
	public void testDateDeserialization() {
		Date date1 = this.gson.fromJson("0", Date.class);
		Assert.assertNotNull(date1);
		Assert.assertEquals(date1.getTime() / 1000, 0);
		
		Date date2expected = new Date();
		Date date2received = this.gson.fromJson(Long.toString(date2expected.getTime() / 1000), Date.class);
		Assert.assertNotNull(date2received);
		Assert.assertEquals(date2expected.getTime() / 1000, date2received.getTime() / 1000);
	}
	
	/**
	 * Test deserialization of {@link CheckTypeWrapper} in its simple form.
	 */
	public void testCheckTypeWrapperSimpleDeserialization() {
		String simple = "\"dns\"";
		CheckTypeWrapper simpleWrapper = this.gson.fromJson(simple, CheckTypeWrapper.class);
		Assert.assertNotNull(simpleWrapper);
		Assert.assertEquals(CheckType.Dns, simpleWrapper.getNative());
	}
	
	/**
	 * Test deserialization of {@link CheckTypeWrapper} in its complex form.
	 */
	public void testCheckTypeWrapperComplexDeserialization() {
		String complex = "{\"dns\": {\"nameserver\": \"ns1.example.com\", \"expectedip\": \"123.456.78.90\"}}";
		CheckTypeWrapper complexWrapper = this.gson.fromJson(complex, CheckTypeWrapper.class);
		Assert.assertNotNull(complexWrapper);
		Assert.assertEquals(CheckType.Dns, complexWrapper.getNative());
		Assert.assertEquals("ns1.example.com", complexWrapper.asDns().getNameServer());
		Assert.assertEquals("123.456.78.90", complexWrapper.asDns().getExpectedIp());
	}
	
	/**
	 * Test deserialization of {@link AvgResponseWrapper} in its simple form.
	 */
	public void testAverageResponseWrapperSimpleDeserialization() {
		String simple = "123";
		AvgResponseWrapper simpleWrapper = this.gson.fromJson(simple, AvgResponseWrapper.class);
		Assert.assertNotNull(simpleWrapper);
		Assert.assertNull(simpleWrapper.getList());
		Assert.assertNotNull(simpleWrapper.getSingle());
		Assert.assertEquals(123, simpleWrapper.getSingle().intValue());
	}
	
	/**
	 * Test deserialization of {@link AvgResponseWrapper} in its complex form.
	 */
	public void testAverageResponseWrapperComplexDeserialization() {
		String complex = "[{\"avgresponse\": 123, \"probeid\": 45}, {\"avgresponse\": 678, \"probeid\": 90, \"countryiso\": \"us\"}]";
		AvgResponseWrapper complexWrapper = this.gson.fromJson(complex, AvgResponseWrapper.class);
		Assert.assertNotNull(complexWrapper);
		Assert.assertNull(complexWrapper.getSingle());
		Assert.assertNotNull(complexWrapper.getList());
		Assert.assertEquals(2, complexWrapper.getList().size());
		Assert.assertNotNull(complexWrapper.getList().get(0).getAvgResponse());
		Assert.assertEquals(123, complexWrapper.getList().get(0).getAvgResponse().intValue());
		Assert.assertNotNull(complexWrapper.getList().get(0).getProbeId());
		Assert.assertEquals(45, complexWrapper.getList().get(0).getProbeId().intValue());
		Assert.assertNull(complexWrapper.getList().get(0).getCountryIso());
		Assert.assertNotNull(complexWrapper.getList().get(1).getAvgResponse());
		Assert.assertEquals(678, complexWrapper.getList().get(1).getAvgResponse().intValue());
		Assert.assertNotNull(complexWrapper.getList().get(1).getProbeId());
		Assert.assertEquals(90, complexWrapper.getList().get(1).getProbeId().intValue());
		Assert.assertEquals("us", complexWrapper.getList().get(1).getCountryIso());
	}
	
	/**
	 * Test deserialization of enumeration types.
	 */
	public void testEnumerationDeserialization() {
		AlertStatus alertStatus1 = AlertStatus.Delivered;
		AlertVia alertVia1 = AlertVia.Email;
		BannerType bannerType1 = BannerType.Response;
		CheckStatus checkStatus1 = CheckStatus.Down;
		CheckType checkType1 = CheckType.Dns;
		PerformanceResolution performanceResolution1 = PerformanceResolution.Day;
		PublicReportMonths publicReportMonths1 = PublicReportMonths.All;
		ReportFrequency reportFrequency1 = ReportFrequency.Daily;
		SharedReportType sharedReportType1 = SharedReportType.Banner;
		SmsProvider smsProvider1 = SmsProvider.BulkSms;
		StateStatus stateStatus1 = StateStatus.Down;
		
		AlertStatus alertStatus2 = this.gson.fromJson("\"" + alertStatus1 + "\"", AlertStatus.class);
		AlertVia alertVia2 = this.gson.fromJson("\"" + alertVia1 + "\"", AlertVia.class);
		BannerType bannerType2 = this.gson.fromJson("\"" + bannerType1 + "\"", BannerType.class);
		CheckStatus checkStatus2 = this.gson.fromJson("\"" + checkStatus1 + "\"", CheckStatus.class);
		CheckType checkType2 = this.gson.fromJson("\"" + checkType1 + "\"", CheckType.class);
		PerformanceResolution performanceResolution2 = this.gson.fromJson("\"" + performanceResolution1 + "\"", PerformanceResolution.class);
		PublicReportMonths publicReportMonths2 = this.gson.fromJson("\"" + publicReportMonths1 + "\"", PublicReportMonths.class);
		ReportFrequency reportFrequency2 = this.gson.fromJson("\"" + reportFrequency1 + "\"", ReportFrequency.class);
		SharedReportType sharedReportType2 = this.gson.fromJson("\"" + sharedReportType1 + "\"", SharedReportType.class);
		SmsProvider smsProvider2 = this.gson.fromJson("\"" + smsProvider1 + "\"", SmsProvider.class);
		StateStatus stateStatus2 = this.gson.fromJson("\"" + stateStatus1 + "\"", StateStatus.class);
		
		Assert.assertEquals(alertStatus1, alertStatus2);
		Assert.assertEquals(alertVia1, alertVia2);
		Assert.assertEquals(bannerType1, bannerType2);
		Assert.assertEquals(checkStatus1, checkStatus2);
		Assert.assertEquals(checkType1, checkType2);
		Assert.assertEquals(performanceResolution1, performanceResolution2);
		Assert.assertEquals(publicReportMonths1, publicReportMonths2);
		Assert.assertEquals(reportFrequency1, reportFrequency2);
		Assert.assertEquals(sharedReportType1, sharedReportType2);
		Assert.assertEquals(smsProvider1, smsProvider2);
		Assert.assertEquals(stateStatus1, stateStatus2);
	}
}
