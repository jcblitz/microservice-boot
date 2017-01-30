package net.blitzstein.microservices.service;

import net.blitzstein.microservices.domain.Asset;
import org.springframework.stereotype.Service;

/**
 * Created by jared on 1/26/17.
 */
@Service
public class ResidualValueCalculator {

    public long forAsset(Asset asset, int leaseTerm) {

        int months = leaseTerm;
        int years = months / 12;
        int remainingMonths = months % 12;

        long residualValue = 0;

        long basePrice = asset.getMsrp();

        if (years >= 10) {
            // worthless after 10 years
            residualValue = 0;
        } else {
            residualValue = (long)(basePrice - (basePrice * (years*.1)));
        }

        residualValue = applyCountryRule(residualValue, asset);

        return residualValue;

        /*
        if (asset.getCountryOfOrigin() == "USA") {
            return asset.getPurchasePrice() + 1;
        } else {
            return asset.getPurchasePrice();
        }
        */
    }

    private long applyCountryRule(long residualValue, Asset asset) {
        if (asset.getCountryOfOrigin() == "USA") {
           if (residualValue < 100) {
               return 100L;
           } else {
               return (long)(residualValue + (residualValue * .1));
           }
        } else {
            return residualValue;
        }
    }
}
