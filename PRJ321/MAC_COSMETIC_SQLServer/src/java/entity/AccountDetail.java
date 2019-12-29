/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author HangNT
 */
@Builder
@Getter
@Setter
@ToString
public class AccountDetail {

    private int id;
    private String name;
    private String mobile;
    private int gender;
    private String address;
    private String createDate;
    private boolean deleted;

    /**
     * Display Gender for user
     *
     * @return gender of user
     */
    public String getDisplayGender() {
        return (gender == 0) ? "Female" : (gender == 1) ? "Male" : "Other";
    }
}
