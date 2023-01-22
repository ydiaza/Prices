package com.inditex.ecommerce.infrastructure.output.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PriceId implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2183148618245003297L;
	@Column(name="PRODUCT_ID")
    private Integer id;
    @Column(name="PRICE_LIST")
    private Integer priceList;

    public PriceId(){};
    public PriceId(Integer id, Integer priceList) {
        this.id = id;
        this.priceList = priceList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceId priceId = (PriceId) o;
        return Objects.equals(id, priceId.id) && Objects.equals(priceList, priceId.priceList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, priceList);
    }
}
