import java.util.ArrayList;

/**
 * CircleSapienSystem class represents a system of CircleSapien Objects
 */
public class CircleSapienSystem {
    private ArrayList<CircleSapien> circleSapienSystem;

    /**
     * CircleSapienSystem constructor creates and array list to store sapien objects
     */
    public CircleSapienSystem() {
        this.circleSapienSystem = new ArrayList<CircleSapien>();
    }

    /**
     * get size of the system
     * 
     * @return size
     */
    public int getSize() {
        return circleSapienSystem.size();
    }

    /**
     * add object to system
     * 
     * @param c object
     */
    public void addSapien(CircleSapien c) {
        circleSapienSystem.add(c);
    }

    /**
     * remove object at index
     * 
     * @param index
     */
    public void removeSapien(int index) {
        circleSapienSystem.remove(index);
    }

    /**
     * get object at index
     * 
     * @param index
     * @return
     */
    public CircleSapien getSapien(int index) {
        return circleSapienSystem.get(index);
    }

    /**
     * get index of object passed in
     * 
     * @param c
     * @return index
     */
    public int getIndexOf(CircleSapien c) {
        return circleSapienSystem.indexOf(c);
    }

    /**
     * set object in array at passed in index
     * 
     * @param index
     * @param c
     */
    public void setSapienAt(int index, CircleSapien c) {
        circleSapienSystem.set(index, c);
    }
}
