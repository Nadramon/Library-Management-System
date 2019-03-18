/**
 * 
 */
package library.views;

import java.util.ArrayList;

/**
 * @author Jess
 *
 */
public class Resources {
    ArrayList<Material> onOrder;
    ArrayList<Material> pendingApproval;
    ArrayList<Material> inLibrary;
    
    public void orderMaterial(String n, String type, int numToOrder, boolean isRef) {
        for (Material mat: inLibrary) {
            if (mat.getName().equals(n) && mat.getType().equals(type)&& mat.getIsAReference() == isRef) {
                mat.addItems(numToOrder);
            }
        }
        Material newMat = new Material(n, type, isRef);
        newMat.addItems(numToOrder);
        pendingApproval.add(newMat);
    }
    
    public void approveOrder(Material toApprove) {
        
    }
}
