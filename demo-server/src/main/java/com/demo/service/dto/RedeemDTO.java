package com.demo.service.dto;

public class RedeemDTO {
    private int uniqueid;
    private String swiftNo;
    private int share;
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

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
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
        return "RedeemDTO{" +
                "uniqueid=" + uniqueid +
                ", swiftNo='" + swiftNo + '\'' +
                ", share=" + share +
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

        RedeemDTO redeemDTO = (RedeemDTO) o;

        if (uniqueid != redeemDTO.uniqueid) return false;
        if (share != redeemDTO.share) return false;
        if (timestamp != redeemDTO.timestamp) return false;
        if (swiftNo != null ? !swiftNo.equals(redeemDTO.swiftNo) : redeemDTO.swiftNo != null) return false;
        if (customerId != null ? !customerId.equals(redeemDTO.customerId) : redeemDTO.customerId != null) return false;
        if (accountId != null ? !accountId.equals(redeemDTO.accountId) : redeemDTO.accountId != null) return false;
        if (productId != null ? !productId.equals(redeemDTO.productId) : redeemDTO.productId != null) return false;
        return state != null ? state.equals(redeemDTO.state) : redeemDTO.state == null;
    }

    @Override
    public int hashCode() {
        int result = uniqueid;
        result = 31 * result + (swiftNo != null ? swiftNo.hashCode() : 0);
        result = 31 * result + share;
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
