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
public class Order {

    private int id;
    private int accountDetailId;
    private int customerInfoId;
    private int statusOrderDetailId;
    private int totalPrice;
    private String note;
    private String createDate;
    private String shipDate;
    private String payment;
    private boolean deleted;
}
