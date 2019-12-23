$(document).ready(function () {
    $("#register").on('click', function () {
        let user;
        let password = $("#password").val();
        let confirmPassword = $("#confirm_password").val();
        if (password != confirmPassword){
            alert("Passwords do not match.");
            return false;
        } else {
            user = {
                "email": $("#email").val(),
                "password": password,
            };
        }

        $.ajax({
            url: "/api/v1/user/create",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(user),
            error: function () {
                // window.component.alert.show("error", "Error", 2000);
                console.log("ERROR");
            },
            success: function (data) {
                console.log(data);
                alert("Đăng ký thành công!")
                window.location.href = "/trang-chu";
            }
        })
    })
})