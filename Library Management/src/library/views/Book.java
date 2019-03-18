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
    
    public Book(String objType, String t, String auth, boolean isRef) {
        super(objType, "", isRef);
        author = auth;
        title = t;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getTitle() {return title;}
    
}
