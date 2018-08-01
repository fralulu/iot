package com.infore.dataacquisition.datahandler.model.entity;

import java.util.Date;

public class Station {
    private Integer id;

    private String stationName;

    private String stationAbbr;

    private String address;

    private Date buildTime;

    private String discrib;

    private String longitude;

    private String latitude;

    private Integer enterId;

    private String enterName;

    private String stationNumber;

    private Integer sort;

    private String stationtypeCode;

    private Integer admId;
    
    private Integer frequency;
    
    private Integer linkState;
    
    private String overState;
    
    public Integer getLinkState() {
		return linkState;
	}

	public void setLinkState(Integer linkState) {
		this.linkState = linkState;
	}

	public String getOverState() {
		return overState;
	}

	public void setOverState(String overState) {
		this.overState = overState;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    public String getStationAbbr() {
        return stationAbbr;
    }

    public void setStationAbbr(String stationAbbr) {
        this.stationAbbr = stationAbbr == null ? null : stationAbbr.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(Date buildTime) {
        this.buildTime = buildTime;
    }

    public String getDiscrib() {
        return discrib;
    }

    public void setDiscrib(String discrib) {
        this.discrib = discrib == null ? null : discrib.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public Integer getEnterId() {
        return enterId;
    }

    public void setEnterId(Integer enterId) {
        this.enterId = enterId;
    }

    public String getEnterName() {
        return enterName;
    }

    public void setEnterName(String enterName) {
        this.enterName = enterName == null ? null : enterName.trim();
    }

    public String getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(String stationNumber) {
        this.stationNumber = stationNumber == null ? null : stationNumber.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getStationtypeCode() {
        return stationtypeCode;
    }

    public void setStationtypeCode(String stationtypeCode) {
        this.stationtypeCode = stationtypeCode == null ? null : stationtypeCode.trim();
    }

	public Integer getAdmId() {
		return admId;
	}

	public void setAdmId(Integer admId) {
		this.admId = admId;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "Station [id=" + id + ", stationName=" + stationName
				+ ", stationAbbr=" + stationAbbr + ", address=" + address
				+ ", buildTime=" + buildTime + ", discrib=" + discrib
				+ ", longitude=" + longitude + ", latitude=" + latitude
				+ ", enterId=" + enterId + ", enterName=" + enterName
				+ ", stationNumber=" + stationNumber + ", sort=" + sort
				+ ", stationtypeCode=" + stationtypeCode + ", admId=" + admId
				+ ", frequency=" + frequency + ", linkState=" + linkState
				+ ", overState=" + overState + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Station other = (Station) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}