package com.demo.service.dto;

public class FundsShareDTO {
    private int uniqueid;
    private String customerId;
    private String productId;
    private int share;
    private String accountId;

    // Getters and Setters
    public int getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(int uniqueid) {
        this.uniqueid = uniqueid;
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

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    // Optional: Override toString(), equals(), and hashCode() methods
    @Override
    public String toString() {
        return "FundsShareDTO{" +
                "uniqueid=" + uniqueid +
                ", customerId='" + customerId + '\'' +
                ", productId='" + productId + '\'' +
                ", share=" + share +
                ", accountId='" + accountId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FundsShareDTO that = (FundsShareDTO) o;

        if (uniqueid != that.uniqueid) return false;
        if (share != that.share) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        return accountId != null ? accountId.equals(that.accountId) : that.accountId == null;
    }

    @Override
    public int hashCode() {
        int result = uniqueid;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + share;
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        return result;
    }
}

