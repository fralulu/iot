package com.infore.dataacquisition.datahandler.model.entity;

import java.math.BigDecimal;

public class Factor {
    private Integer id;

    private String factorName;

    private String factorCode;

    private String unit;

    private Double upper;

    private Double flower;
    
    private Double standValue;

    private String discrib;

    private Integer accuracy;

    private Integer sort;

    private Short pollutionFactor;

    private String factortypeCode;

    private BigDecimal createUser;
    
    private Integer totalCount;
    
    private String factorCodeOld;
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFactorName() {
        return factorName;
    }

    public void setFactorName(String factorName) {
        this.factorName = factorName == null ? null : factorName.trim();
    }

    public String getFactorCode() {
        return factorCode;
    }

    public void setFactorCode(String factorCode) {
        this.factorCode = factorCode == null ? null : factorCode.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }


    public Double getUpper() {
		return upper;
	}

	public void setUpper(Double upper) {
		this.upper = upper;
	}

	public Double getFlower() {
		return flower;
	}

	public void setFlower(Double flower) {
		this.flower = flower;
	}

	public String getDiscrib() {
        return discrib;
    }

    public void setDiscrib(String discrib) {
        this.discrib = discrib == null ? null : discrib.trim();
    }

    public Integer getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Short getPollutionFactor() {
        return pollutionFactor;
    }

    public void setPollutionFactor(Short pollutionFactor) {
        this.pollutionFactor = pollutionFactor;
    }

    public String getFactortypeCode() {
        return factortypeCode;
    }

    public void setFactortypeCode(String factortypeCode) {
        this.factortypeCode = factortypeCode == null ? null : factortypeCode.trim();
    }

    public BigDecimal getCreateUser() {
        return createUser;
    }

    public void setCreateUser(BigDecimal createUser) {
        this.createUser = createUser;
    }

	public Double getStandValue() {
		return standValue;
	}

	public void setStandValue(Double standValue) {
		this.standValue = standValue;
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
		Factor other = (Factor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Factor [id=" + id + ", factorName=" + factorName
				+ ", factorCode=" + factorCode + ", unit=" + unit + ", upper="
				+ upper + ", flower=" + flower + ", standValue=" + standValue
				+ ", discrib=" + discrib + ", accuracy=" + accuracy + ", sort="
				+ sort + ", pollutionFactor=" + pollutionFactor
				+ ", factortypeCode=" + factortypeCode + ", createUser="
				+ createUser + "]";
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public String getFactorCodeOld() {
		return factorCodeOld;
	}

	public void setFactorCodeOld(String factorCodeOld) {
		this.factorCodeOld = factorCodeOld;
	}
	
}