$(document).ready(function () {
    let columnDefinitions = [
        {
        "data": "id",
        "class": "text-center"
        },
        {
            "data": "idViTri",
            "class": "text-center"
        },
        {
            "data": "idChuyenXe",
            "class": "text-center"
        },
        {
            "data": "thoiDiemDuKien",
            "class": "text-center"
        },
        {
            "data": "type",
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
        jQuery.get("/api/v1/ViTriChuyenXe/list", params, function (response) {
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
            },
        ],
        "order": [
            [0, "asc"]
        ]
    });

    // CREATE NEW

    $(document).on("click", "#id-btn-add", function (e) {
        e.preventDefault();
        let ViTriChuyenXe = {
            "id": $('#id').val(),
            "idViTri": $('#idViTri').val(),
            "idChuyenXe": $('#idChuyenXe').val(),
            "thoiDiemDuKien": $('#thoiDiemDuKien').val(),
            "type": $('#type').val(),
        };

        $.ajax({
            url: "/api/v1/ViTriChuyenXe/create",
            type: 'POST',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(ViTriChuyenXe),
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
        result_confirm = confirm("Are you sure want to DELETE this ViTriChuyenXe");
        if (result_confirm == true) {
            $.ajax({
                url: "/api/v1/ViTriChuyenXe/delete/" + $(this).attr('id'),
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
            url: "/api/v1/ViTriChuyenXe/" + $(this).attr('id'),
            type: 'GET',
            contentType: "application/json; charset=utf-8",
            error: function () {
                window.component.alert.show("error", "Error", 2000);
            },
            success: function (data) {
                console.log(data);
                $('#id_edit').val(data.id);
                $('#idViTri_edit').val(data.idViTri);
                $('#idChuyenXe_edit').val(data.idChuyenXe);
                $('#thoiDiemDuKien_edit').val(data.thoiDiemDuKien);
                $('#type_edit').val(data.type);
            }
        });
    });

    // UPDATE
    $(document).on("click", "#id-btn-update", function () {
        let ViTriChuyenXe = {
            "id": $('#id_edit').val(),
            "idViTri": $("#idVitri_edit").val(),
            "idChuyenXe": $("#idChuyenXe_edit").val(),
            "thoiDiemDuKien": $("#thoiDiemDuKien_edit").val(),
            "type": $("#type_edit").val(),
        };

        $.ajax({
            url: "/api/v1/ViTriChuyenXe/update",
            type: 'PUT',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(ViTriChuyenXe),
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
        url: "/api/v1/ViTriChuyenXe/list",
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
