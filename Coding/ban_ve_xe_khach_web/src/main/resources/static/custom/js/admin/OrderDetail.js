$(document).ready(function () {
    let columnDefinitions = [
        {
        "data": "id",
        "class": "text-center"
        },
        {
            "data": "idOrder",
            "class": "text-center"
        },
        {
            "data": "idVe",
            "class": "text-center"
        },
        {
            "data": "idDiemDon",
            "class": "text-center"
        },
        {
            "data": "idDiemDung",
            "class": "text-center"
        },
        {
            "data": null,
            "class": "text-center"
        }
    ];

    let getData = function (requestData, renderFunction) {
        let params = {
            "page": (requestData.start / requestData.length) + 1,
            "size": requestData.length,
        };
        jQuery.get("/api/v1/OrderDetail/list", params, function (response) {
            let content = {
                "draw": requestData.draw,
                "recordsTotal": response.totalElements,
                "recordsFiltered": response.totalElements,
                "data": response.content
            };
            renderFunction(content);
        });
    };

    let table = $("#table").DataTable({
        "lengthMenu": [
            [10, 20, 50],
            [10, 20, 50]
        ],
        "serverSide": true,
        "searching": false,
        "columns": columnDefinitions,
        "ajax": function (requestData, renderFunction) {
            getData(requestData, renderFunction);
        },
        columnDefs: [{
            "render": function (data) {
                return '<button id="' + data.id + '" class="btn btn-info btn-sm btn-edit action-btn" data-toggle="modal" data-target="#edit_modal">Edit</button>' +
                    '<button id="' + data.id + '" class="btn btn-danger btn-sm btn-delete" data-toggle="tooltip" data-target="#delete_modal" data-placement="bottom">Delete</button>';
            },
            targets: 5
        },
            {
                "targets": [3],
                "visible": false
            },
            {
                "targets": [4],
                "visible": false
            }
        ],
        "order": [
            [0, "asc"]
        ]
    });

    // CREATE NEW

    $(document).on("click", "#id-btn-add", function (e) {
        e.preventDefault();
        let OrderDetail = {
            "id": $('#id').val(),
            "idOrder": $('#idOrder').val(),
            "idVe": $('#idVe').val(),
            "idDiemDon": $('#idDiemDon').val(),
            "idDiemDung": $('#idDiemDung').val(),
        };

        $.ajax({
            url: "/api/v1/OrderDetail/create",
            type: 'POST',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(OrderDetail),
            error: function () {
                window.component.alert.show("error", "Error", 2000);
            },
            success: function (data) {
                console.log(data);
                window.component.alert.show("success", "Success", 1000);
                table.ajax.reload();
            }
        });
    });

    // DELETE

    $(document).on("click", ".btn-delete", function () {
        result_confirm = confirm("Are you sure want to DELETE this DanhGia");
        if (result_confirm == true) {
            $.ajax({
                url: "/api/v1/OrderDetail/delete/" + $(this).attr('id'),
                type: 'DELETE',
                error: function () {
                    window.component.alert.show("error", "Error", 2000);
                },
                success: function () {
                    window.component.alert.show("success", "Success", 2000);
                    table.ajax.reload();
                }
            });
        } else {
            //do something
        }
    });

    // EDIT

    $(document).on("click", ".btn-edit", function () {
        $.ajax({
            url: "/api/v1/OrderDetail/" + $(this).attr('id'),
            type: 'GET',
            contentType: "application/json; charset=utf-8",
            error: function () {
                window.component.alert.show("error", "Error", 2000);
            },
            success: function (data) {
                console.log(data);
                $('#id_edit').val(data.id);
                $('#idOrder_edit').val(data.idOrder);
                $('#idVe_edit').val(data.idVe);
                $('#idDiemDon_edit').val(data.idDiemDon);
                $('#idDiemDung_edit').val(data.idDiemDung);
            }
        });
    });

    // UPDATE
    $(document).on("click", "#id-btn-update", function () {
        let OrderDetail = {
            "id": $('#id_edit').val(),
            "idOrder": $("#idOrder_edit").val(),
            "idVe": $("#idVe_edit").val(),
            "idDiemDon": $("#idDiemDon_edit").val(),
            "idDiemDung": $("#idDiemDung_edit").val(),
        };

        $.ajax({
            url: "/api/v1/OrderDetail/update",
            type: 'PUT',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(OrderDetail),
            error: function () {
                window.component.alert.show("error", "Error", 2000);
            },
            success: function (data) {
                console.log(data);
                window.component.alert.show("success", "Success", 1000);
                table.ajax.reload();
            }
        });
    });

    // HIỂN THỊ BẢNG DỮ LIỆU

    $.ajax({
        url: "/api/v1/OrderDetail/list",
        type: 'GET',
        error: function () {
            window.component.alert.show("error", "Error", 2000);
        },
        success: function (data) {
            for (let i = 0; i < data.content.length; i++) {
                let item = data.content[i];
                $("#position").append("<option value='" + item.id + "'>" + item.position + "</option>");
            }
        }
    });
});
