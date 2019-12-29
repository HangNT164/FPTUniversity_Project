/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
jQuery.validator.addMethod("customPassword", function (value, element) {
    return this.optional(element) || /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,15}$/.test(value);
}, "PLease enter password 8 to 15 characters which contain at least one numeric digit and a special character");

var $changeForm = $('#changePasswordID');
if ($changeForm.length) {
    $changeForm.validate({
        rules: { 
            oldpass:{
                required:true,
            },        
            newpass: {
                required: true,
                customPassword: true
            },
            cfnewpass: {
                required: true,
                equalTo: '#password'
            }
        },
        messages: {
            oldpass:{
                required: 'Please enter password!'
            },
            newpass: {
                required: 'Please enter new password!'
            },
            cfnewpass: {
                required: 'Please enter confirm new password!',
                equalTo: 'Please enter same new password!'
            }        
        }       
    });
}