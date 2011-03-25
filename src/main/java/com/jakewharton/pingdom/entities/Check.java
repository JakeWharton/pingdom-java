package com.jakewharton.pingdom.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		public CheckTypeBase getObject() {
			return this.typeObject;
		}
	}
	
	/**
	 * Mapping of {@link CheckType} to {@link CheckTypeBase} subclasses.
	 */
	public static final Map<CheckType, Class<? extends CheckTypeBase>> CLASS_MAP = new HashMap<CheckType, Class<? extends CheckTypeBase>>();
	
	static {
		//Initialize type-to-class mapping
		CLASS_MAP.put(CheckType.Http, HttpType.class);
		CLASS_MAP.put(CheckType.HttpCustom, HttpCustomType.class);
		CLASS_MAP.put(CheckType.Tcp, TcpType.class);
		CLASS_MAP.put(CheckType.Ping, PingType.class);
		CLASS_MAP.put(CheckType.Dns, DnsType.class);
		CLASS_MAP.put(CheckType.Udp, UdpType.class);
		CLASS_MAP.put(CheckType.Smtp, SmtpType.class);
		CLASS_MAP.put(CheckType.Pop3, Pop3Type.class);
		CLASS_MAP.put(CheckType.Imap, ImapType.class);
	}
	
	public static abstract class CheckTypeBase implements PingdomEntity {
		private static final long serialVersionUID = 1813724658931962637L;
	}
	public static final class HttpType extends CheckTypeBase {
		private static final long serialVersionUID = 8746503435697435856L;
		
		private String url;
		private Boolean encryption;
		private Integer port;
		private String username;
		private String password;
		private String shouldContain;
		private String shouldNotContain;
		private String postData;
		private Map<String, String> requestHeaders;
		
		public String getUrl() {
			return url;
		}
		public Boolean getEncryption() {
			return encryption;
		}
		public Integer getPort() {
			return port;
		}
		public String getUsername() {
			return username;
		}
		public String getPassword() {
			return password;
		}
		public String getShouldContain() {
			return shouldContain;
		}
		public String getShouldNotContain() {
			return shouldNotContain;
		}
		public String getPostData() {
			return postData;
		}
		public Map<String, String> getRequestHeaders() {
			return requestHeaders;
		}
	}
	public static final class HttpCustomType extends CheckTypeBase {
		private static final long serialVersionUID = 4471055299456348927L;
		
		private String url;
		private Boolean encryption;
		private Integer port;
		private String username;
		private String password;
		private List<String> additionalUrls;
		
		public String getUrl() {
			return url;
		}
		public Boolean getEncryption() {
			return encryption;
		}
		public Integer getPort() {
			return port;
		}
		public String getUsername() {
			return username;
		}
		public String getPassword() {
			return password;
		}
		public List<String> getAdditionalUrls() {
			return additionalUrls;
		}
	}
	public static final class TcpType extends CheckTypeBase {
		private static final long serialVersionUID = 6901903180365258256L;
		
		private Integer port;
		private String stringToSend;
		private String stringToExpect;
		
		public Integer getPort() {
			return port;
		}
		public String getStringToSend() {
			return stringToSend;
		}
		public String getStringToExpect() {
			return stringToExpect;
		}
	}
	public static final class PingType extends CheckTypeBase {
		private static final long serialVersionUID = 4274637575207052368L;
	}
	public static final class DnsType extends CheckTypeBase {
		private static final long serialVersionUID = -383887207810094123L;
		
		private String nameServer;
		private String expectedIp;
		
		public String getNameServer() {
			return nameServer;
		}
		public String getExpectedIp() {
			return expectedIp;
		}
	}
	public static final class UdpType extends CheckTypeBase {
		private static final long serialVersionUID = 102679977818218440L;
		
		private Integer port;
		private String stringToSend;
		private String stringToExpect;
		
		public Integer getPort() {
			return port;
		}
		public String getStringToSend() {
			return stringToSend;
		}
		public String getStringToExpect() {
			return stringToExpect;
		}
	}
	public static final class SmtpType extends CheckTypeBase {
		private static final long serialVersionUID = 3753689361049225171L;
		
		private Integer port;
		private String username;
		private String password;
		private Boolean encryption;
		private String stringToExpect;
		
		public Integer getPort() {
			return port;
		}
		public String getUsername() {
			return username;
		}
		public String getPassword() {
			return password;
		}
		public Boolean getEncryption() {
			return encryption;
		}
		public String getStringToExpect() {
			return stringToExpect;
		}
	}
	public static final class Pop3Type extends CheckTypeBase {
		private static final long serialVersionUID = -5366736202575589403L;
		
		private Integer port;
		private Boolean encryption;
		private String stringToExpect;
		
		public Integer getPort() {
			return port;
		}
		public Boolean getEncryption() {
			return encryption;
		}
		public String getStringToExpect() {
			return stringToExpect;
		}
	}
	public static final class ImapType extends CheckTypeBase {
		private static final long serialVersionUID = 738277068049535332L;
		
		private Integer port;
		private Boolean encryption;
		private String stringToExpect;
		
		public Integer getPort() {
			return port;
		}
		public Boolean getEncryption() {
			return encryption;
		}
		public String getStringToExpect() {
			return stringToExpect;
		}
	}
	
	private Integer id;
	private String name;
	private CheckTypeWrapper type;
	private Date lastErrorTime;
	private Date lastTestTime;
	private Date lastResponseTime;
	private CheckStatus status;
	private Integer resolution;
	private String hostName;
	private Boolean sendToEmail;
	private Boolean sendToSms;
	private Boolean sendToTwitter;
	private Boolean sendToIPhone;
	private Integer sendNotificationWhenDown;
	private Integer notifyAgainEvery;
	private Boolean notifyWhenBackUp;
	private Date created;
	
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
