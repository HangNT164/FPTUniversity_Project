/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var $registrationForm = $('#loginForm');
if ($registrationForm.length) {
    $registrationForm.validate({
        rules: {           
            password: {
                required: true
            }     
        },
        messages: {                     
            password: {
                required: 'Please enter password!'
            }         
        }      
    });
}

