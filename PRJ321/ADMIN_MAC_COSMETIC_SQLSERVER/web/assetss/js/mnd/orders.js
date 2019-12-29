/*!
 * fms js
 */

$(document).ready(function () {

    $(window).resize(function () {
        if ($("#orders").width() > 1999) {
            $("#scroll-x").removeClass("box");
        } else {
            $("#scroll-x").addClass("box");
        }
    });

    $(window).on("load", function () {
        if ($("#orders").width() > 1999) {
            $("#scroll-x").removeClass("box");
        }
    });

});
