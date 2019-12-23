// function setVisible(selector, visible) {
//     document.querySelector(selector).style.display = visible ? 'block' : 'none';
// }

// setVisible('.page', false);
// setVisible('#loading', true);

const user = localStorage.getItem("user");
const dataSearch = JSON.parse(sessionStorage.getItem("dataSearch"));
$(document).ready(function () {
    //load header and footer
    //xác nhận đăng nhập
    if (user == null) {
        $('#nav_login').show();
        $('#nav_register').show();
        $('#logout').hide();
    }
    //load search
    const searchRequest = JSON.parse(sessionStorage.getItem("searchRequest"));
    if (searchRequest != null) {
        console.log(searchRequest.diemXuatPhat);
        console.log(searchRequest.diemDung);
        console.log(searchRequest.ngayXuatPhat);
        $("#start_location").val(searchRequest.diemXuatPhat);
        $("#end_location").val(searchRequest.diemDung);
        $("#start_date").val(searchRequest.ngayXuatPhat);
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
    $(document).on("click", "#logout", function (e) {
        localStorage.removeItem("user");
        window.location.reload();
    });
    $(document).on("click", "#btn_payment", function (e) {
        e.preventDefault();
        if (user == null) {
            // window.location.href = "/login";
        } else {
            window.location.href = "/thanh-toan";
            window.location.href = "/thanh-toan?realName=" + user.realName + "&phone=" + phone
        }
        // let user = {
        //     "id": $('#id').val(),
        //     "email": "dsjjkjksfj",
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
$(document).on("click", "#confirm_login", function (e) {
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
    $.ajax({
        type: 'GET',
        url: "/api/v1/login/log",
        data: {
            email: email,
            password: password
        },
        success: function (response) {
            console.log(response);
            if (response.code === 200) {
                localStorage.setItem("user", JSON.stringify(response.data));
                $('#book_ticket_form_login').hide();
                $('#nav_login').hide();
                $('#nav_register').hide();
                $('#btn_payment').show();
                $('#logout').show();
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

// var loginForm = $('#book_ticket_form_login');
$(document).on("click", "#chuyen_xes_collection", function (e) {
    let bookTicket = (e.target.className === "btn btn-primary");
    if (bookTicket) {
        // if (user == null) {
        //     loginForm.appendTo("right_div");
        //     loginForm = null;
        // } else {
        //     loginForm = $("p").detach();
        // }
        if (user == null) {
            $('#book_ticket_form_login').show();
            $('#btn_payment').hide();
        } else {
            $('#book_ticket_form_login').hide();
            $('#btn_payment').show();
        }
        var i = e.target.dataset.id;
        const tbodyModal = document.getElementById('tbody_modal');
        tbodyModal.innerHTML = `
                                <tr>
                                    <td >${dataSearch[i - 1].soGheTrong}</td>
                                    <td >${dataSearch[i - 1].chuyenXe.mucGia}</td>
                                </tr>`;
        $.ajax({
            url: "/api/v1/trangchu/get/orders",
            type: "GET",
            data: {idChuyenXe: dataSearch[i - 1].chuyenXe.id},
            success: function (response) {
                console.log(response);
                if (response.data.twoFloors) {
                    $('#book_ticket_floors').show();
                    var a = document.getElementById('book_ticket_floors');
                    a.addEventListener('change', function () {
                        $('.seat').hide();
                        if (this.value === 'tang_1') {
                            response.data.veXes.forEach(function (veXe) {
                                if (veXe.viTriGhe.includes('A')) {
                                    var idLiBoundCheckbox = '#G' + veXe.viTriGhe.substring(1);
                                    $(idLiBoundCheckbox).show();
                                    var idCheckbox = '#X' + veXe.viTriGhe.substring(1);
                                    $(idCheckbox).removeAttr("disabled");
                                }
                            });

                            response.data.listViTriGheOrdered.forEach(function (viTriGhe) {
                                if (viTriGhe.includes('A')) {
                                    var idCheckbox = '#X' + viTriGhe.substring(1);
                                    $(idCheckbox).attr("disabled", true);
                                }
                            });
                        }
                        if (this.value === 'tang_2') {
                            response.data.veXes.forEach(function (veXe) {
                                if (veXe.viTriGhe.includes('B')) {
                                    var idLiBoundCheckbox = '#G' + veXe.viTriGhe.substring(1);
                                    $(idLiBoundCheckbox).show();
                                    var idCheckbox = '#X' + veXe.viTriGhe.substring(1);
                                    $(idCheckbox).removeAttr("disabled");
                                }
                            });

                            response.data.listViTriGheOrdered.forEach(function (viTriGhe) {
                                if (viTriGhe.includes('B')) {
                                    var idCheckbox = '#X' + viTriGhe.substring(1);
                                    $(idCheckbox).attr("disabled", true);
                                }
                            });
                        }
                    }, false)
                }
                $('.seat').hide();
                response.data.veXes.forEach(function (veXe) {
                    if (veXe.viTriGhe.includes('A')) {
                        var idLiBoundCheckbox = '#G' + veXe.viTriGhe.substring(1);
                        $(idLiBoundCheckbox).show();
                        var idCheckbox = '#X' + veXe.viTriGhe.substring(1);
                        $(idCheckbox).removeAttr("disabled");
                    }
                });

                response.data.listViTriGheOrdered.forEach(function (viTriGhe) {
                    if (viTriGhe.includes('A')) {
                        var idCheckbox = '#X' + viTriGhe.substring(1);
                        $(idCheckbox).attr("disabled", true);
                    }
                });
            }, error: function (error) {
                console.log(error);
            }
        });
        $('#myModal').modal('show');
    }
});
