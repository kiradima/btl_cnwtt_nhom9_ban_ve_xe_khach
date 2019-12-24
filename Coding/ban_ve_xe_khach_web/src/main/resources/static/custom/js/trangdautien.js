$(document).ready(function () {

    var fullDate = new Date();
    var twoDigitMonth = ((fullDate.getMonth().length + 1) === 1) ? (fullDate.getMonth() + 1) : (fullDate.getMonth() + 1);
    var currentDate = fullDate.getFullYear() + "-" + twoDigitMonth + "-" + fullDate.getDate();
    console.log(currentDate);
    $('#ngay_xuat_phat').val(currentDate);

    sessionStorage.removeItem("dataSearch");
    $("#tim_kiem").on('click', function () {
        var diemXuatPhat = $("#diem_xuat_phat").val();
        var diemDung = $("#diem_dung").val();
        var ngayXuatPhat = $("#ngay_xuat_phat").val();
        if (ngayXuatPhat === null || ngayXuatPhat === "" || ngayXuatPhat.trim() === "") {
            alert("Mời nhập ngày xuất phát!");
            return;
        }
        var searchRequest = {
            diemXuatPhat: diemXuatPhat,
            diemDung: diemDung,
            ngayXuatPhat: ngayXuatPhat
        };
        sessionStorage.setItem("searchRequest", JSON.stringify(searchRequest));
        $.ajax({
            type: 'GET',
            url: "/api/v1/trangdautien/search",
            data: searchRequest,
            success: function (response) {
                console.log(response);
                sessionStorage.setItem("dataSearch", JSON.stringify(response.data));
                window.location.href = "/trang-chu";
            },
            error: function (error) {
                console.log(error);
                alert("Không có chuyến xe nào phù hợp!");
                $("#tim_kiem").prop("disabled", false);
            }
        });
    });
});