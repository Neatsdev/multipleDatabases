package com.multiple.postgres.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "demo2")
@Entity
public class Demo2Entity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3873893793719249424L;

	@Id
	@Column(name = "partner_id")
	private String id;
	
	@Column(name = "partner_name")
	private String partnerName;
	
	@Column(name = "addressline1")
    private String addressline1;
	
	@Column(name = "addressline2")
    private String addressline2;
	
	@Column(name = "city")
    private String city;
	
	@Column(name = "company_id")
    private String companyId;
	
	@Column(name = "country")
    private String country;
	
	@Column(name = "county")
    private String county;
	
	@Column(name = "location_type")
    private String locationType;
	
	@Column(name = "partner_code")
    private String partnerCode;
	
	@Column(name = "partner_type")
    private String partnerType;
	
	@Column(name = "promotion_market")
    private String promotionMarket;
	
	@Column(name = "promotion_region")
    private String promotionRegion;
	
	@Column(name = "source_name")
    private String sourceName;
	
	@Column(name = "is_deleted")
    private String isDeleted;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public String getAddressline1() {
		return addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	public String getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(String partnerType) {
		this.partnerType = partnerType;
	}

	public String getPromotionMarket() {
		return promotionMarket;
	}

	public void setPromotionMarket(String promotionMarket) {
		this.promotionMarket = promotionMarket;
	}

	public String getPromotionRegion() {
		return promotionRegion;
	}

	public void setPromotionRegion(String promotionRegion) {
		this.promotionRegion = promotionRegion;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
}
