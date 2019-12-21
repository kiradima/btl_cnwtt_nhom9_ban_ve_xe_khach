// function setVisible(selector, visible) {
//     document.querySelector(selector).style.display = visible ? 'block' : 'none';
// }

// setVisible('.page', false);
// setVisible('#loading', true);

const dataSearch = JSON.parse(sessionStorage.getItem("dataSearch"));
$(document).ready(function () {
    //xác nhận đăng nhập
    const user = localStorage.getItem("user");
    if (user == null) {
        $('#nav_login').show();
        $('#nav_register').show();
    }
    //load các chuyến xe
    const talbeBody = document.getElementById('chuyen_xes_collection');
    talbeBody.innerHTML = "";
    var i = 1;
    dataSearch.forEach(function (search) {
        var danhGiaSao = search.danhGiaSao;
        if (danhGiaSao == null) {
            danhGiaSao = 'Chuyến xe này chưa có đánh giá!';
        } else {
            danhGiaSao += "*";
        }
        talbeBody.innerHTML += `
                <tr>
                    <td>${i}</td>
                    <td>${search.tenNhaXe}</td>
                    <td>
                        ${search.viTriChuyenXesDi[0].thoiDiemDuKien} <br>${search.tinhXuatPhat}
                    </td>
                    <td>
                    ${search.viTriChuyenXesDung[search.viTriChuyenXesDung.length - 1].thoiDiemDuKien} <br>${search.tinhDung}
                    </td>
                    <td>${search.chuyenXe.loaiXe}<br>${search.soGheTrong}</td> <td> 
                    <td>${danhGiaSao}<br><a href="">${search.soBinhLuan}</a></td>
                    <td>
                    <button class="btn btn-primary" data-id="${i}">Đặt Vé</button>
                    </td>`;
        i++;
    });
    $(document).on("click", "#btn_payment", function (e) {
        e.preventDefault();
        if (user == null) {
            window.location.href = "/login";
        } else {
            window.location.href = "/thanh-toan";
        }
        // let user = {
        //     "id": $('#id').val(),
        //     "userName": "dsjjkjksfj",
        //     "password": "1234561234",
        //     "realName": $('#real_name').val(),
        //     "phone": $('#phone').val(),
        //     "role": 1,
        // };
        //
        // $.ajax({
        //     url: "/api/v1/user/create",
        //     type: 'POST',
        //     contentType: "application/json; charset=utf-8",
        //     data: JSON.stringify(user),
        //     error: function () {
        //         // window.component.alert.show("error", "Error", 2000);
        //         console.log("ERROR");
        //     },
        //     success: function (data) {
        //         console.log(data);
        //         let realName = data.realName;
        //         let phone = data.phone;
        //         // $("#form_submit").submit();
        //
        //         // $.ajax({
        //         //     url: "/api/v1/user/" + data.id,
        //         //     type: 'GET',
        //         //     contentType: "application/json; charset=utf-8",
        //         //     error: function () {
        //         //         // window.component.alert.show("error", "Error", 2000);
        //         //         console.log("ERROR");
        //         //     },
        //         //     success: function (data) {
        //         //         console.log("PaymentData",data);
        //         //         $('#id_payment').val(data.id);
        //         //         $('#real_name_payment').val(data.realName);
        //         //         $('#phone_payment').val(data.phone);
        //         //     }
        //         // });
        //         window.location.href = "/thanh-toan?realName=" + realName + "&phone=" + phone;
        //
        //
        //     }
        // });
    });
});

$(document).on("click", "#chuyen_xes_collection", function (e) {
    let bookTicket = (e.target.className === "btn btn-primary");
    if (bookTicket) {
        var i = e.target.dataset.id;
        $('#myModal').modal('show');
        const tbodyModal = document.getElementById('tbody_modal');
        tbodyModal.innerHTML = `
                                <tr>
                                    <td >${dataSearch[i - 1].soGheTrong}</td>
                                    <td >${dataSearch[i - 1].chuyenXe.mucGia}</td>
                                </tr>`;
        $.ajax({
            url: "",
            type: "GET",
            data: {},
            success: function (response) {
                console.log(response);
            }, error: function (error) {
                console.log(error);
            }
        });
    }
});
