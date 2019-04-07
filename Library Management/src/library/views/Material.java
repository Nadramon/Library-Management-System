package library.views;

import java.util.ArrayList;

public class Material {
    private String type;
    private String name;
    private int id;
    
    private boolean isAReferenceMaterial = false;
    
    private int countAvailable;
    private int totalInLibrary;
    
    
    public Material(String objType, String n, boolean isRef, int ID) {
        type = objType;
        name = n;
        isAReferenceMaterial = isRef;
        id = ID;
        totalInLibrary = 1;
        countAvailable = 1;
    }

    
    /**
     * @return the isAReferenceMaterial
     */
    public boolean isAReferenceMaterial() {
        return isAReferenceMaterial;
    }


    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the total number of the material type available in the librarian
     */
    public int getTotalInLibrary() {
        return totalInLibrary;
    }

    /**
     * @param totalInLibrary the totalInLibrary to set
     */
    public void addItems(int increaseAmount) {
        if (increaseAmount > 0) {
            totalInLibrary += increaseAmount;
            countAvailable += increaseAmount;
        }
    }
    
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    
    /**
     * @return the id
     */
    public int getID() {
        return id;
    }


    /**
     * @return the countAvailable
     */
    public int getCountAvailable() {
        return countAvailable;
    }
    
    /**
     * @return the countAvailable
     */
    public void setCountAvailable(int i) {
        countAvailable += i;
    }
}