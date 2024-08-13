package com.demo.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class PurchaseDTO  {
    private int uniqueid;
    private String swiftNo;
    private BigDecimal money;
    private long timestamp;
    private String customerId;
    private String accountId;
    private String productId;
    private String state;

    // Getters and Setters
    public int getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(int uniqueid) {
        this.uniqueid = uniqueid;
    }

    public String getSwiftNo() {
        return swiftNo;
    }

    public void setSwiftNo(String swiftNo) {
        this.swiftNo = swiftNo;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // Optional: Override toString(), equals(), and hashCode() methods
    @Override
    public String toString() {
        return "PurchaseDTO{" +
                "uniqueid=" + uniqueid +
                ", swiftNo='" + swiftNo + '\'' +
                ", money=" + money +
                ", timestamp=" + timestamp +
                ", customerId='" + customerId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", productId='" + productId + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchaseDTO that = (PurchaseDTO) o;

        if (uniqueid != that.uniqueid) return false;
        if (timestamp != that.timestamp) return false;
        if (money != null ? !money.equals(that.money) : that.money != null) return false;
        if (swiftNo != null ? !swiftNo.equals(that.swiftNo) : that.swiftNo != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (accountId != null ? !accountId.equals(that.accountId) : that.accountId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        return state != null ? state.equals(that.state) : that.state == null;
    }

    @Override
    public int hashCode() {
        int result = uniqueid;
        result = 31 * result + (swiftNo != null ? swiftNo.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}

