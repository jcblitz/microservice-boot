package net.blitzstein.microservices.service;

import net.blitzstein.microservices.domain.Asset;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by jared on 1/27/17.
 */
public class ResidualValueCalculatorTest {
    /*
        Assets from the US have a 10% premium
     */
    @Test
    public void forAssetFromUSA() throws Exception {
        Asset asset = mock(Asset.class);
        when(asset.getCountryOfOrigin()).thenReturn("USA");
        when(asset.getMsrp()).thenReturn(10000L);
        ResidualValueCalculator residualValueCalculator = new ResidualValueCalculator();
        long value = residualValueCalculator.forAsset(asset, 24);
        assertEquals(8800, value);

    }
    /*
        Assets from the US are never worthless!
     */
    @Test
    public void worthlessAssetOverTimeUSA() throws Exception {
        Asset asset = mock(Asset.class);
        when(asset.getCountryOfOrigin()).thenReturn("USA");
        when(asset.getMsrp()).thenReturn(10000L);
        ResidualValueCalculator residualValueCalculator = new ResidualValueCalculator();
        long value = residualValueCalculator.forAsset(asset, 120);
        assertEquals(100, value);

    }
    @Test
    public void forAssetFromOutsideCountry() throws Exception {
        Asset asset = mock(Asset.class);
        when(asset.getCountryOfOrigin()).thenReturn("CHINA");
        when(asset.getMsrp()).thenReturn(10000L);
        ResidualValueCalculator residualValueCalculator = new ResidualValueCalculator();
        long value = residualValueCalculator.forAsset(asset, 24);
        assertEquals(8000, value);

    }

    @Test
    public void worthlessAssetOverTimeNonUSA() throws Exception {
        Asset asset = mock(Asset.class);
        when(asset.getCountryOfOrigin()).thenReturn("CANADA");
        when(asset.getMsrp()).thenReturn(10000L);
        ResidualValueCalculator residualValueCalculator = new ResidualValueCalculator();
        long value = residualValueCalculator.forAsset(asset, 120);
        assertEquals(0, value);

    }
}