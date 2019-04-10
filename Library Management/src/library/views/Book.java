/**
 * 
 */
package library.views;

/**
 * @author Jess
 *
 */
public class Book extends Material {
    String author;
    String title;
    
    public Book(String objType, String t, String auth, boolean isRef, int ID) {
        super(objType, t, isRef, ID);
        author = auth;
        title = t;
    }
    
    public Book(String objType, String t, String auth, boolean isRef, int ID, int tot, int avail) {
        super(objType, t, isRef, ID, tot, avail);
        author = auth;
        title = t;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getTitle() {return title;}
    
}