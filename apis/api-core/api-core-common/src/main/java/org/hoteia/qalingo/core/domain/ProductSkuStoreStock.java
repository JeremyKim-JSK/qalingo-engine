/**
 * Most of the code in the Qalingo project is copyrighted Hoteia and licensed
 * under the Apache License Version 2.0 (release version 0.8.0)
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *                   Copyright (c) Hoteia, 2012-2014
 * http://www.hoteia.com - http://twitter.com/hoteia - contact@hoteia.com
 *
 */
package org.hoteia.qalingo.core.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hoteia.qalingo.core.domain.impl.DomainEntity;

@Entity
@Table(name="TECO_PRODUCT_SKU_STORE_STOCK")
public class ProductSkuStoreStock extends AbstractEntity<ProductSkuStoreStock> implements DomainEntity {

	/**
	 * Generated UID
	 */
	private static final long serialVersionUID = -3373109081158498135L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Version
	@Column(name="VERSION", nullable=false) // , columnDefinition="int(11) default 1"
	private int version;

    @Column(name="GLOBAL_STOCK_QUANTITY", nullable=false) // , columnDefinition="int(11) default 0"
    private int globalStockQuantity;

    @Column(name = "RESERVED_STOCK_WHAREHOUSE", nullable=false) // , columnDefinition="int(11) default 0"
    private int reservedStockWharehouse;

    @Column(name="RESERVED_STOCK_ECO", nullable=false) // , columnDefinition="int(11) default 0"
    private int reservedStockEco;

    @Column(name="STOCK_USED_BY_ACTIVE_CART", nullable=false) // , columnDefinition="int(11) default 0"
    private int stockUsedByActiveCart;

    @Column(name="REORDER_QTY_ALERT", nullable=false) // , columnDefinition="int(11) default 0"
    private int reorderQuantityAlert;

	@Column(name="REORDER_QTY_TRIGGER", nullable=false) // , columnDefinition="int(11) default 0"
	private int reorderQuantityTrigger;

    @Column(name = "REORDER_NEXT_DATE")
    private Date reorderNextDate;

    @Column(name="MARKET_AREA_ID")
    private Long marketAreaId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WAREHOUSE_ID", insertable = true, updatable = true)
	private Warehouse warehouse;
	
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = org.hoteia.qalingo.core.domain.Store.class)
    @JoinColumn(name="STORE_ID", insertable = true, updatable = true)
    private Store store;
    
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = org.hoteia.qalingo.core.domain.ProductSku.class)
    @JoinColumn(name="PRODUCT_SKU_ID", insertable = true, updatable = true)
    private ProductSku productSku;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_CREATE")
    private Date dateCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_UPDATE")
    private Date dateUpdate;
    
    public ProductSkuStoreStock() {
        this.dateCreate = new Date();
        this.dateUpdate = new Date();
    }

    public ProductSkuStoreStock(Long marketAreaId) {
        this.marketAreaId = marketAreaId;
        this.dateCreate = new Date();
        this.dateUpdate = new Date();
    }

    public Long getId() {
        return id;
    }

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Integer getGlobalStockQuantity() {
        return globalStockQuantity;
    }

    public void setGlobalStockQuantity(Integer globalStockQuantity) {
        this.globalStockQuantity = globalStockQuantity;
    }

    public Integer getReservedStockWharehouse() {
        return reservedStockWharehouse;
    }

    public void setReservedStockWharehouse(Integer reservedStockWharehouse) {
        this.reservedStockWharehouse = reservedStockWharehouse;
    }

    public Integer getReservedStockEco() {
        return reservedStockEco;
    }

    public void setReservedStockEco(Integer reservedStockEco) {
        this.reservedStockEco = reservedStockEco;
    }

    public Integer getStockUsedByActiveCart() {
        return stockUsedByActiveCart;
    }

    public void setStockUsedByActiveCart(Integer stockUsedByActiveCart) {
        this.stockUsedByActiveCart = stockUsedByActiveCart;
    }

    public Integer getReorderQuantityAlert() {
        return reorderQuantityAlert;
    }

    public void setReorderQuantityAlert(Integer reorderQuantityAlert) {
        this.reorderQuantityAlert = reorderQuantityAlert;
    }

    public Integer getReorderQuantityTrigger() {
        return reorderQuantityTrigger;
    }

    public void setReorderQuantityTrigger(Integer reorderQuantityTrigger) {
        this.reorderQuantityTrigger = reorderQuantityTrigger;
    }

    public Date getReorderNextDate() {
        return reorderNextDate;
    }

    public void setReorderNextDate(Date reorderNextDate) {
        this.reorderNextDate = reorderNextDate;
    }
    
    public Long getMarketAreaId() {
        return marketAreaId;
    }
    
    public void setMarketAreaId(Long marketAreaId) {
        this.marketAreaId = marketAreaId;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }
    
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Store getStore() {
        return store;
    }
    
    public void setStore(Store store) {
        this.store = store;
    }
    
    public ProductSku getProductSku() {
        return productSku;
    }
    
    public void setProductSku(ProductSku productSku) {
        this.productSku = productSku;
    }
    
    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dateCreate == null) ? 0 : dateCreate.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object sourceObj) {
        Object obj = deproxy(sourceObj);
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductSkuStoreStock other = (ProductSkuStoreStock) obj;
        if (dateCreate == null) {
            if (other.dateCreate != null)
                return false;
        } else if (!dateCreate.equals(other.dateCreate))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ProductSkuStock [id=" + id + ", version=" + version + ", globalStockQuantity=" + globalStockQuantity + ", reservedStockWharehouse=" + reservedStockWharehouse + ", reservedStockEco="
                + reservedStockEco + ", stockUsedByActiveCart=" + stockUsedByActiveCart + ", reorderQuantityAlert=" + reorderQuantityAlert + ", reorderQuantityTrigger=" + reorderQuantityTrigger
                + ", reorderNextDate=" + reorderNextDate + ", warehouse=" + warehouse + ", productSku=" + productSku + ", dateCreate=" + dateCreate + ", dateUpdate=" + dateUpdate + "]";
    }

}