selectedRowToInput();
function selectedRowToInput() {
    var table = document.getElementById('table'), rIndex;
    for (var i = 1; i < table.rows.length; i++) {
        table.rows[i].onclick = function () {
            rIndex = this.rowIndex;
            document.getElementById("vehicle_id").value = this.cells[1].textContent;
            document.getElementById("vehicle_number_ch").value = this.cells[2].textContent;
            document.getElementById("vehicle_number_numberic").value = this.cells[3].textContent;
            document.getElementById("category").value = this.cells[4].textContent;
            document.getElementById("mileage").value = this.cells[5].textContent;
            document.getElementById("condition").value = this.cells[6].textContent;
        };
    }
}

function save() {
    var vehicle_id = $('#vehicle_id').val();
    var vehicle_number_ch = $('#vehicle_number_ch').val();
    var vehicle_number_numberic = $('#vehicle_number_numberic').val();
    var category = $('#category').val();
    var mileage = $('#mileage').val();
    var condition = $('#condition').val();
    var action = "insert";
    if (vehicle_id === "" || vehicle_number_ch === "" || vehicle_number_numberic === "" || category === "" || mileage === "" || condition === "") {
        alert("Please Enter All Details")
    } else {
        $.ajax({
            url: 'VehicleServlet',
            method: 'POST',
            data: {action: action, vehicle_id: vehicle_id, vehicle_number_ch: vehicle_number_ch, vehicle_number_numberic: vehicle_number_numberic, category: category, mileage: mileage, condition: condition},
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
    var vehicle_id = $('#vehicle_id').val();
    var vehicle_number_ch = $('#vehicle_number_ch').val();
    var vehicle_number_numberic = $('#vehicle_number_numberic').val();
    var category = $('#category').val();
    var mileage = $('#mileage').val();
    var condition = $('#condition').val();
    var action = "update";
    vehicle_id = parseInt(vehicle_id);
    if (vehicle_id === 0) {
        alert("Please Select to Update")
    } else if (vehicle_id === "" || vehicle_number_ch === "" || vehicle_number_numberic === "" || category === "" || mileage === "" || condition === "") {
        alert("Please Enter All Details")
    } else {
        $.ajax({
            url: 'VehicleServlet',
            method: 'POST',
            data: {action: action, vehicle_id: vehicle_id, vehicle_number_ch: vehicle_number_ch, vehicle_number_numberic: vehicle_number_numberic, category: category, mileage: mileage, condition: condition},
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
    var vehicle_id = $('#vehicle_id').val();
    var action = "delete";
    vehicle_id = parseInt(vehicle_id);
    if (vehicle_id === 0) {
        alert("Please Select to Update")
    } else {
        var r = confirm("Are you Sure?");
        if (r == true) {
            $.ajax({
                url: 'VehicleServlet',
                method: 'POST',
                data: {action: action, vehicle_id: vehicle_id},
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

function onclickvalidateName(evt) {
    var theEvent = evt || window.event;
    // Handle paste
    if (theEvent.type === 'paste') {
        key = event.clipboardData.getData('text/plain');
    } else {
        // Handle key press
        var key = theEvent.keyCode || theEvent.which;
        key = String.fromCharCode(key);
    }
    var regex = /^[a-zA-Z\s]+$/;
    if (!regex.test(key)) {
        theEvent.returnValue = false;
        if (theEvent.preventDefault)
            theEvent.preventDefault();
    }

}

function onclickvalidateNumber(evt) {
    var theEvent = evt || window.event;
    // Handle paste
    if (theEvent.type === 'paste') {
        key = event.clipboardData.getData('text/plain');
    } else {
        // Handle key press
        var key = theEvent.keyCode || theEvent.which;
        key = String.fromCharCode(key);
    }
    var regex = /[0-9]|\./;
    if (!regex.test(key)) {
        theEvent.returnValue = false;
        if (theEvent.preventDefault)
            theEvent.preventDefault();
    }

}

function onClickValidationContactNumber(evt) {
    var theEvent = evt || window.event;
    // Handle paste
    if (theEvent.type === 'paste') {
        key = event.clipboardData.getData('text/plain');
    } else {
        // Handle key press
        var key = theEvent.keyCode || theEvent.which;
        key = String.fromCharCode(key);
    }
    var regex = /[0-9]/;
    if (!regex.test(key)) {
        theEvent.returnValue = false;
        if (theEvent.preventDefault)
            theEvent.preventDefault();
    }

}