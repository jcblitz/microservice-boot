package net.blitzstein.microservices.domain;

/**
 * Created by jared on 1/27/17.
 */
public class Asset {
    private String name, description, countryOfOrigin;
    private long msrp, purchasePrice;

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }


    public Asset(String name, String description, long msrp, long purchasePrice, String countryOfOrigin) {
        this.name = name;
        this.description = description;
        this.msrp = msrp;
        this.purchasePrice = purchasePrice;
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getMsrp() {
        return msrp;
    }

    public long getPurchasePrice() {
        return purchasePrice;
    }
}
