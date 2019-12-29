/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
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
    private int totalPrice;
    private int statusOrderDetailId;
    private String note;
    private String createDate;
    private String shipDate;
    private String payment;
    private boolean deleted;

    public String getNameCustomer(List<CustomerInfo> list) {
        for (CustomerInfo customerInfo : list) {
            if (customerInfo.getId() == customerInfoId) {
                return customerInfo.getName();
            }
        }
        return null;
    }

    public String getAddress(List<CustomerInfo> list) {
        for (CustomerInfo customerInfo : list) {
            if (customerInfo.getId() == customerInfoId) {
                return customerInfo.getAddress();
            }
        }
        return null;
    }
}
