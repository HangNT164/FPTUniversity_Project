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
public class Books {
    private String title_id;
    private String title;
    private String pub_id;
    private String notes;
    private String username;

    public Books() {
    }

    public Books(String title, String pub_id, String notes, String username) {
        this.title = title;
        this.pub_id = pub_id;
        this.notes = notes;
        this.username = username;
    }

    public Books(String title_id, String title, String pub_id, String notes, String username) {
        this.title_id = title_id;
        this.title = title;
        this.pub_id = pub_id;
        this.notes = notes;
        this.username = username;
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

    public String getPub_id() {
        return pub_id;
    }

    public void setPub_id(String pub_id) {
        this.pub_id = pub_id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
//    // ham chup quan he
//    public List<Publishers> booksInfor() {
//        try {
//            List<Publishers> members = new PublishersDao().getAll(); // select all
//            List<Publishers> m = new ArrayList<>();
//            for (Publishers x : members) {
//                // neu id= thi lay
//                if (x.getPub_id().equals(pub_id)) {
//                    m.add(x);
//                }
//            }
//            return m;
//        } catch (Exception ex) {
//            ex.printStackTrace(System.out);
//        }
//        return null;
//    }

    @Override
    public String toString() {
        return "Books{" + "title_id=" + title_id + ", title=" + title + ", pub_id=" + pub_id + ", notes=" + notes + ", username=" + username + '}';
    }
    
}
