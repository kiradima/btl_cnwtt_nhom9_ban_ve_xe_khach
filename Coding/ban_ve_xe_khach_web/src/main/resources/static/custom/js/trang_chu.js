$(document).ready(function () {
    $('.datepicker').datepicker({
        showOn: focus,
        format: 'mm/dd/yyyy',
        todayHighlight: true,
        autoclose: true
    });
    $('#start_date').datepicker({
        showOn: focus,
        format: 'mm/dd/yyyy',
        todayHighlight: true,
        autoclose: true
    });

    $(document).on("click", "#btn_payment", function (e) {
        e.preventDefault();
        let user = {
            "id": $('#id').val(),
            "userName": "dsjjkjksfj",
            "password": "1234561234",
            "realName": $('#real_name').val(),
            "phone": $('#phone').val(),
            "role": 1,
        };

        $.ajax({
            url: "/api/v1/user/create",
            type: 'POST',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(user),
            error: function () {
                // window.component.alert.show("error", "Error", 2000);
                console.log("ERROR");
            },
            success: function (data) {
                console.log(data);
                let realName = data.realName;
                let phone = data.phone;
                // $("#form_submit").submit();

                // $.ajax({
                //     url: "/api/v1/user/" + data.id,
                //     type: 'GET',
                //     contentType: "application/json; charset=utf-8",
                //     error: function () {
                //         // window.component.alert.show("error", "Error", 2000);
                //         console.log("ERROR");
                //     },
                //     success: function (data) {
                //         console.log("PaymentData",data);
                //         $('#id_payment').val(data.id);
                //         $('#real_name_payment').val(data.realName);
                //         $('#phone_payment').val(data.phone);
                //     }
                // });
                window.location.href="/thanh-toan?realName=" + realName + "&phone=" + phone;


            }
        });
    });

})