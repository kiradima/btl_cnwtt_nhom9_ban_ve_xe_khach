/**
 *
 */
window.component = {};
window.component.alert = {
    show: function (type, message, interval) {
        if (type === "error") {
            $("#alert").removeClass("alert-success");
            $("#alert").addClass("alert-danger");
            $("#alert .error-icon").removeClass("hidden");
            $("#alert .success-icon").addClass("hidden");
        } else if (type === "success") {
            $("#alert").removeClass("alert-danger");
            $("#alert").addClass("alert-success");
            $("#alert .error-icon").addClass("hidden");
            $("#alert .success-icon").removeClass("hidden");
        }
        $("#alert").removeClass("hidden");
        $("#alert_message").html(message);
        $("#alert").animate({
            top: "50px"
        }, "slow");

        setTimeout(function () {
            $("#alert").animate({
                top: "-150px"
            }, "slow");
        }, interval);
    }
};

window.loader = {
    show: function () {
        $("#loader").removeClass("hidden");
    },
    hide: function () {
        $("#loader").addClass("hidden");
    }

};