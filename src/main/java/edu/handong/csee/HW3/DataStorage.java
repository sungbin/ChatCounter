package edu.handong.csee.HW3;

public class DataStorage {
	private String kakao_id ;
	private String hours;
	private String minutes;
	private String message;
	
	public String getKakao_id() {
		return kakao_id;
	}
	@Override
	public String toString() {
		return "DataStorage [kakao_id=" + kakao_id + ", hours=" + hours + ", minutes=" + minutes + ", message="
				+ message + "]";
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getMinutes() {
		return minutes;
	}
	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}
	public String getmessage() {
		return message;
	}
	public void setmessage(String message) {
		this.message = message;
	}
	public void setKakao_id(String kakao_id) {
		this.kakao_id = kakao_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((hours == null) ? 0 : hours.hashCode());
		result = prime * result + ((kakao_id == null) ? 0 : kakao_id.hashCode());
		result = prime * result + ((minutes == null) ? 0 : minutes.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataStorage other = (DataStorage) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (hours == null) {
			if (other.hours != null)
				return false;
		} else if (!hours.equals(other.hours))
			return false;
		if (kakao_id == null) {
			if (other.kakao_id != null)
				return false;
		} else if (!kakao_id.equals(other.kakao_id))
			return false;
		if (minutes == null) {
			if (other.minutes != null)
				return false;
		} else if (!minutes.equals(other.minutes))
			return false;
		return true;
	}



}
