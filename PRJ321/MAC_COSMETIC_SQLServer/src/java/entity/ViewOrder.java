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
public class ViewOrder {
    private int orderID;
    private String imageLink;
    private String productName;
    private String customerInofr;
    private String customerAddress;
    private int total;
    private String createDate;
    private String payment;
    private String note;
}
