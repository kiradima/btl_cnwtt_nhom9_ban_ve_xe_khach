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
});

$(document).on("click", "#tim_kiem", function (e) {
    var diemXuatPhat = $("#start_location").val();
    var diemDung = $("#end_location").val();
    var ngayXuatPhat = $("#start_date").val();
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
            console.log(response.data.length);
            if (response.data.length === 0) {
                alert("Không có chuyến xe nào phù hợp!");
            }
            sessionStorage.setItem("dataSearch", JSON.stringify(response.data));
            window.location.reload();
        },
        error: function (error) {
            console.log(error);
            alert("Không có chuyến xe nào phù hợp!");
            $("#tim_kiem").prop("disabled", false);
        }
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

$(document).on("click", "#chuyen_xes_collection", function (e) {
    let bookTicket = (e.target.className === "btn btn-primary");
    if (bookTicket) {
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
                var listGheChecked = [];
                $(document).on("click", "#btn_payment", function (e) {
                    e.preventDefault();
                    var bookTicketInfo = {
                        dataId: i - 1,
                        dataOrdered: response.data,
                        listGheChecked: listGheChecked,
                        giaVe: dataSearch[i - 1].chuyenXe.mucGia,
                        soVe: listGheChecked.length
                    };
                    sessionStorage.setItem("bookTicketInfo", JSON.stringify(bookTicketInfo));
                    if (user != null) {
                        window.location.href = "/thanh-toan";
                        window.location.href = "/thanh-toan?realName=" + user.realName + "&phone=" + phone
                    }
                });
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
                                    $(idCheckbox).off();
                                    $(idCheckbox).removeAttr("disabled");
                                    $(idCheckbox).prop("checked", false);
                                    if (listGheChecked.includes(veXe.viTriGhe)) {
                                        $(idCheckbox).prop("checked", true);
                                    }
                                    $(idCheckbox).change(function () {
                                        if ($(this).is(':checked')) {
                                            listGheChecked.push(veXe.viTriGhe);
                                        } else {
                                            for (var i = 0; i < listGheChecked.length; i++) {
                                                if (listGheChecked[i] === veXe.viTriGhe) {
                                                    listGheChecked.splice(i, 1);
                                                    i--;
                                                }
                                            }
                                        }
                                        console.log(listGheChecked);
                                    });
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
                                    $(idCheckbox).off();
                                    $(idCheckbox).removeAttr("disabled");
                                    $(idCheckbox).prop("checked", false);
                                    if (listGheChecked.includes(veXe.viTriGhe)) {
                                        $(idCheckbox).prop("checked", true);
                                    }
                                    $(idCheckbox).change(function () {
                                        if ($(this).is(':checked')) {
                                            listGheChecked.push(veXe.viTriGhe);
                                        } else {
                                            for (var i = 0; i < listGheChecked.length; i++) {
                                                if (listGheChecked[i] === veXe.viTriGhe) {
                                                    listGheChecked.splice(i, 1);
                                                    i--;
                                                }
                                            }
                                        }
                                        console.log(listGheChecked);
                                    });
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
                listGheChecked = [];
                response.data.veXes.forEach(function (veXe) {
                    if (veXe.viTriGhe.includes('A')) {
                        var idLiBoundCheckbox = '#G' + veXe.viTriGhe.substring(1);
                        $(idLiBoundCheckbox).show();
                        var idCheckbox = '#X' + veXe.viTriGhe.substring(1);
                        $(idCheckbox).off();
                        $(idCheckbox).removeAttr("disabled");
                        $(idCheckbox).prop("checked", false);
                        if (listGheChecked.includes(veXe.viTriGhe)) {
                            $(idCheckbox).prop("checked", true);
                        }
                        $(idCheckbox).change(function () {
                            if ($(this).is(':checked')) {
                                listGheChecked.push(veXe.viTriGhe);
                            } else {
                                for (var i = 0; i < listGheChecked.length; i++) {
                                    if (listGheChecked[i] === veXe.viTriGhe) {
                                        listGheChecked.splice(i, 1);
                                        i--;
                                    }
                                }
                            }
                            console.log(listGheChecked);
                        });
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
