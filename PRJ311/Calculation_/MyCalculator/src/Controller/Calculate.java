package Controller;

import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HangNT
 */
public class Calculate {

    private BigDecimal firstNum;
    private BigDecimal secondNum;
    private final JTextField text;
    private boolean process ;
    private int operator = -1;
    private BigDecimal memory;
    private boolean reset;

    public Calculate(JTextField text) {
        this.text = text;
        operator = -1;
        memory = new BigDecimal("0");
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }
    /**
     * 
     * @param btn
     * 
     * 
     */
    public void pressNumber(JButton btn) {
        BigDecimal temp = new BigDecimal("0");
        String value = btn.getText();
        //when process or reset true 
        if (process || reset ) {
            text.setText("0");
            process = false;
            reset = false;
        }
        temp = new BigDecimal(text.getText() + value);
        text.setText(temp + "");
    }
    
    public void pressDot() {
        if (process || reset) {
            text.setText("0");
            process = false;
            reset = false;
        }
        //if user enter number first and not contain (.)
        if (!text.getText().contains(".")) {
            text.setText(text.getText() + ".");
        //if user enter (.) first and not contain number
        } else {
            text.setText("0");
            text.setText(text.getText() + ".");
        }
    }
/**
 * 
 * @return value (BigDecimal)
 * this function get value and convert String -> BigDecimal
 */
    public BigDecimal getValue() {
        String value = text.getText();
        BigDecimal temp = new BigDecimal(value);
        return temp;
    }
    public void pressClear() {
        firstNum = new BigDecimal("0");
        secondNum = new BigDecimal("0");
        operator = -1;
    }
    public void calculate() {
        try {
            if (process==false) {
                if (operator == -1) {
                    firstNum = getValue();
                } else {
                    secondNum = getValue();
                    switch (operator) {
                        case 1:
                            firstNum = firstNum.add(secondNum);
                            break;
                        case 2:
                            firstNum = firstNum.subtract(secondNum);
                            break;
                        case 3:
                            firstNum = firstNum.multiply(secondNum);
                            break;
                        case 4:
                            double result = firstNum.doubleValue() / secondNum.doubleValue();
                            String abc = result+"";
                            if (abc.endsWith(".0")) {
                                abc = abc.replace(".0", "");
                            }
                            firstNum = new BigDecimal(abc + "");
                            break;
                    }
                }
                
                text.setText(firstNum + "");
                //set process = true to when user enter first number then enter second
                //number to avoid case add a string
                process = true;
            }
        } catch (Exception e) {
            reset = true;
            text.setText("ERROR");
        }
    }
    /**
     * check results get from screen 
     * 
     */
    public void pressResult() {
        //if text in screen not equals ERROR
        if (!text.getText().equals("ERROR")) {
            //call fuction and operator = -1 (press =)
            calculate();
            operator = -1;
        // when text in screen equals ERROR
        } else {
            
            text.setText(firstNum + "");
        }
    }
    /**
     * check and set when user press (+/-)
     */
    public void pressNegate() {
        try {
            pressResult();
            text.setText(getValue().negate() + "");
            process = false;
        } catch (Exception e) {
            text.setText("ERROR");
        }
        reset = true;
    }
    /**
     * this function to calculator square of number
     */
    public void pressSqrt() {
        try {
            pressResult();
            BigDecimal result = getValue();
            //if number get from screen >=0
            if (result.doubleValue() >= 0) {
                String display = Math.sqrt(result.doubleValue()) + "";
                //process display, if results end .0(3.0) will be replace is 3
                if (display.endsWith(".0")) {
                    display = display.replace(".0", "");
                }
                text.setText(display);
                process = false;
            //if number get from screen <0 is ERROR
            } else {
                text.setText("ERROR");
            }
        } catch (Exception e) {
            text.setText("ERROR");
        }
        //set reset = true to can press number next
        reset = true;
    }
    /**
     * this function to calculator percent of number when user enter from keybroad
     */
    public void pressPercent() {
        try {
            pressResult();
            text.setText((getValue().doubleValue()) / 100 + "");
            process = false;
        } catch (Exception e) {
            text.setText("ERROR");
        }
        reset = true;
    }
     /**
     * this function to invert of number when user enter from keybroad
     */
    public void pressInvert() {
        try {
            pressResult();
            double result = getValue().doubleValue();
            //if results get from screen different 0 when process
            if (result != 0) {
                text.setText((1 / result) + "");
                process = false;
            //when result == 0 will show ERROR
            } else {
                text.setText("ERROR");
            }
        } catch (Exception e) {
            text.setText("ERROR");
        }
        reset = true;
    }

    //MC : xóa bỏ trong bộ nhớ xét memory =0
    //MR: lấy ra giá trị trong bộ nhớ 
    //ấn số: => M+ : lưu giá trị đó vào memory
    //ấn số: => M- : lưu giá trị đối của nó vào memory
    //Nhấn M+ / M- => MR đổi màu
    //Nhấn MC: => MR về màu cũ
    public void pressMC() {
        memory = new BigDecimal("0");
    }

    public void pressMR() {
        text.setText(memory + "");
    }

    public void pressMAdd() {
        try {
            memory = memory.add(getValue());
            process = false;
        } catch (Exception e) {
            text.setText("ERROR");
        }
        reset = true;
    }

    public void pressMSub() {
        try {
            memory = memory.add(getValue().negate());
            process = false;
        } catch (Exception e) {
            text.setText("ERROR");
        }
        reset = true;
    }
}
