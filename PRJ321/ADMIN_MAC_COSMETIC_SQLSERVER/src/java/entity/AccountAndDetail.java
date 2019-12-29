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
public class AccountAndDetail {
    private int accountID;
    private int accountDetailID;
    private String name;
    private String email;
    private String phone;
    private int gender;
    private String address;
    private String createDate;
}
