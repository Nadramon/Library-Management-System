package library.views;

import java.util.ArrayList;

public class Material {
    private String type;
    private String name;
    
    private boolean isAReferenceMaterial = false;
    
    private int countAvailable;
    private int totalInLibrary;
    
    private ArrayList<Integer> outMaterials;
    private ArrayList<Integer> availableMaterials;
    
    public Material(String objType, String n, boolean isRef) {
        type = objType;
        name = n;
        outMaterials = new ArrayList<Integer>();
        availableMaterials = new ArrayList<Integer>();
        isAReferenceMaterial = isRef;
        totalInLibrary = 0;
        countAvailable = 0;
    }

    public Material(String objType, String n, boolean isRef, int id) {
        this(objType, n, isRef);
        totalInLibrary = 1;
        countAvailable = 1;
        availableMaterials.add(id);
    }
    
    /**
     * @return the isAReferenceMaterial
     */
    public boolean isAReferenceMaterial() {
        return isAReferenceMaterial;
    }

    /**
     * @return the outMaterials
     */
    public ArrayList<Integer> getOutMaterials() {
        return outMaterials;
    }

    /**
     * @return the availableMaterials
     */
    public ArrayList<Integer> getAvailableMaterials() {
        return availableMaterials;
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
        }
    }
    
    public void addItem(int id) {
        totalInLibrary += 1;
        availableMaterials.add(id);
        countAvailable += 1;
    }
    
    public void addOrderedItem(int id) {
        totalInLibrary += 1;
        outMaterials.add(id);
    }
    
    public void removeItem(int id) {
        if (availableMaterials.contains(id)) {
            availableMaterials.remove(id);
            totalInLibrary -= 1;
            countAvailable -= 1;
        }
    }
    
    public boolean checkoutItem(int id) {
        if (availableMaterials.contains(id) && !isAReferenceMaterial) {
            countAvailable -= 1;
            availableMaterials.remove(id);
            outMaterials.add(id);
            return true;
        }
        return false;
    }
    
    public boolean returnMaterial(int id) {
        if (outMaterials.contains(id)) {
            countAvailable += 1;
            outMaterials.remove(id);
            availableMaterials.add(id);
            return true;
        }
        return false;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the countAvailable
     */
    public int getCountAvailable() {
        return countAvailable;
    }
}
