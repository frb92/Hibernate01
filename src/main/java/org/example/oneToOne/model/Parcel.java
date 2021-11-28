package org.example.oneToOne.model;

import javax.persistence.*;

@Entity
@Table(name="parcels")
public class Parcel {
    public Parcel() {
    }

    public Parcel(String warehause, int price) {
        this.warehause = warehause;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "id=" + id +
                ", parcelAddress=" + parcelAddress +
                ", warehause='" + warehause + '\'' +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ParcelAddress getParcelAddress() {
        return parcelAddress;
    }

    public void setParcelAddress(ParcelAddress parcelAddress) {
        this.parcelAddress = parcelAddress;
    }

    public String getWarehause() {
        return warehause;
    }

    public void setWarehause(String warehause) {
        this.warehause = warehause;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private ParcelAddress parcelAddress;

    private String warehause;
    private int price;
}
