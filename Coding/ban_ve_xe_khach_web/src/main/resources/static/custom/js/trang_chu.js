$(document).ready(function () {
    $('.datepicker').datepicker({
        showOn: focus,
        format: 'mm/dd/yyyy',
        todayHighlight: true,
        autoclose: true
    });
    $('#start_date').datepicker({
        showOn: focus,
        format: 'mm/dd/yyyy',
        todayHighlight: true,
        autoclose: true
    })
})