
jQuery.validator.addMethod("noSpace", function (value, element) {
    return value == '' || value.trim().length != 0;
}, "No space please and don't leave it empty");
jQuery.validator.addMethod("customEmail", function (value, element) {
    return this.optional(element) || /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(value);
}, "Please enter valid email address!");
jQuery.validator.addMethod("customPassword", function (value, element) {
    return this.optional(element) || /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,15}$/.test(value);
}, "PLease enter password 8 to 15 characters which contain at least one numeric digit and a special character");
jQuery.validator.addMethod("customPhone", function (value, element) {
    return this.optional(element) || /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/.test(value);
}, "PLease enter phone right ");
$.validator.addMethod("alphanumeric", function (value, element) {
    return this.optional(element) || /^\w+$/i.test(value);
}, "Letters, numbers, and underscores only please");
var $registrationForm = $('#registration');
if ($registrationForm.length) {
    $registrationForm.validate({
        rules: {
            username: {
                required: true,
                alphanumeric: true
            },
            email: {
                required: true,
                customEmail: true
            },
            password: {
                required: true,
                customPassword: true
            },
            confirm: {
                required: true,
                equalTo: '#password'
            },
            mobile: {
                required: true,
                customPhone: true
            },
            gender: {
                required: true
            },
            address: {
                required: true
            }
        },
        messages: {
            username: {
                required: 'Please enter username!'
            },
            email: {
                required: 'Please enter email!',
                email: 'Please enter valid email!'
            },
            password: {
                required: 'Please enter password!'
            },
            confirm: {
                required: 'Please enter confirm password!',
                equalTo: 'Please enter same password!'
            },
            phone: {
                required: 'Please enter phone!'
            },
            address: {
                required: 'Please enter address!'
            }
        },
        errorPlacement: function (error, element)
        {
            if (element.is(":radio"))
            {
                error.appendTo(element.parents('.gender'));
            } else
            {
                error.insertAfter(element);
            }
        }
    });
}