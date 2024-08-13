package com.demo.domain;

import java.io.Serializable;

public class FundsDTO {
    private int uniqueid;
    private String productId;
    private String productName;
    private String productType;
    private int riskLevel;
    private String productState;
    private long createTime;

    // Getters and Setters
    public int getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(int uniqueid) {
        this.uniqueid = uniqueid;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(int riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getProductState() {
        return productState;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    // Optional: Override toString(), equals(), and hashCode() methods
    @Override
    public String toString() {
        return "FundsDTO{" +
                "uniqueid=" + uniqueid +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", riskLevel=" + riskLevel +
                ", productState='" + productState + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FundsDTO fundsDTO = (FundsDTO) o;

        if (uniqueid != fundsDTO.uniqueid) return false;
        if (riskLevel != fundsDTO.riskLevel) return false;
        if (createTime != fundsDTO.createTime) return false;
        if (productId != null ? !productId.equals(fundsDTO.productId) : fundsDTO.productId != null) return false;
        if (productName != null ? !productName.equals(fundsDTO.productName) : fundsDTO.productName != null) return false;
        if (productType != null ? !productType.equals(fundsDTO.productType) : fundsDTO.productType != null) return false;
        return productState != null ? productState.equals(fundsDTO.productState) : fundsDTO.productState == null;
    }

    @Override
    public int hashCode() {
        int result = uniqueid;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        result = 31 * result + riskLevel;
        result = 31 * result + (productState != null ? productState.hashCode() : 0);
        result = 31 * result + (int) (createTime ^ (createTime >>> 32));
        return result;
    }
}

