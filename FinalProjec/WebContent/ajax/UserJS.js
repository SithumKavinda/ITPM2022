selectedRowToInput();
function selectedRowToInput() {
    var table = document.getElementById('table'), rIndex;
    for (var i = 1; i < table.rows.length; i++) {
        table.rows[i].onclick = function () {
            rIndex = this.rowIndex;
            document.getElementById("user_id").value = this.cells[1].textContent;
            document.getElementById("name").value = this.cells[2].textContent;
            document.getElementById("email").value = this.cells[3].textContent;
            document.getElementById("phone").value = this.cells[4].textContent;
            document.getElementById("username").value = this.cells[5].textContent;
            document.getElementById("password").value = this.cells[6].textContent;
        };
    }
}

function save() {
    var user_id = $('#user_id').val();
    var name = $('#name').val();
    var email = $('#email').val();
    var phone = $('#phone').val();
    var username = $('#username').val();
    var password = $('#password').val();
    var action = "insert";
    if (user_id === "" || name === "" || email === "" || phone === "" || username === "" || password === "") {
        alert("Please Enter All Details")
    } else if (ValidateEmail() || contactValidation()) {

    } else {
        $.ajax({
            url: 'UserServlet',
            method: 'POST',
            data: {action: action, user_id: user_id, name: name, email: email, phone: phone, username: username, password: password},
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
    var user_id = $('#user_id').val();
    var name = $('#name').val();
    var email = $('#email').val();
    var phone = $('#phone').val();
    var username = $('#username').val();
    var password = $('#password').val();
    var action = "update";
    user_id = parseInt(user_id);
    if (user_id === 0) {
        alert("Please Select to Update")
    } else if (user_id === "" || name === "" || email === "" || phone === "" || username === "" || password === "") {
        alert("Please Enter All Details")
    } else if (ValidateEmail() || contactValidation()) {

    } else {
        $.ajax({
            url: 'UserServlet',
            method: 'POST',
            data: {action: action, user_id: user_id, name: name, email: email, phone: phone, username: username, password: password},
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
    var user_id = $('#user_id').val();
    var action = "delete";
    user_id = parseInt(user_id);
    if (user_id === 0) {
        alert("Please Select to Update")
    } else {
        var r = confirm("Are you Sure?");
        if (r == true) {
            $.ajax({
                url: 'UserServlet',
                method: 'POST',
                data: {action: action, user_id: user_id},
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
        url: 'UserServlet',
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