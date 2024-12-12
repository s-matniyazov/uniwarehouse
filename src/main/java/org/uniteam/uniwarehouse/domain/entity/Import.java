package org.uniteam.uniwarehouse.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.uniteam.uniwarehouse.domain.entity.base.BaseIdEntity;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 28 нояб. 2024
 **/
@Entity(name = "imports")
public class Import extends BaseIdEntity {
    @Column(name = "import_date")
    private Timestamp importDate;

    private String sender;
    private String receiver;

    @OneToMany(mappedBy = "importP", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ImportProduct> products;

    @ManyToOne(optional = false)
    private Warehouse warehouse;

    public Import() {}

    public Import(Timestamp importDate, String sender, String receiver, Warehouse warehouse) {
        this.importDate = importDate;
        this.sender = sender;
        this.receiver = receiver;
        this.warehouse = warehouse;
    }

    public Timestamp getImportDate() {
        return importDate;
    }

    public void setImportDate(Timestamp importDate) {
        this.importDate = importDate;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public List<ImportProduct> getProducts() {
        return products;
    }

    public void setProducts(List<ImportProduct> products) {
        this.products = products;
    }
}
