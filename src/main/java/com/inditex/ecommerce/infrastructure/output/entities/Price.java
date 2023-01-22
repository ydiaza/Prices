package com.inditex.ecommerce.infrastructure.output.entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="PRICES")
public class Price {

    @EmbeddedId
    private PriceId id;
    @Column(name="BRAND_ID")
    private Integer brandId;
    @NonNull
    @Column(name="START_DATE")
    private LocalDateTime startDate;
    @Column(name="END_DATE")
    private LocalDateTime endDate;

    @Column(name="PRIORITY")
    private String priority;
    @Column(name="PRICE")
    private Double price;
    @Column(name="CURR")
    private String curr;

    public Price(){};
    public Price(Integer id, Integer brandId, @NonNull LocalDateTime startDate, LocalDateTime endDate, Integer priceList, String priority, Double price, String curr) {
        this.id = new PriceId(id,priceList);
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
    }
    public Integer getId() {
        return id.getId();
    }
    public void setId(Integer id) {
        this.id.setId(id);
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    @NonNull
    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(@NonNull LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getPriceList() {
        return id.getPriceList();
    }

    public void setPriceList(Integer priceList) {
        this.id.setPriceList(priceList);
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return id.equals(price1.id) && brandId.equals(price1.brandId) && startDate.equals(price1.startDate) && Objects.equals(endDate, price1.endDate) && Objects.equals(priority, price1.priority) && Objects.equals(price, price1.price) && Objects.equals(curr, price1.curr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brandId, startDate, endDate, priority, price, curr);
    }
}
