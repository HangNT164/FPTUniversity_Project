
jQuery.validator.addMethod("noSpace", function (value, element) {
    return value === '' || value.trim().length != 0;
}, "No space please and don't leave it empty");
jQuery.validator.addMethod("customPayment", function (value, element) {
    return this.optional(element) || /^(Cash)|(ATM card)|(Momo)()$/.test(value);
}, "Choice one of three Cash,ATM Card,Momo");
jQuery.validator.addMethod("customPhone", function (value, element) {
    return this.optional(element) || /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/.test(value);
}, "PLease enter phone right ");

$.validator.addMethod("alphanumeric", function (value, element) {
    return this.optional(element) || /^\w+$/i.test(value);
}, "Letters, numbers, and underscores only please");
var $checkoutForm = $('#checkout');
if ($checkoutForm.length) {
    $checkoutForm.validate({
        rules: {
            Name: {
                required: true,
                alphanumeric: true
            },
            Mobile: {
                required: true,
                customPhone: true
            },
            Address: {
                required: true
            },
            Payment: {
                required: true,
                customPayment: true
            }
        },
        messages: {
            Name: {
                required: 'Please enter username!'
            },
            Mobile: {
                required: 'Please enter phone!'
            },
            Address: {
                required: 'Please enter address!'
            },
            Payment: {
                required: 'Please enter payment!'
            }
        },
    });
}