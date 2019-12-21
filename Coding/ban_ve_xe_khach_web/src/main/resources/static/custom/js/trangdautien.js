$(document).ready(function () {
    sessionStorage.removeItem("dataSearch");
    $("#tim_kiem").on('click', function () {
        var diemXuatPhat = $("#diem_xuat_phat").val();
        var diemDung = $("#diem_dung").val();
        var ngayXuatPhat = $("#ngay_xuat_phat").val();
        if (ngayXuatPhat === null || ngayXuatPhat === "" || ngayXuatPhat.trim() === "") {
            alert("Mời nhập ngày xuất phát!");
            return;
        }
        var data = {
            diemXuatPhat: diemXuatPhat,
            diemDung: diemDung,
            ngayXuatPhat: ngayXuatPhat
        };
        $.ajax({
            type: 'GET',
            url: "/api/v1/trangdautien/search",
            data: data,
            success: function (response) {
                console.log(response);
                sessionStorage.setItem("dataSearch", JSON.stringify(response.data));
                window.location.href= "/trang-chu";
            },
            error: function (error) {
                console.log(error);
                alert("Failed");
                $("#tim_kiem").prop("disabled", false);
            }
        });
    })
});