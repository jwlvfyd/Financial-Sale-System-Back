package com.demo.service.dto;

import java.math.BigDecimal;

public class FundsValueDTO {
    private int uniqueid;
    private String productId;
    private long timestamp;
    private BigDecimal value;

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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    // Optional: Override toString(), equals(), and hashCode() methods
    @Override
    public String toString() {
        return "FundsValueDTO{" +
                "uniqueid=" + uniqueid +
                ", productId='" + productId + '\'' +
                ", timestamp=" + timestamp +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FundsValueDTO that = (FundsValueDTO) o;

        if (uniqueid != that.uniqueid) return false;
        if (timestamp != that.timestamp) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        int result = uniqueid;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
