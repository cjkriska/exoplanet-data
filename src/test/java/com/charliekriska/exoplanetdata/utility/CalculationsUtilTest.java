package com.charliekriska.exoplanetdata.utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationsUtilTest {

    @Test
    public void testCalcCartX() {
        // Sun
        assertEquals(0.0, CalculationsUtil.calcCartX(0.0, 0.0, 0.0), 0.00001);
        // Galactic Center
        assertEquals(0.0, CalculationsUtil.calcCartX(0.0, 0.0, 26000.0), 0.00001);
        // U1 - PSR B1257+12
        assertEquals(370.1915865, CalculationsUtil.calcCartX(75.41367, 311.30973, 1956.936), 0.00001);
        // L1 - Proxima Centauri
        assertEquals(3.054907857, CalculationsUtil.calcCartX(-1.91805, 313.92595, 4.2439092564), 0.00001);
        // U2 - HAT-P-55
        assertEquals(-1131.86768, CalculationsUtil.calcCartX(26.9685, 49.58846, 1667.9226452799999), 0.00001);
        // L2 - HATS-15
        assertEquals(-1389.359279, CalculationsUtil.calcCartX(-33.28171, 26.56133, 3716.7106979999994), 0.00001);
        // U3 - TOI-4329
        assertEquals(-2145.966066, CalculationsUtil.calcCartX(12.8265, 109.78506, 2338.95599968), 0.00001);
        // L3 - WASP-76
        assertEquals(-175.8120794, CalculationsUtil.calcCartX(-57.34698, 149.08514, 634.23969604), 0.00001);
        // U4 - HAT-P-39
        assertEquals(791.9340875, CalculationsUtil.calcCartX(17.44627, 201.4173, 2273.32036624), 0.00001);
        // L4 - WASP-22
        assertEquals(365.4278605, CalculationsUtil.calcCartX(-53.92335, 216.7964, 1036.0410571199998), 0.00001);
    }

    @Test
    public void testCalcCartY() {
        // Sun
        assertEquals(0.0, CalculationsUtil.calcCartY(0.0, 0.0, 0.0), 0.00001);
        // Galactic Center
        assertEquals(26000.0, CalculationsUtil.calcCartY(0.0, 0.0, 26000.0), 0.00001);
        // U1 - PSR B1257+12
        assertEquals(325.3326582, CalculationsUtil.calcCartY(75.41367, 311.30973, 1956.936), 0.00001);
        // L1 - Proxima Centauri
        assertEquals(2.942469595, CalculationsUtil.calcCartY(-1.91805, 313.92595, 4.2439092564), 0.00001);
        // U2 - HAT-P-55
        assertEquals(963.6880613, CalculationsUtil.calcCartY(26.9685, 49.58846, 1667.9226452799999), 0.00001);
        // L2 - HATS-15
        assertEquals(2779.169788, CalculationsUtil.calcCartY(-33.28171, 26.56133, 3716.7106979999994), 0.00001);
        // U3 - TOI-4329
        assertEquals(-771.9632889, CalculationsUtil.calcCartY(12.8265, 109.78506, 2338.95599968), 0.00001);
        // L3 - WASP-76
        assertEquals(-293.5877538, CalculationsUtil.calcCartY(-57.34698, 149.08514, 634.23969604), 0.00001);
        // U4 - HAT-P-39
        assertEquals(-2018.982941, CalculationsUtil.calcCartY(17.44627, 201.4173, 2273.32036624), 0.00001);
        // L4 - WASP-22
        assertEquals(-488.5414958, CalculationsUtil.calcCartY(-53.92335, 216.7964, 1036.0410571199998), 0.00001);
    }

    @Test
    public void testCalcCartZ() {
        // Sun
        assertEquals(0.0, CalculationsUtil.calcCartZ(0.0, 0.0, 0.0), 0.00001);
        // Galactic Center
        assertEquals(0.0, CalculationsUtil.calcCartZ(0.0, 0.0, 26000.0), 0.00001);
        // U1 - PSR B1257+12
        assertEquals(1893.86255, CalculationsUtil.calcCartZ(75.41367, 311.30973, 1956.936), 0.00001);
        // L1 - Proxima Centauri
        assertEquals(-0.1420437933, CalculationsUtil.calcCartZ(-1.91805, 313.92595, 4.2439092564), 0.00001);
        // U2 - HAT-P-55
        assertEquals(756.4038782, CalculationsUtil.calcCartZ(26.9685, 49.58846, 1667.9226452799999), 0.00001);
        // L2 - HATS-15
        assertEquals(-2039.567233, CalculationsUtil.calcCartZ(-33.28171, 26.56133, 3716.7106979999994), 0.00001);
        // U3 - TOI-4329
        assertEquals(519.2470447, CalculationsUtil.calcCartZ(12.8265, 109.78506, 2338.95599968), 0.00001);
        // L3 - WASP-76
        assertEquals(-534.0003142, CalculationsUtil.calcCartZ(-57.34698, 149.08514, 634.23969604), 0.00001);
        // U4 - HAT-P-39
        assertEquals(681.5671449, CalculationsUtil.calcCartZ(17.44627, 201.4173, 2273.32036624), 0.00001);
        // L4 - WASP-22
        assertEquals(-837.3593958, CalculationsUtil.calcCartZ(-53.92335, 216.7964, 1036.0410571199998), 0.00001);
    }

}
