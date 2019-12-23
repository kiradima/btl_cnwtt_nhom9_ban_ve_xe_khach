$(document).ready(function () {
    const bookTicketInfo = JSON.parse(sessionStorage.getItem("bookTicketInfo"));
    var listGheChecked = bookTicketInfo.listGheChecked; // list order
    console.log(listGheChecked);

    // var i = 1;
    // var tbodyThanhToan = document.getElementById('tbody_thanh_toan');
    // tbodyThanhToan.innerHTML = "";
    // listGheChecked.forEach(function () {
    //     tbodyThanhToan.innerHTML += `
    //             <tr>
    //                 <td>${i}</td>
    //                 <td>${listGheChecked[i - 1]}</td>
    //                 <td>${bookTicketInfo.giaVe}</td> <td> `;
    //     i++;
    // });
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


    $('#table_book').DataTable( {
        data: listGheChecked
    } );








    let listSeatChecked = [];
    let numberSeat = 0;
    let price = 50000; //price

    $(".checkbox-seat").on('change', function () {
        if ($(this).is(':checked')) {
            numberSeat++;
            $(this).attr('value', 'true'); //seat selected
        } else {
            numberSeat--;
            $(this).attr('value', 'false');
        }

        console.log(numberSeat);

        //sum total money
        function totalPayment() {
            let total = 0;
            total += price * numberSeat;
            return total;
        }

        console.log(totalPayment());

        $('#number_seat').html(numberSeat);
        $('#total_payment').html(totalPayment() + " VND");
    });

    // $(".btn-payment").on('click', function () {
    //     $("#payment").on('click', function () {
    //         qs();
    //         let payment = {
    //             // "id": $('#id_payment').val(),
    //             "soLuongVe": Number(numberSeat),
    //             "tongTien": Number(totalPayment()),
    //             "name": ,
    //             "phone": $('#phone_payment').val(),
    //         };
    //         console.log(payment);
    //         $.ajax({
    //             url: 'api/v1/thanhtoan/create',
    //             type: 'POST',
    //             contentType: "application/json; charset=utf-8",
    //             data: JSON.stringify(payment),
    //             error: function () {
    //                 // window.component.alert.show("error", "Error", 2000);
    //                 console.log("ERROR");
    //             },
    //             success: function (data) {
    //                 console.log(data);
    //
    //                 window.location.reload();
    //             }
    //         })
    //     })
    // })

    function qs() {
        var qsparam = new Array(10);
        var query = window.location.search.substring(1);
        var parms = query.split('&');
        for (var i = 0; i < parms.length; i++) {
            var pos = parms[i].indexOf('=');
            if (pos > 0) {
                var key = parms[i].substring(0, pos);
                var val = parms[i].substring(pos + 1);
                qsparam[i] = val;
            }
        }
        $('#real_name_payment').html(qsparam[0]);
        $('#phone_payment').html(qsparam[1]);

        $(".btn-payment").on('click', function () {
            $("#payment").on('click', function () {
                qs();
                let payment = {
                    // "id": $('#id_payment').val(),
                    "soLuongVe": Number(numberSeat),
                    "tongTien": numberSeat * price,
                    "name": qsparam[0],
                    "phone": qsparam[1],
                };
                console.log(payment);
                $.ajax({
                    url: 'api/v1/thanhtoan/create',
                    type: 'POST',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(payment),
                    error: function () {
                        // window.component.alert.show("error", "Error", 2000);
                        console.log("ERROR");
                    },
                    success: function (data) {
                        console.log(data);

                        window.location.reload();
                    }
                })
            })
        })
    }

    // var splitstr = qs();


});