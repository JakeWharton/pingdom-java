package com.jakewharton.pingdom.entities;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.google.gson.annotations.Since;
import com.jakewharton.pingdom.PingdomEntity;
import com.jakewharton.pingdom.enumerations.CheckStatus;
import com.jakewharton.pingdom.enumerations.CheckType;

public final class Check implements PingdomEntity {
	private static final long serialVersionUID = 6610462680859684444L;
	
	public static final class CheckTypeWrapper implements PingdomEntity {
		private static final long serialVersionUID = -3920151255560101200L;
		
		public CheckTypeWrapper(CheckType typeNative, CheckTypeBase typeObject) {
			this.typeNative = typeNative;
			this.typeObject = typeObject;
		}
		
		private final CheckType typeNative;
		private final CheckTypeBase typeObject;
		
		public CheckType getNative() {
			return this.typeNative;
		}
		public CheckTypeBase getTypeObject() {
			return this.typeObject;
		}
		
		public HttpType asHttp() {
			return new HttpType(this.typeObject);
		}
		public HttpCustomType asHttpCustom() {
			return new HttpCustomType(this.typeObject);
		}
		public TcpType asTcp() {
			return new TcpType(this.typeObject);
		}
		public PingType asPing() {
			return new PingType(this.typeObject);
		}
		public DnsType asDns() {
			return new DnsType(this.typeObject);
		}
		public UdpType asUdp() {
			return new UdpType(this.typeObject);
		}
		public SmtpType asSmtp() {
			return new SmtpType(this.typeObject);
		}
		public Pop3Type asPop3() {
			return new Pop3Type(this.typeObject);
		}
		public ImapType asImap() {
			return new ImapType(this.typeObject);
		}
	}
	
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
		
		public String getUrl() {
			return this.url;
		}
		public Boolean getEncryption() {
			return this.encryption;
		}
		public Integer getPort() {
			return this.port;
		}
		public String getUsername() {
			return this.username;
		}
		public String getPassword() {
			return this.password;
		}
		public String getShouldContain() {
			return this.shouldContain;
		}
		public String getShouldNotContain() {
			return this.shouldNotContain;
		}
		public String getPostData() {
			return this.postData;
		}
		public Map<String, String> getRequestHeaders() {
			return this.requestHeaders;
		}
		public List<String> getAdditionalUrls() {
			return this.additionalUrls;
		}
		public String getStringToSend() {
			return this.stringToSend;
		}
		public String getStringToExpect() {
			return this.stringToExpect;
		}
		public String getNameServer() {
			return this.nameServer;
		}
		public String getExpectedIp() {
			return this.expectedIp;
		}
	}
	
	public static final class HttpType {
		private final CheckTypeBase base;
		
		private HttpType(CheckTypeBase base) {
			this.base = base;
		}
		
		public String getUrl() {
			return this.base.getUrl();
		}
		public Boolean getEncryption() {
			return this.base.getEncryption();
		}
		public Integer getPort() {
			return this.base.getPort();
		}
		public String getUsername() {
			return this.base.getUsername();
		}
		public String getPassword() {
			return this.base.getPassword();
		}
		public String getShouldContain() {
			return this.base.getShouldContain();
		}
		public String getShouldNotContain() {
			return this.base.getShouldNotContain();
		}
		public String getPostData() {
			return this.base.getPostData();
		}
		public Map<String, String> getRequestHeaders() {
			return this.base.getRequestHeaders();
		}
	}
	public static final class HttpCustomType {
		private final CheckTypeBase base;
		
		private HttpCustomType(CheckTypeBase base) {
			this.base = base;
		}

		public String getUrl() {
			return this.base.getUrl();
		}
		public Boolean getEncryption() {
			return this.base.getEncryption();
		}
		public Integer getPort() {
			return this.base.getPort();
		}
		public String getUsername() {
			return this.base.getUsername();
		}
		public String getPassword() {
			return this.base.getPassword();
		}
		public List<String> getAdditionalUrls() {
			return this.base.getAdditionalUrls();
		}
	}
	public static final class TcpType {
		private final CheckTypeBase base;
		
		private TcpType(CheckTypeBase base) {
			this.base = base;
		}
		
		public Integer getPort() {
			return this.base.getPort();
		}
		public String getStringToSend() {
			return this.base.getStringToSend();
		}
		public String getStringToExpect() {
			return this.base.getStringToExpect();
		}
	}
	public static final class PingType {
		@SuppressWarnings("unused")
		private final CheckTypeBase base;
		
		private PingType(CheckTypeBase base) {
			this.base = base;
		}
	}
	public static final class DnsType {
		private final CheckTypeBase base;
		
		private DnsType(CheckTypeBase base) {
			this.base = base;
		}
		
		public String getNameServer() {
			return this.base.getNameServer();
		}
		public String getExpectedIp() {
			return this.base.getExpectedIp();
		}
	}
	public static final class UdpType {
		private final CheckTypeBase base;
		
		private UdpType(CheckTypeBase base) {
			this.base = base;
		}
		
		public Integer getPort() {
			return this.base.getPort();
		}
		public String getStringToSend() {
			return this.base.getStringToSend();
		}
		public String getStringToExpect() {
			return this.base.getStringToExpect();
		}
	}
	public static final class SmtpType {
		private final CheckTypeBase base;
		
		private SmtpType(CheckTypeBase base) {
			this.base = base;
		}
		
		public Integer getPort() {
			return this.base.getPort();
		}
		public String getUsername() {
			return this.base.getUsername();
		}
		public String getPassword() {
			return this.base.getPassword();
		}
		public Boolean getEncryption() {
			return this.base.getEncryption();
		}
		public String getStringToExpect() {
			return this.base.getStringToExpect();
		}
	}
	public static final class Pop3Type {
		private final CheckTypeBase base;
		
		private Pop3Type(CheckTypeBase base) {
			this.base = base;
		}
		
		public Integer getPort() {
			return this.base.getPort();
		}
		public Boolean getEncryption() {
			return this.base.getEncryption();
		}
		public String getStringToExpect() {
			return this.base.getStringToExpect();
		}
	}
	public static final class ImapType {
		private final CheckTypeBase base;
		
		private ImapType(CheckTypeBase base) {
			this.base = base;
		}
		
		public Integer getPort() {
			return this.base.getPort();
		}
		public Boolean getEncryption() {
			return this.base.getEncryption();
		}
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
	
	public Integer getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public CheckTypeWrapper getType() {
		return this.type;
	}
	public Date getLastErrorTime() {
		return this.lastErrorTime;
	}
	public Date getLastTestTime() {
		return this.lastTestTime;
	}
	public Date getLastResponseTime() {
		return this.lastResponseTime;
	}
	public CheckStatus getStatus() {
		return this.status;
	}
	public Integer getResolution() {
		return this.resolution;
	}
	public String getHostName() {
		return this.hostName;
	}
	public Boolean getSendToEmail() {
		return this.sendToEmail;
	}
	public Boolean getSendToSms() {
		return this.sendToSms;
	}
	public Boolean getSendToTwitter() {
		return this.sendToTwitter;
	}
	public Boolean getSendToIPhone() {
		return this.sendToIPhone;
	}
	public Integer getSendNotificationWhenDown() {
		return this.sendNotificationWhenDown;
	}
	public Integer getNotifyAgainEvery() {
		return this.notifyAgainEvery;
	}
	public Boolean getNotifyWhenBackUp() {
		return this.notifyWhenBackUp;
	}
	public Date getCreated() {
		return this.created;
	}
}
