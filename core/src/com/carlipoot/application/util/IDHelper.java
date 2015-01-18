package com.carlipoot.application.util;

/** A simple helper to create IDs.
 * @author Carlipoot */
public class IDHelper {

    private static int id;

    static {
        id = 0;
    }

    /** Gets the next available ID.
     * @return the ID. */
    public static int nextID() {
        return id++;
    }

}
