$(document).ready(function () {
    $('#form_login').submit(function () {
        return false;
    });

    $('input').on("keypress", function (e) {
        if (e.keyCode === 13) {
            $("#confirm_login").trigger('click');
        }
    });

    $("#confirm_login").on('click', function () {
        var email = $("#email").val();
        var password = $("#password").val();
        if (email === null || email === "" || email.trim() === "") {
            window.component.alert.show("error", "Please input email", 2000);
            return;
        }
        if (password === null || password === "" || password.trim() === "") {
            window.component.alert.show("error", "Please input password", 2000);
            return;
        }
        var data = {
            email: email,
            password: password
        };
        console.log(email);
        console.log(password);

        $.ajax({
            type: 'GET',
            url: "/api/v1/login/log",
            data: data,
            success: function (response) {
                console.log(response);
                if (response.code === 200) {
                    localStorage.setItem("user", JSON.stringify(response.data));
                    window.location.href = "/";
                } else {
                    alert(response.message)
                }
            },
            error: function (error) {
                console.log(error);
                window.component.alert.show("error", "email or password is incorrect!!!", 2000);
                setTimeout(function () {
                    $("#confirm_login").prop("disabled", false);
                }, 1000)
            }
        });
    });
});
