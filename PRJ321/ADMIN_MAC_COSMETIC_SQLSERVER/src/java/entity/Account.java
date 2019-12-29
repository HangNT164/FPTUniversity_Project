/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import dao.AccountDao;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import util.ProcessRoleForAccount;

/**
 *
 * @author HangNT
 */
@Builder
@Getter
@Setter
@ToString
public class Account {

    private int id;
    private int accountDetalId;
    private int role_id;
    private String email;
    private String password;
    private boolean deleted;
  
    
    
    
    public String getRoleName(){     
        return ProcessRoleForAccount.getRoleName(email);
    }
    

}
