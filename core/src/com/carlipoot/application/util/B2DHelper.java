package com.carlipoot.application.util;

/**
 * Helper class for all Box2D needs.
 * @author Carlipoot
 */
public class B2DHelper {

    /**
     * Conversion units from pixels to meters.
     */
    public static final float PIXELSPERMETER = 100;

    /**
     * Converts pixels to meters.
     * @param pixels the number of pixels.
     * @return the converted number of meters.
     */
    public static float toMeters(int pixels) {
        return pixels / PIXELSPERMETER;
    }

    /**
     * Converts meters to pixels.
     * @param meters the number of meters.
     * @return the converted number of pixels.
     */
    public static int toPixels(float meters) {
        return (int)(meters * PIXELSPERMETER);
    }
}
