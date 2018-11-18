$(document).ready(function () {
    $(".alert").fadeTo(3500, 500).slideUp(500, function () {
        $(".alert").slideUp(500);
    });
});