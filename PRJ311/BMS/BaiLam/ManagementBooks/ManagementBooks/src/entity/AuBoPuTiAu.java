/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author HangNT
 */
public class AuBoPuTiAu {

    private String title_id;
    private String title;
    private String publishers;
    private String authors;
    private String notes;
    private String pub_id;
    private String au_id;

    public AuBoPuTiAu() {
    }

    public AuBoPuTiAu(String title_id, String title, String publishers, String authors, String notes) {
        this.title_id = title_id;
        this.title = title;
        this.publishers = publishers;
        this.authors = authors;
        this.notes = notes;
    }

    public AuBoPuTiAu(String title_id, String title, String publishers, String authors, String notes, String pub_id, String au_id) {
        this.title_id = title_id;
        this.title = title;
        this.publishers = publishers;
        this.authors = authors;
        this.notes = notes;
        this.pub_id = pub_id;
        this.au_id = au_id;
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPub_id() {
        return pub_id;
    }

    public void setPub_id(String pub_id) {
        this.pub_id = pub_id;
    }

    public String getAu_id() {
        return au_id;
    }

    public void setAu_id(String au_id) {
        this.au_id = au_id;
    }

    public String getTitle_id() {
        return title_id;
    }

    public void setTitle_id(String title_id) {
        this.title_id = title_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object[] toDataRow() {
        return new Object[]{getTitle_id(), getTitle(), getPublishers(), getAuthors(), getNotes()};
    }

    @Override
    public String toString() {
        return "AuBoPuTiAu{" + "title_id=" + title_id + ", title=" + title + ", publishers=" + publishers + ", authors=" + authors + ", notes=" + notes + ", pub_id=" + pub_id + ", au_id=" + au_id + '}';
    }
}
