$(document).ready(function () {
    $('#form_register').submit(function () {
        console.log("vào");
        return false;
    });

    $("#button_register").on('click', function () {
        let user;
        let password = $("#password").val();
        console.log(password);
        let confirmPassword = $("#confirm_password").val();
        console.log(confirmPassword);
        if (password !== confirmPassword) {
            alert("Passwords do not match.");
            return false;
        } else {
            user = {
                "email": $("#email").val(),
                "password": password,
                "role": 0,
                "realName": $('#real_name').val(),
                "phone": $('#phone').val()
            }
        }

        $.ajax({
            url: "/api/v1/user/create",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(user),
            error: function (error) {
                alert("Đăng ký không thành công!");
                console.log(error);
            },
            success: function (data) {
                console.log(data);
                localStorage.setItem("user", JSON.stringify(data));
                alert("Đăng ký thành công!");
                window.location.href = "/";
            }
        })
    })
});