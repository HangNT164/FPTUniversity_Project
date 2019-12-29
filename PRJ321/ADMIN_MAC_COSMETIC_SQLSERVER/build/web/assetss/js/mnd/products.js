/*!
 * fms js
 */

$(document).ready(function () {

    $(window).resize(function () {
        if ($("#products").width() > 1637) {
            $("#scroll-x").removeClass("box");
        } else {
            $("#scroll-x").addClass("box");
        }
    });

    $(window).on("load", function () {
        if ($("#products").width() > 1637) {
            $("#scroll-x").removeClass("box");
        }
    });

});
