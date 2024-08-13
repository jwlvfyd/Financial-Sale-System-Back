package com.demo.domain;

import java.io.Serializable;

public class CustomerInfoDTO  {
    private int uniqueid;
    private String customerId;
    private String name;
    private String gender;
    private String contactInfo;
    private int riskLevel;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(int riskLevel) {
        this.riskLevel = riskLevel;
    }

    // Optional: Override toString(), equals(), and hashCode() methods
    @Override
    public String toString() {
        return "CustomerInfoDTO{" +
                "uniqueid=" + uniqueid +
                ", customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", riskLevel=" + riskLevel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerInfoDTO that = (CustomerInfoDTO) o;

        if (uniqueid != that.uniqueid) return false;
        if (riskLevel != that.riskLevel) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        return contactInfo != null ? contactInfo.equals(that.contactInfo) : that.contactInfo == null;
    }

    @Override
    public int hashCode() {
        int result = uniqueid;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (contactInfo != null ? contactInfo.hashCode() : 0);
        result = 31 * result + riskLevel;
        return result;
    }
}

