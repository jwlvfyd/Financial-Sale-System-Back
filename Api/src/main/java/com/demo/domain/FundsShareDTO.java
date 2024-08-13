package com.demo.domain;

import java.io.Serializable;
import java.util.Objects;

public class FundsShareDTO {

    private int uniqueId;
    private String customerId;
    private String productId;
    private Integer share;
    private String accountId;

    // Default constructor
    public FundsShareDTO() {}

    // Parameterized constructor
    public FundsShareDTO(int uniqueId, String customerId, String productId, Integer share, String accountId) {
        this.uniqueId = uniqueId;
        this.customerId = customerId;
        this.productId = productId;
        this.share = share;
        this.accountId = accountId;
    }

    // Getters and Setters
    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getShare() {
        return share;
    }

    public void setShare(Integer share) {
        this.share = share;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    // Overriding hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(uniqueId, customerId, productId, share, accountId);
    }

    // Overriding equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FundsShareDTO that = (FundsShareDTO) o;
        return uniqueId == that.uniqueId &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(share, that.share) &&
                Objects.equals(accountId, that.accountId);
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "FundsShareDTO{" +
                "uniqueId=" + uniqueId +
                ", customerId='" + customerId + '\'' +
                ", productId='" + productId + '\'' +
                ", share=" + share +
                ", accountId='" + accountId + '\'' +
                '}';
    }
}
