/**
 * 
 */
package com.zhb.bigDataRead.model;

import com.alibaba.fastjson.JSON;

/**
 * @author LUCHUNLIANG
 *
 */
public class VerifySessionResponseData {
	// xgAppId 是 String xgsdk分配给游戏的ID
	private String xgAppId;
	// planId 是 String 发布计划编号
	private String planId;
	// channelId 是 String 渠道ID
	private String channelId;
	// deviceId 是 String 设备id
	private String deviceId;
	// sessionId 否 String 酷派:authorization code
	private String sessionId;
	// uid 是 String 酷派:openid
	private String uid;
	// userName 否 String Vivo:name
	private String userName;
	// nickName 否 String 酷派:nickname
	private String nickName;
	// state 否 String 账号状态
	private String state;
	// mail 否 String 邮箱地址
	private String mail;
	// sex 否 String 性别1-男2-女0-未知
	private String sex;
	// brithday 否 String 生日格式：YYYY-MM-DD
	private String brithday;
	// smallHeadIconUrl 否 String 头像小图标
	private String smallHeadIconUrl;
	// bigHeadIconUrl 否 String 头像大图标
	private String bigHeadIconUrl;
	// constellation 否 String 星座
	private String constellation;
	// balance 否 String 余额
	private String balance;
	// level 否 String 当乐:level
	private String level;

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	/**
	 * @return the xgAppId
	 */
	public String getXgAppId() {
		return xgAppId;
	}

	/**
	 * @param xgAppId
	 *            the xgAppId to set
	 */
	public void setXgAppId(String xgAppId) {
		this.xgAppId = xgAppId;
	}

	/**
	 * @return the planId
	 */
	public String getPlanId() {
		return planId;
	}

	/**
	 * @param planId
	 *            the planId to set
	 */
	public void setPlanId(String planId) {
		this.planId = planId;
	}

	/**
	 * @return the channelId
	 */
	public String getChannelId() {
		return channelId;
	}

	/**
	 * @param channelId
	 *            the channelId to set
	 */
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId
	 *            the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId
	 *            the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid
	 *            the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName
	 *            the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the brithday
	 */
	public String getBrithday() {
		return brithday;
	}

	/**
	 * @param brithday
	 *            the brithday to set
	 */
	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}

	/**
	 * @return the smallHeadIconUrl
	 */
	public String getSmallHeadIconUrl() {
		return smallHeadIconUrl;
	}

	/**
	 * @param smallHeadIconUrl
	 *            the smallHeadIconUrl to set
	 */
	public void setSmallHeadIconUrl(String smallHeadIconUrl) {
		this.smallHeadIconUrl = smallHeadIconUrl;
	}

	/**
	 * @return the bigHeadIconUrl
	 */
	public String getBigHeadIconUrl() {
		return bigHeadIconUrl;
	}

	/**
	 * @param bigHeadIconUrl
	 *            the bigHeadIconUrl to set
	 */
	public void setBigHeadIconUrl(String bigHeadIconUrl) {
		this.bigHeadIconUrl = bigHeadIconUrl;
	}

	/**
	 * @return the constellation
	 */
	public String getConstellation() {
		return constellation;
	}

	/**
	 * @param constellation
	 *            the constellation to set
	 */
	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	/**
	 * @return the balance
	 */
	public String getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(String balance) {
		this.balance = balance;
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}

}
