package com.demo.service.dto;

public class CancellationDTO {
    private int uniqueid;
    private String swiftNo;
    private long timestamp;
    private String cancelType;
    private String cancelId;
    private String productId;

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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getCancelType() {
        return cancelType;
    }

    public void setCancelType(String cancelType) {
        this.cancelType = cancelType;
    }

    public String getCancelId() {
        return cancelId;
    }

    public void setCancelId(String cancelId) {
        this.cancelId = cancelId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    // Optional: Override toString(), equals(), and hashCode() methods
    @Override
    public String toString() {
        return "CancellationDTO{" +
                "uniqueid=" + uniqueid +
                ", swiftNo='" + swiftNo + '\'' +
                ", timestamp=" + timestamp +
                ", cancelType='" + cancelType + '\'' +
                ", cancelId='" + cancelId + '\'' +
                ", productId='" + productId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CancellationDTO that = (CancellationDTO) o;

        if (uniqueid != that.uniqueid) return false;
        if (timestamp != that.timestamp) return false;
        if (swiftNo != null ? !swiftNo.equals(that.swiftNo) : that.swiftNo != null) return false;
        if (cancelType != null ? !cancelType.equals(that.cancelType) : that.cancelType != null) return false;
        if (cancelId != null ? !cancelId.equals(that.cancelId) : that.cancelId != null) return false;
        return productId != null ? productId.equals(that.productId) : that.productId == null;
    }

    @Override
    public int hashCode() {
        int result = uniqueid;
        result = 31 * result + (swiftNo != null ? swiftNo.hashCode() : 0);
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        result = 31 * result + (cancelType != null ? cancelType.hashCode() : 0);
        result = 31 * result + (cancelId != null ? cancelId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        return result;
    }
}

