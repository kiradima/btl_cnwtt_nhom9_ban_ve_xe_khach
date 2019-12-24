$(document).ready(function () {
    //xác nhận đăng nhập
    const u = localStorage.getItem("user");
    if (u == null) {
        window.location.replace("/login");
    }

    const bookTicketInfo = JSON.parse(sessionStorage.getItem("bookTicketInfo"));
    var listGheChecked = bookTicketInfo.listGheChecked; // list order
    console.log(listGheChecked);

    var i = 1;
    var tbodyThanhToan = document.getElementById('tbody_thanh_toan');
    tbodyThanhToan.innerHTML = "";
    listGheChecked.forEach(function () {
        tbodyThanhToan.innerHTML += `
                <tr>
                    <td>${i}</td>
                    <td>${listGheChecked[i - 1]}</td>
                    <td>${bookTicketInfo.giaVe}</td> <td> `;
        i++;
    });
    const user = JSON.parse(localStorage.getItem("user"));
    const dataSearch = JSON.parse(sessionStorage.getItem("dataSearch"));
    var realNamePayment = document.getElementById('real_name_payment');
    realNamePayment.innerHTML = user.realName;
    var phonePayment = document.getElementById('phone_payment');
    phonePayment.innerText = user.phone;
    var nhaXe = document.getElementById('nha_xe');
    nhaXe.innerHTML = dataSearch[bookTicketInfo.dataId].tenNhaXe;
    var diemDonKhach = document.getElementById('diem_don_khach');
    diemDonKhach.innerHTML = dataSearch[bookTicketInfo.dataId].tinhXuatPhat;
    var diemTraKhach = document.getElementById('diem_tra_khach');
    diemTraKhach.innerHTML = dataSearch[bookTicketInfo.dataId].tinhDung;
    var numberSeat = document.getElementById('number_seat');
    numberSeat.innerHTML = bookTicketInfo.soVe;
    var totalPayment = document.getElementById('total_payment');
    totalPayment.innerHTML = (bookTicketInfo.soVe) * (bookTicketInfo.giaVe) + " VND";

    $(".btn-payment").on('click', function () {
        $("#payment").on('click', function () {
            // qs();
            let payment = {
                soLuongVe: bookTicketInfo.soVe,
                tongTien: (bookTicketInfo.soVe) * (bookTicketInfo.giaVe),
                name: user.realName,
                phone: user.phone,
                idNhaXe: dataSearch[bookTicketInfo.dataId].chuyenXe.idNhaXe
            };
            console.log(payment);
            $.ajax({
                url: 'api/v1/thanhtoan/create',
                type: 'POST',
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(payment),
                error: function () {
                    alert("Thanh toán thất bại!");
                    console.log("ERROR");
                },
                success: function (data) {
                    console.log(data);
                    alert("Thanh Toán Thành Công!");
                    window.location.replace("/");
                    sessionStorage.clear();
                }
            })
        });
    });
    $(document).on("click", "#logout", function (e) {
        localStorage.removeItem("user");
        window.location.replace("/");
    });
});