package com.inditex.ecommerce.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Price {

    private Integer id;
    private Integer priceList;
    private Integer brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String priority;
    private Double price;
    private String curr;

    public Price(){}

	public Price(Integer id, Integer priceList, Integer brandId, LocalDateTime startDate, LocalDateTime endDate,
			String priority, Double price, String curr) {
		super();
		this.id = id;
		this.priceList = priceList;
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.price = price;
		this.curr = curr;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}
	
	

	public Integer getId() {
		return id;
	}

	public Integer getPriceList() {
		return priceList;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public String getPriority() {
		return priority;
	}

	public Double getPrice() {
		return price;
	}

	public String getCurr() {
		return curr;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brandId, curr, endDate, id, price, priceList, priority, startDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Price other = (Price) obj;
		return Objects.equals(brandId, other.brandId) && Objects.equals(curr, other.curr)
				&& Objects.equals(endDate, other.endDate) && Objects.equals(id, other.id)
				&& Objects.equals(price, other.price) && Objects.equals(priceList, other.priceList)
				&& Objects.equals(priority, other.priority) && Objects.equals(startDate, other.startDate);
	}

	@Override
	public String toString() {
		return "Price [id=" + id + ", priceList=" + priceList + ", brandId=" + brandId + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", priority=" + priority + ", price=" + price + ", curr=" + curr + "]";
	};
    
    

}
