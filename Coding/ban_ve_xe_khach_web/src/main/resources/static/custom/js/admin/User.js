$(document).ready(function () {
    let columnDefinitions = [
        {
        "data": "id",
        "class": "text-center"
        },
        {
            "data": "username",
            "class": "text-center"
        },
        {
            "data": "password",
            "class": "text-center"
        },
        {
            "data": "role",
            "class": "text-center"
        },
        {
            "data": "realName",
            "class": "text-center"
        },
        {
            "data": "phone",
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
        jQuery.get("/api/v1/User/list", params, function (response) {
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
            targets: 6
        },
            {
                "targets": [3],
                "visible": false
            },
            {
                "targets": [4],
                "visible": false
            },
            {
                "targets": [5]
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
        let User = {
            "id": $('#id').val(),
            "username": $('#username').val(),
            "password": $('#password').val(),
            "role": $('#role').val(),
            "realName": $('#realName').val(),
            "phone": $(#'realName').val(),
        };

        $.ajax({
            url: "/api/v1/User/create",
            type: 'POST',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(User),
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
        result_confirm = confirm("Are you sure want to DELETE this User");
        if (result_confirm == true) {
            $.ajax({
                url: "/api/v1/User/delete/" + $(this).attr('id'),
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
            url: "/api/v1/User/" + $(this).attr('id'),
            type: 'GET',
            contentType: "application/json; charset=utf-8",
            error: function () {
                window.component.alert.show("error", "Error", 2000);
            },
            success: function (data) {
                console.log(data);
                $('#id_edit').val(data.id);
                $('#username_edit').val(data.username);
                $('#password_edit').val(data.password);
                $('#role_edit').val(data.role);
                $('#realName_edit').val(data.realName);
                $('#phone-edit').val(data.phone);
            }
        });
    });

    // UPDATE
    $(document).on("click", "#id-btn-update", function () {
        let User = {
            "id": $('#id_edit').val(),
            "username": $("#username_edit").val(),
            "password": $("#password_edit").val(),
            "role": $("#role_edit").val(),
            "realName": $("#realName_edit").val(),
            "phone": $("#phone_edit").val(),
        };

        $.ajax({
            url: "/api/v1/User/update",
            type: 'PUT',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(User),
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
        url: "/api/v1/User/list",
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
