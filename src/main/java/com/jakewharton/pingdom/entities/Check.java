package com.jakewharton.pingdom.entities;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;
import com.jakewharton.pingdom.enumerations.CheckStatus;
import com.jakewharton.pingdom.enumerations.CheckType;

/**
 * Represents a Pingdom check object.
 */
public final class Check implements PingdomEntity {
	private static final long serialVersionUID = 6610462680859684444L;
	
	/**
	 * Wrapper for {@link CheckType} which allows for deserializing either the
	 * simple string type or a more complex object representation of the type
	 * with a single class.
	 * 
	 * @author Jake Wharton <jakewharton@gmail.com>
	 */
	public static final class CheckTypeWrapper {
		private static final long serialVersionUID = -3920151255560101200L;
		
		public CheckTypeWrapper(CheckType typeNative, CheckTypeBase typeObject) {
			this.typeNative = typeNative;
			this.typeObject = typeObject;
		}
		
		private final CheckType typeNative;
		private final CheckTypeBase typeObject;
		
		/**
		 * Get native type enum value.
		 * 
		 * @return Value.
		 */
		public CheckType getNative() {
			return this.typeNative;
		}
		
		/**
		 * <p>Get type object representation.</p>
		 * 
		 * <p>This is a general inflation target which contains all possible
		 * values for all types. You should call {@link #getNative()} in your
		 * code and then the corresponding <code>asXXX()</code> method.</p>
		 * 
		 * @return Type object.
		 */
		public CheckTypeBase getTypeObject() {
			return this.typeObject;
		}
		
		
		/**
		 * Wrap type object as an {@link HttpType}.
		 * 
		 * @return Wrapped type.
		 */
		public HttpType asHttp() {
			return new HttpType(this.typeObject);
		}
		
		/**
		 * Wrap type object as an {@link HttpCustomType}.
		 * 
		 * @return Wrapped type.
		 */
		public HttpCustomType asHttpCustom() {
			return new HttpCustomType(this.typeObject);
		}
		
		/**
		 * Wrap type object as an {@link TcpType}.
		 * 
		 * @return Wrapped type.
		 */
		public TcpType asTcp() {
			return new TcpType(this.typeObject);
		}
		
		/**
		 * Wrap type object as an {@link PingType}.
		 * 
		 * @return Wrapped type.
		 */
		public PingType asPing() {
			return new PingType(this.typeObject);
		}
		
		/**
		 * Wrap type object as an {@link DnsType}.
		 * 
		 * @return Wrapped type.
		 */
		public DnsType asDns() {
			return new DnsType(this.typeObject);
		}
		
		/**
		 * Wrap type object as an {@link UdpType}.
		 * 
		 * @return Wrapped type.
		 */
		public UdpType asUdp() {
			return new UdpType(this.typeObject);
		}
		
		/**
		 * Wrap type object as an {@link SmtpType}.
		 * 
		 * @return Wrapped type.
		 */
		public SmtpType asSmtp() {
			return new SmtpType(this.typeObject);
		}
		
		/**
		 * Wrap type object as an {@link Pop3Type}.
		 * 
		 * @return Wrapped type.
		 */
		public Pop3Type asPop3() {
			return new Pop3Type(this.typeObject);
		}
		
		/**
		 * Wrap type object as an {@link ImapType}.
		 * 
		 * @return Wrapped type.
		 */
		public ImapType asImap() {
			return new ImapType(this.typeObject);
		}
	}
	
	/**
	 * <p>An encompassing base class which allows for the deserialization of
	 * all complex check-type objects to a single native object.</p>
	 * 
	 * @author Jake Wharton <jakewharton@gmail.com>
	 */
	public static final class CheckTypeBase implements PingdomEntity {
		private static final long serialVersionUID = 1813724658931962637L;
		
		@Since(2.0) private String url;
		@Since(2.0) private Boolean encryption;
		@Since(2.0) private Integer port;
		@Since(2.0) private String username;
		@Since(2.0) private String password;
		@Since(2.0) private String shouldContain;
		@Since(2.0) private String shouldNotContain;
		@Since(2.0) private String postData;
		@Since(2.0) private Map<String, String> requestHeaders;
		@Since(2.0) private List<String> additionalUrls;
		@Since(2.0) private String stringToSend;
		@Since(2.0) private String stringToExpect;
		@Since(2.0) private String nameServer;
		@Since(2.0) private String expectedIp;
		
		/*package*/ String getUrl() {
			return this.url;
		}
		/*package*/ Boolean getEncryption() {
			return this.encryption;
		}
		/*package*/ Integer getPort() {
			return this.port;
		}
		/*package*/ String getUsername() {
			return this.username;
		}
		/*package*/ String getPassword() {
			return this.password;
		}
		/*package*/ String getShouldContain() {
			return this.shouldContain;
		}
		/*package*/ String getShouldNotContain() {
			return this.shouldNotContain;
		}
		/*package*/ String getPostData() {
			return this.postData;
		}
		/*package*/ Map<String, String> getRequestHeaders() {
			return this.requestHeaders;
		}
		/*package*/ List<String> getAdditionalUrls() {
			return this.additionalUrls;
		}
		/*package*/ String getStringToSend() {
			return this.stringToSend;
		}
		/*package*/ String getStringToExpect() {
			return this.stringToExpect;
		}
		/*package*/ String getNameServer() {
			return this.nameServer;
		}
		/*package*/ String getExpectedIp() {
			return this.expectedIp;
		}
	}
	
	/**
	 * {@link CheckTypeBase} wrapper which only exposes methods appropriate for
	 * an HTTP check type.
	 * 
	 * @author Jake Wharton <jakewharton@gmail.com>
	 */
	public static final class HttpType {
		private final CheckTypeBase base;
		
		private HttpType(CheckTypeBase base) {
			this.base = base;
		}
		
		/**
		 * Path to target on server.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getUrl() {
			return this.base.getUrl();
		}
		
		/**
		 * Connection encryption.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Boolean getEncryption() {
			return this.base.getEncryption();
		}
		
		/**
		 * Target port.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getPort() {
			return this.base.getPort();
		}
		
		/**
		 * Username for target HTTP authentication.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getUsername() {
			return this.base.getUsername();
		}
		
		/**
		 * Password for target HTTP authentication.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getPassword() {
			return this.base.getPassword();
		}
		
		/**
		 * Target site should contain this string.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getShouldContain() {
			return this.base.getShouldContain();
		}
		
		/**
		 * Target site should NOT contain this string.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getShouldNotContain() {
			return this.base.getShouldNotContain();
		}
		
		/**
		 * Data that should be posted to the web page, for example submission
		 * data for a sign-up or login form. The data needs to be formatted in
		 * the same way as a web browser would send it to the web server.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getPostData() {
			return this.base.getPostData();
		}
		
		/**
		 * Custom HTTP headers. Entry name should match header name.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Map<String, String> getRequestHeaders() {
			return this.base.getRequestHeaders();
		}
	}

	/**
	 * {@link CheckTypeBase} wrapper which only exposes methods appropriate for
	 * an HTTP custom check type.
	 * 
	 * @author Jake Wharton <jakewharton@gmail.com>
	 */
	public static final class HttpCustomType {
		private final CheckTypeBase base;
		
		private HttpCustomType(CheckTypeBase base) {
			this.base = base;
		}

		/**
		 * Path to target XML file on server.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getUrl() {
			return this.base.getUrl();
		}
		
		/**
		 * Connection encryption.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Boolean getEncryption() {
			return this.base.getEncryption();
		}
		
		/**
		 * Target port.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getPort() {
			return this.base.getPort();
		}
		
		/**
		 * Username for target HTTP authentication.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getUsername() {
			return this.base.getUsername();
		}
		
		/**
		 * Password for target HTTP authentication.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getPassword() {
			return this.base.getPassword();
		}
		
		/**
		 * Full URL (including hostname) to target additional XML file.
		 * 
		 * @return List of values.
		 * @since 2.0
		 */
		public List<String> getAdditionalUrls() {
			return this.base.getAdditionalUrls();
		}
	}

	/**
	 * {@link CheckTypeBase} wrapper which only exposes methods appropriate for
	 * a TCP check type.
	 * 
	 * @author Jake Wharton <jakewharton@gmail.com>
	 */
	public static final class TcpType {
		private final CheckTypeBase base;
		
		private TcpType(CheckTypeBase base) {
			this.base = base;
		}
		
		/**
		 * Target port.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getPort() {
			return this.base.getPort();
		}
		
		/**
		 * String to send.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getStringToSend() {
			return this.base.getStringToSend();
		}
		
		/**
		 * String to expect in response.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getStringToExpect() {
			return this.base.getStringToExpect();
		}
	}

	/**
	 * {@link CheckTypeBase} wrapper which only exposes methods appropriate for
	 * a ping check type.
	 * 
	 * @author Jake Wharton <jakewharton@gmail.com>
	 */
	public static final class PingType {
		@SuppressWarnings("unused")
		private final CheckTypeBase base;
		
		private PingType(CheckTypeBase base) {
			this.base = base;
		}
	}

	/**
	 * {@link CheckTypeBase} wrapper which only exposes methods appropriate for
	 * a DNS check type.
	 * 
	 * @author Jake Wharton <jakewharton@gmail.com>
	 */
	public static final class DnsType {
		private final CheckTypeBase base;
		
		private DnsType(CheckTypeBase base) {
			this.base = base;
		}
		
		/**
		 * DNS server to use.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getNameServer() {
			return this.base.getNameServer();
		}
		
		/**
		 * Expected IP.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getExpectedIp() {
			return this.base.getExpectedIp();
		}
	}

	/**
	 * {@link CheckTypeBase} wrapper which only exposes methods appropriate for
	 * a UDP check type.
	 * 
	 * @author Jake Wharton <jakewharton@gmail.com>
	 */
	public static final class UdpType {
		private final CheckTypeBase base;
		
		private UdpType(CheckTypeBase base) {
			this.base = base;
		}
		
		/**
		 * Target port.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getPort() {
			return this.base.getPort();
		}
		
		/**
		 * String to send.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getStringToSend() {
			return this.base.getStringToSend();
		}
		
		/**
		 * String to expect in response.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getStringToExpect() {
			return this.base.getStringToExpect();
		}
	}

	/**
	 * {@link CheckTypeBase} wrapper which only exposes methods appropriate for
	 * an SMTP check type.
	 * 
	 * @author Jake Wharton <jakewharton@gmail.com>
	 */
	public static final class SmtpType {
		private final CheckTypeBase base;
		
		private SmtpType(CheckTypeBase base) {
			this.base = base;
		}
		
		/**
		 * Target port.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getPort() {
			return this.base.getPort();
		}
		
		/**
		 * Username for target SMTP authentication.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getUsername() {
			return this.base.getUsername();
		}
		
		/**
		 * Password for target SMTP authentication.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getPassword() {
			return this.base.getPassword();
		}
		
		/**
		 * Connection encryption.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Boolean getEncryption() {
			return this.base.getEncryption();
		}
		
		/**
		 * String to expect in response.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getStringToExpect() {
			return this.base.getStringToExpect();
		}
	}

	/**
	 * {@link CheckTypeBase} wrapper which only exposes methods appropriate for
	 * a POP 3 check type.
	 * 
	 * @author Jake Wharton <jakewharton@gmail.com>
	 */
	public static final class Pop3Type {
		private final CheckTypeBase base;
		
		private Pop3Type(CheckTypeBase base) {
			this.base = base;
		}
		
		/**
		 * Target port.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getPort() {
			return this.base.getPort();
		}
		
		/**
		 * Connection encryption.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Boolean getEncryption() {
			return this.base.getEncryption();
		}
		
		/**
		 * String to expect in response.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getStringToExpect() {
			return this.base.getStringToExpect();
		}
	}

	/**
	 * {@link CheckTypeBase} wrapper which only exposes methods appropriate for
	 * an HTTP check type.
	 * 
	 * @author Jake Wharton <jakewharton@gmail.com>
	 */
	public static final class ImapType {
		private final CheckTypeBase base;
		
		private ImapType(CheckTypeBase base) {
			this.base = base;
		}

		/**
		 * Target port.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Integer getPort() {
			return this.base.getPort();
		}
		
		/**
		 * Connection encryption.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public Boolean getEncryption() {
			return this.base.getEncryption();
		}
		
		/**
		 * String to expect in response.
		 * 
		 * @return Value.
		 * @since 2.0
		 */
		public String getStringToExpect() {
			return this.base.getStringToExpect();
		}
	}
	
	@Since(2.0) private Integer id;
	@Since(2.0) private String name;
	@Since(2.0) private CheckTypeWrapper type;
	@Since(2.0) private Date lastErrorTime;
	@Since(2.0) private Date lastTestTime;
	@Since(2.0) private Date lastResponseTime;
	@Since(2.0) private CheckStatus status;
	@Since(2.0) private Integer resolution;
	@Since(2.0) private String hostName;
	@Since(2.0) private Boolean sendToEmail;
	@Since(2.0) private Boolean sendToSms;
	@Since(2.0) private Boolean sendToTwitter;
	@Since(2.0) private Boolean sendToIPhone;
	@Since(2.0) private Integer sendNotificationWhenDown;
	@Since(2.0) private Integer notifyAgainEvery;
	@Since(2.0) private Boolean notifyWhenBackUp;
	@Since(2.0) private Date created;
	
	/**
	 * Check identifier.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Integer getId() {
		return this.id;
	}
	
	/**
	 * Check name.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Check type.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public CheckTypeWrapper getType() {
		return this.type;
	}
	
	/**
	 * Timestamp of last error (if any).
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Date getLastErrorTime() {
		return this.lastErrorTime;
	}
	
	/**
	 * Timestamp of last test (if any).
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Date getLastTestTime() {
		return this.lastTestTime;
	}
	
	/**
	 * Response time (in milliseconds) of last test.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Date getLastResponseTime() {
		return this.lastResponseTime;
	}
	
	/**
	 * Current status of check.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public CheckStatus getStatus() {
		return this.status;
	}
	
	/**
	 * How often should the check be tested? (minutes)
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Integer getResolution() {
		return this.resolution;
	}
	
	/**
	 * Target host.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public String getHostName() {
		return this.hostName;
	}
	
	/**
	 * Send alerts as email.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Boolean getSendToEmail() {
		return this.sendToEmail;
	}
	
	/**
	 * Send alerts as SMS.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Boolean getSendToSms() {
		return this.sendToSms;
	}
	
	/**
	 * Send alerts through Twitter.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Boolean getSendToTwitter() {
		return this.sendToTwitter;
	}
	
	/**
	 * Send alerts to iPhone.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Boolean getSendToIPhone() {
		return this.sendToIPhone;
	}
	
	/**
	 * Send notification when down <em>n</em> times.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Integer getSendNotificationWhenDown() {
		return this.sendNotificationWhenDown;
	}
	
	/**
	 * Notify again every <em>n</em> result.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Integer getNotifyAgainEvery() {
		return this.notifyAgainEvery;
	}
	
	/**
	 * Notify when back up again.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Boolean getNotifyWhenBackUp() {
		return this.notifyWhenBackUp;
	}
	
	/**
	 * Creating time.
	 * 
	 * @return Value.
	 * @since 2.0
	 */
	public Date getCreated() {
		return this.created;
	}
}
