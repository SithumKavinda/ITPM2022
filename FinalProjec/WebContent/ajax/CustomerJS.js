selectedRowToInput();
function selectedRowToInput() {
    var table = document.getElementById('table'), rIndex;
    for (var i = 1; i < table.rows.length; i++) {
        table.rows[i].onclick = function () {
            rIndex = this.rowIndex;
            document.getElementById("customer_id").value = this.cells[1].textContent;
            document.getElementById("fname").value = this.cells[2].textContent;
            document.getElementById("lname").value = this.cells[3].textContent;
            document.getElementById("address").value = this.cells[4].textContent;
            document.getElementById("nic").value = this.cells[5].textContent;
            document.getElementById("email").value = this.cells[6].textContent;
            document.getElementById("phone").value = this.cells[7].textContent;
        };
    }
}

function save() {
    var customer_id = $('#customer_id').val();
    var fname = $('#fname').val();
    var lname = $('#lname').val();
    var address = $('#address').val();
    var nic = $('#nic').val();
    var email = $('#email').val();
    var phone = $('#phone').val();
    var action = "insert";
    if (customer_id === "" || fname === "" || lname === "" || address === "" || nic === "" || email === "" || phone === "") {
        alert("Please Enter All Details")
    } else if (ValidateEmail() || nicValidation() || contactValidation()) {

    } else {
        $.ajax({
            url: 'CustomerServlet',
            method: 'POST',
            data: {action: action, customer_id: customer_id, fname: fname, lname: lname, address: address, nic: nic, email: email, phone: phone},
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
    var customer_id = $('#customer_id').val();
    var fname = $('#fname').val();
    var lname = $('#lname').val();
    var address = $('#address').val();
    var nic = $('#nic').val();
    var email = $('#email').val();
    var phone = $('#phone').val();
    var action = "update";
    customer_id = parseInt(customer_id);
    if (customer_id === 0) {
        alert("Please Select to Update")
    } else if (customer_id === "" || fname === "" || lname === "" || address === "" || nic === "" || email === "" || phone === "") {
        alert("Please Enter All Details")
    } else if (ValidateEmail() || nicValidation() || contactValidation()) {

    } else {
        $.ajax({
            url: 'CustomerServlet',
            method: 'POST',
            data: {action: action, customer_id: customer_id, fname: fname, lname: lname, address: address, nic: nic, email: email, phone: phone},
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
    var customer_id = $('#customer_id').val();
    var action = "delete";
    customer_id = parseInt(customer_id);
    if (customer_id === 0) {
        alert("Please Select to Update")
    } else {
        var r = confirm("Are you Sure?");
        if (r == true) {
            $.ajax({
                url: 'CustomerServlet',
                method: 'POST',
                data: {action: action, customer_id: customer_id},
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
        url: 'CustomerServlet',
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
                            cell8 = newRow.insertCell(8),
                            k = i + 1;
                    cell0.innerHTML = k;
                    cell1.innerHTML = step2[0];
                    cell2.innerHTML = step2[1];
                    cell3.innerHTML = step2[2];
                    cell4.innerHTML = step2[3];
                    cell5.innerHTML = step2[4];
                    cell6.innerHTML = step2[5];
                    cell7.innerHTML = step2[6];
                    cell8.innerHTML = step2[7];
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

//contact number validation
function contactValidation() {
    var contactNo = $('#phone').val();
    if (contactNo.length === 10) {
        return false;
    } else {
        alert("Invalid Contact Number");
        document.getElementById("phone").select();
        return true;
    }
}

function nicValidation() {
    var nic_no = $('#nic').val();


    if (nic_no.length === 12) {
        if (nic_no.includes("V") || nic_no.includes("v")) {
            alert("Invalid NIC Number!");
            document.getElementById("nic").select();
            return true;
        } else {
            return false;
        }
    } else if (nic_no.length === 10) {
        if (nic_no.includes("V") || nic_no.includes("v")) {
            return false;
        } else {
            alert("Invalid NIC Number!");
            document.getElementById("nic").select();
            return true;
        }
    } else {
        alert("Invalid NIC Number!");
        document.getElementById("nic").select();
        return true;
    }

}

function onClickValidatioeNIC(evt) {
    var theEvent = evt || window.event;

    // Handle paste
    if (theEvent.type === 'paste') {
        key = event.clipboardData.getData('text/plain');
    } else {
        // Handle key press
        var key = theEvent.keyCode || theEvent.which;
        key = String.fromCharCode(key);
    }
    var regex = /[0-9-Vv]|\./;
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

//Email validation
function ValidateEmail() {

    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test($('#email').val()))
    {
        return false;
    }
    alert("Invalid Email Address");
    document.getElementById("email").select();
    return true;

}