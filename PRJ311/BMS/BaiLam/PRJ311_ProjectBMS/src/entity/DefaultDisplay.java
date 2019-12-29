/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author langt
 */
public class DefaultDisplay {
    private final String titleID;
    private final String title;
    private final String publisher;
    private final String author;
    private final String notes;

    public DefaultDisplay(String titleID, String title, String publisher, String author, String notes) {
        this.titleID = titleID;
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.notes = notes;
    }

    public String getTitleID() {
        return titleID;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor() {
        return author;
    }

    public String getNotes() {
        return notes;
    }
    
    
    
   public Object[] toDataRow(){
        return new Object[]{titleID, title, publisher, author, notes};
    }
    
}
