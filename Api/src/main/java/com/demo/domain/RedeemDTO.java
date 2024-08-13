package com.demo.domain;

import java.io.Serializable;
import java.util.Objects;

public class RedeemDTO  {

    private int uniqueId;
    private String swiftNo;
    private Integer share;
    private Long timestamp;
    private String customerId;
    private String accountId;
    private String productId;
    private String state;

    // Default constructor
    public RedeemDTO() {}

    // Parameterized constructor
    public RedeemDTO(int uniqueId, String swiftNo, Integer share, Long timestamp, String customerId, String accountId, String productId, String state) {
        this.uniqueId = uniqueId;
        this.swiftNo = swiftNo;
        this.share = share;
        this.timestamp = timestamp;
        this.customerId = customerId;
        this.accountId = accountId;
        this.productId = productId;
        this.state = state;
    }

    // Getters and Setters
    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getSwiftNo() {
        return swiftNo;
    }

    public void setSwiftNo(String swiftNo) {
        this.swiftNo = swiftNo;
    }

    public Integer getShare() {
        return share;
    }

    public void setShare(Integer share) {
        this.share = share;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
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

    // Overriding hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(uniqueId, swiftNo, share, timestamp, customerId, accountId, productId, state);
    }

    // Overriding equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RedeemDTO redeemDTO = (RedeemDTO) o;
        return uniqueId == redeemDTO.uniqueId &&
                Objects.equals(swiftNo, redeemDTO.swiftNo) &&
                Objects.equals(share, redeemDTO.share) &&
                Objects.equals(timestamp, redeemDTO.timestamp) &&
                Objects.equals(customerId, redeemDTO.customerId) &&
                Objects.equals(accountId, redeemDTO.accountId) &&
                Objects.equals(productId, redeemDTO.productId) &&
                Objects.equals(state, redeemDTO.state);
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "RedeemDTO{" +
                "uniqueId=" + uniqueId +
                ", swiftNo='" + swiftNo + '\'' +
                ", share=" + share +
                ", timestamp=" + timestamp +
                ", customerId='" + customerId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", productId='" + productId + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
