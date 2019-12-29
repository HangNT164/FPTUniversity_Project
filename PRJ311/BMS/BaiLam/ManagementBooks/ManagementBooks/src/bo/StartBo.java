/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.Locale;

/**
 *
 * @author HangNT
 */
public class StartBo {

    public String getMondayToSunday(int numberInWeek) {
        String s = "";
        switch (numberInWeek) {
            case 2: {
                s = "Monday";
                break;
            }
            case 3: {
                s = "Tuesday";
                break;
            }
            case 4: {
                s = "Wednesday";
                break;
            }
            case 5: {
                s = "Thursday";
                break;
            }
            case 6: {
                s = "Friday";
                break;
            }
            case 7: {
                s = "Saturday";
                break;
            }
            case 1: {
                s = "Sunday";
                break;
            }
        }
        return s;
    }

    public Locale choiceLanguage(AuBoPuTiAuBo auBoPuTiAuBo) {
        Locale locale = null;
        int choice = auBoPuTiAuBo.choiceFunction("Question", "Do you want to choice language?", "English", "Vietnamese");
        switch (choice) {
            case 0: {
                locale = new Locale("en", "US");
                break;
            }
            case 1: {
                locale = new Locale("vi", "VN");
                break;
            }
        }
        return locale;
    }

}
