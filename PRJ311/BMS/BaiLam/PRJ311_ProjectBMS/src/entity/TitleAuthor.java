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
public class TitleAuthor {
    private String authorID;
    private String titleID;
    private int authorOrd;

    public TitleAuthor(String authorID, String titleID, int authorOrd) {
        this.authorID = authorID;
        this.titleID = titleID;
        this.authorOrd = authorOrd;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getTitleID() {
        return titleID;
    }

    public void setTitleID(String titleID) {
        this.titleID = titleID;
    }

    public int getAuthorOrd() {
        return authorOrd;
    }

    public void setAuthorOrd(int authorOrd) {
        this.authorOrd = authorOrd;
    }
    
    
}
