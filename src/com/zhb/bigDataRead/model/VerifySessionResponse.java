/**
 * 
 */
package com.zhb.bigDataRead.model;

/**
 * @author LUCHUNLIANG
 *
 */
public class VerifySessionResponse {
	private String code;
	private String msg;
	private String eventTime;
	private VerifySessionResponseData data;
	


    /**
     * @return the eventTime
     */
    public String getEventTime() {
        return eventTime;
    }

    /**
     * @param eventTime the eventTime to set
     */
    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public VerifySessionResponseData getData() {
		return data;
	}

	public void setData(VerifySessionResponseData data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "{\"code\":\"" + code + "\",\"msg\":\"" + msg + "\",\"data\":\"" + data + "\"}";
	}

}
