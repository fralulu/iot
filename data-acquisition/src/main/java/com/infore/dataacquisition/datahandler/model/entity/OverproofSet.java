package com.infore.dataacquisition.datahandler.model.entity;

public class OverproofSet {
    private Integer id;

    private Integer factorId;

    private String factorName;

    private String overproofName;

    private Double overproofValue;
    
    private String overproofColor;
    
    private String hoverproofName;

    private Double hoverproofValue;
    
    private String hoverproofColor;
    
    private String coverproofName;

    private Double coverproofValue;
    
    private String coverproofColor;

    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFactorId() {
        return factorId;
    }

    public void setFactorId(Integer factorId) {
        this.factorId = factorId;
    }

    public String getFactorName() {
        return factorName;
    }

    public void setFactorName(String factorName) {
        this.factorName = factorName == null ? null : factorName.trim();
    }

    public String getOverproofName() {
        return overproofName;
    }

    public void setOverproofName(String overproofName) {
        this.overproofName = overproofName == null ? null : overproofName.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

	public Double getOverproofValue() {
		return overproofValue;
	}

	public void setOverproofValue(Double overproofValue) {
		this.overproofValue = overproofValue;
	}

	public String getOverproofColor() {
		return overproofColor;
	}

	public void setOverproofColor(String overproofColor) {
		this.overproofColor = overproofColor;
	}

	public String getHoverproofName() {
		return hoverproofName;
	}

	public void setHoverproofName(String hoverproofName) {
		this.hoverproofName = hoverproofName;
	}

	public Double getHoverproofValue() {
		return hoverproofValue;
	}

	public void setHoverproofValue(Double hoverproofValue) {
		this.hoverproofValue = hoverproofValue;
	}

	public String getHoverproofColor() {
		return hoverproofColor;
	}

	public void setHoverproofColor(String hoverproofColor) {
		this.hoverproofColor = hoverproofColor;
	}

	public String getCoverproofName() {
		return coverproofName;
	}

	public void setCoverproofName(String coverproofName) {
		this.coverproofName = coverproofName;
	}

	public Double getCoverproofValue() {
		return coverproofValue;
	}

	public void setCoverproofValue(Double coverproofValue) {
		this.coverproofValue = coverproofValue;
	}

	public String getCoverproofColor() {
		return coverproofColor;
	}

	public void setCoverproofColor(String coverproofColor) {
		this.coverproofColor = coverproofColor;
	}
    
    
}