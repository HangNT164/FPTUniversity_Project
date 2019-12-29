/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.RoleDao;
import entity.Role;

/**
 *
 * @author HangNT
 */
public class ProcessRoleForAccount {

    public static String getRoleName(String a) {
        Role status = new RoleDao().getOneByAccountID(a);
        return status.getRoleName();
    }
}
