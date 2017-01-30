package net.blitzstein.microservices.domain;

/**
 * Created by jared on 1/27/17.
 */
public class ResidualCalculation {
    private Asset asset;
    private long residualValue;

    public ResidualCalculation(Asset asset, long residualValue) {
        this.asset = asset;
        this.residualValue = residualValue;
    }

    public Asset getAsset() {
        return asset;
    }

    public long getResidualValue() {
        return residualValue;
    }
}
