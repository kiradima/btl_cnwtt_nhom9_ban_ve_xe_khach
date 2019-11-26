$(document).ready(function () {
    let columnDefinitions = [
        {
        "data": "id",
        "class": "text-center"
        },
        {
            "data": "diemXuatPhat",
            "class": "text-center"
        },
        {
            "data": "diemKetThuc",
            "class": "text-center"
        },
        {
            "data": "gioXuatPhat",
            "class": "text-center"
        },
        {
            "data": "gioKetThuc",
            "class": "text-center"
        },
        {
            "data": "loaiXe",
            "class": "text-center"
        },
        {
            "data": "chinhSachHuyVe",
            "class": "text-center"
        },
{
            "data": "luyY",
            "class": "text-center"
        },
        {
            "data": "idNhaXe",
            "class": "text-center"
        },
        {
            "data": null,
            "class": "text-center"
        }
    ];

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
            targets: 8
        }
        ],
        "order": [
            [0, "asc"]
        ]
    });
})