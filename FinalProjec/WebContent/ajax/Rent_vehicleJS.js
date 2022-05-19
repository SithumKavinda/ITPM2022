selectedRowToInput();
function selectedRowToInput() {
    var table = document.getElementById('table'), rIndex;
    for (var i = 1; i < table.rows.length; i++) {
        table.rows[i].onclick = function () {
            rIndex = this.rowIndex;
            document.getElementById("rent_vehicle_id").value = this.cells[1].textContent;
            document.getElementById("vehicle_id").value = this.cells[2].textContent;
            document.getElementById("customer_id").value = this.cells[3].textContent;
            document.getElementById("rent_date").value = this.cells[4].textContent;
            document.getElementById("mileage").value = this.cells[5].textContent;
            document.getElementById("condition").value = this.cells[6].textContent;
        };
    }
}

function save() {
    var rent_vehicle_id = $('#rent_vehicle_id').val();
    var vehicle_id = $('#vehicle_id').val();
    var customer_id = $('#customer_id').val();
    var rent_date = $('#rent_date').val();
    var mileage = $('#mileage').val();
    var condition = $('#condition').val();
    var action = "insert";
    if (rent_vehicle_id === "" || vehicle_id === "" || customer_id === "" || rent_date === "" || mileage === "" || condition === "") {
        alert("Please Enter All Details")
    } else {
        $.ajax({
            url: 'Rent_vehicleServlet',
            method: 'POST',
            data: {action: action, rent_vehicle_id: rent_vehicle_id, vehicle_id: vehicle_id, customer_id: customer_id, rent_date: rent_date, mileage: mileage, condition: condition},
            success: function (resultText) {
                alert(resultText);
                $("#table").find("tr:gt(0)").remove();
                load();
            },
            error: function (jqXHR, exception) {
                alert("Fail Ajax");
            }
        });
    }
}

function update() {
    var rent_vehicle_id = $('#rent_vehicle_id').val();
    var vehicle_id = $('#vehicle_id').val();
    var customer_id = $('#customer_id').val();
    var rent_date = $('#rent_date').val();
    var mileage = $('#mileage').val();
    var condition = $('#condition').val();
    var action = "update";
    rent_vehicle_id = parseInt(rent_vehicle_id);
    if (rent_vehicle_id === 0) {
        alert("Please Select to Update")
    } else if (rent_vehicle_id === "" || vehicle_id === "" || customer_id === "" || rent_date === "" || mileage === "" || condition === "") {
        alert("Please Enter All Details")
    } else {
        $.ajax({
            url: 'Rent_vehicleServlet',
            method: 'POST',
            data: {action: action, rent_vehicle_id: rent_vehicle_id, vehicle_id: vehicle_id, customer_id: customer_id, rent_date: rent_date, mileage: mileage, condition: condition},
            success: function (resultText) {
                alert(resultText);
                $("#table").find("tr:gt(0)").remove();
                load();
            },
            error: function (jqXHR, exception) {
                alert("Fail Ajax");
            }
        });
    }
}

function delet() {
    var rent_vehicle_id = $('#rent_vehicle_id').val();
    var action = "delete";
    rent_vehicle_id = parseInt(rent_vehicle_id);
    if (rent_vehicle_id === 0) {
        alert("Please Select to Update")
    } else {
        var r = confirm("Are you Sure?");
        if (r == true) {
            $.ajax({
                url: 'Rent_vehicleServlet',
                method: 'POST',
                data: {action: action, rent_vehicle_id: rent_vehicle_id},
                success: function (resultText) {
                    $("#table").find("tr:gt(0)").remove();
                    load();
                    alert("Deleted")
                },
                error: function (jqXHR, exception) {
                    alert("Fail Ajax");
                }
            });
        } else {
            alert("Not Deleted")
        }
    }
}

function load() {
    var table = document.getElementById('table');
    var dropdown1 = document.getElementById('vehicle_id');
    $('#vehicle_id')
            .find('option')
            .remove()
            .end()
            ;

    var action = "serch";
    $.ajax({
        url: 'VehicleServlet',
        method: 'POST',
        data: {action: action},
        success: function (resultText) {


            resultText = resultText.replace("[", "");
            resultText = resultText.replace("]", "");

            var c = [];
            c = resultText;


            if (c.length > 1) {

                var step1 = [];
                var step2 = [];
                step1 = resultText.split("~");

                for (i = 0; i < step1.length; ++i) {
                    step2 = step1[i].split("_");
                    var option = document.createElement("option");
                    option.text = step2[1] + ' - ' + step2[2];
                    option.value = step2[0];
                    dropdown1.add(option);

                }
            }

            onChangeDiscount();

        },
        error: function (jqXHR, exception) {
            swal("fail");
        }
    });
    var dropdown2 = document.getElementById('customer_id');
    $('#customer_id')
            .find('option')
            .remove()
            .end()
            ;

    var action = "serch";
    $.ajax({
        url: 'CustomerServlet',
        method: 'POST',
        data: {action: action},
        success: function (resultText) {

            resultText = resultText.replace("[", "");
            resultText = resultText.replace("]", "");

            var c = [];
            c = resultText;


            if (c.length > 1) {

                var step1 = [];
                var step2 = [];
                step1 = resultText.split("~");

                for (i = 0; i < step1.length; ++i) {
                    step2 = step1[i].split("_");
                    var option = document.createElement("option");
                    option.text = step2[1];
                    option.value = step2[0];
                    dropdown2.add(option);

                }
            }

            onChangeDiscount();

        },
        error: function (jqXHR, exception) {
            swal("fail");
        }
    });
    var action = "serch";
    $.ajax({
        url: 'Rent_vehicleServlet',
        method: 'POST',
        data: {action: action},
        success: function (resultText) {
            resultText = resultText.replace("[", "");
            resultText = resultText.replace("]", "");
            var c = [];
            c = resultText;
            if (c.length > 5) {
                var step1 = [];
                var step2 = [];
                step1 = resultText.split("~");
                for (i = 0; i < step1.length; ++i) {
                    step2 = step1[i].split("_");
                    var newRow = table.insertRow(table.length),
                            cell0 = newRow.insertCell(0),
                            cell1 = newRow.insertCell(1),
                            cell2 = newRow.insertCell(2),
                            cell3 = newRow.insertCell(3),
                            cell4 = newRow.insertCell(4),
                            cell5 = newRow.insertCell(5),
                            cell6 = newRow.insertCell(6),
                            cell7 = newRow.insertCell(7),
                            k = i + 1;
                    cell0.innerHTML = k;
                    cell1.innerHTML = step2[0];
                    cell2.innerHTML = step2[1];
                    cell3.innerHTML = step2[2];
                    cell4.innerHTML = step2[3];
                    cell5.innerHTML = step2[4];
                    cell6.innerHTML = step2[5];
                    cell7.innerHTML = step2[6];
                }
            }
            selectedRowToInput();
        },
        error: function (jqXHR, exception) {
            alert("Fail Ajax")
        }
    });
    document.getElementById("form").reset();
}