package com.demo.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountChangeDTO {
    private int uniqueid;
    private String accountId;
    private long timestamp;
    private BigDecimal balanceChange;
    private String tradeType;

    // Getters and Setters
    public int getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(int uniqueid) {
        this.uniqueid = uniqueid;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getBalanceChange() {
        return balanceChange;
    }

    public void setBalanceChange(BigDecimal balanceChange) {
        this.balanceChange = balanceChange;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    // Optional: Override toString(), equals(), and hashCode() methods
    @Override
    public String toString() {
        return "AccountChangeDTO{" +
                "uniqueid=" + uniqueid +
                ", accountId='" + accountId + '\'' +
                ", timestamp=" + timestamp +
                ", balanceChange=" + balanceChange +
                ", tradeType='" + tradeType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountChangeDTO that = (AccountChangeDTO) o;

        if (uniqueid != that.uniqueid) return false;
        if (timestamp != that.timestamp) return false;
        if (accountId != null ? !accountId.equals(that.accountId) : that.accountId != null) return false;
        if (balanceChange != null ? !balanceChange.equals(that.balanceChange) : that.balanceChange != null)
            return false;
        return tradeType != null ? tradeType.equals(that.tradeType) : that.tradeType == null;
    }

    @Override
    public int hashCode() {
        int result = uniqueid;
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        result = 31 * result + (balanceChange != null ? balanceChange.hashCode() : 0);
        result = 31 * result + (tradeType != null ? tradeType.hashCode() : 0);
        return result;
    }
}

