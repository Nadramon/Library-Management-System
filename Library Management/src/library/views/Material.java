package library.views;

import java.util.ArrayList;

public class Material {
    String type;
    String name;
    
    boolean isAReferenceMaterial = false;
    
    int countAvailable;
    int totalInLibrary;
    
    ArrayList<Integer> outMaterials;
    ArrayList<Integer> availableMaterials;
    
    public Material(String objType, String n, boolean isRef) {
        type = objType;
        name = n;
        outMaterials = new ArrayList<Integer>();
        availableMaterials = new ArrayList<Integer>();
        isAReferenceMaterial = isRef;
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
    
    public void removeItems(int amount) {
        if (amount > 0 && amount <= totalInLibrary) {
            totalInLibrary -= amount;
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
