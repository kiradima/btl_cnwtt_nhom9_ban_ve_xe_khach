$(document).ready(function () {
    $('input').on("keypress", function (e) {
        if (e.keyCode === 13) {
            $("#confirm_login").trigger('click');
        }
    });

    $("#confirm_login").on('click', function () {
        var username = $("#username").val();
        var password = $("#password").val();

        if (username === null || username === "" || username.trim() === "") {
            window.component.alert.show("error", "Please input email", 2000);
            return;
        }

        if (password === null || password === "" || password.trim() === "") {
            window.component.alert.show("error", "Please input password", 2000);
            return;
        }

        // $("#confirm_login").prop("disabled", true);

        var data = {
            username: username,
            password: password
        };

        $.ajax({
            type: 'POST',
            url: "/api/v1/user/login",
            data: data,
            success: function (response) {
                console.log(response);
                if (response.code === 200) {
                    window.location.href = "/";
                } else {
                    alert(response.message)
                }
            },
            error: function (error) {
                console.log(error);
                window.component.alert.show("error", "Username or password is incorrect!!!", 2000);
                setTimeout(function () {
                    $("#confirm_login").prop("disabled", false);
                }, 1000)
            }
        });
    })
})