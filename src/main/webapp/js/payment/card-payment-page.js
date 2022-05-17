var nameError = $('#nameError')
var numberError = $('#numberError')
var expError = $('#expError')
var cvvError = $('#cvvError')

$(document).ready(function () {
    nameError.hide()
    numberError.hide()
    expError.hide()
    cvvError.hide()
});

// name validation
$('#user-name').on('input', function () {
    var name = $(this).val();
    
    if(name == null || name == '') {
        nameError.text('Card holder\'s name can\'t leave empty')
        nameError.show()
        $(this).css('border', '1px solid red')
    } else {
        nameError.text('')
        nameError.hide()
        $(this).css('border', 'none')
    }
});

// card number validation
$('#card-number').on('input', function () {
    var number = $(this).val();

    if(number == null || number == '') {
        numberError.text('Card number can\'t leave empty')
        numberError.show()
        $(this).css('border', '1px solid red')
    } else if (number.length != 16) {
        $(this).css('color', 'red')
        $(this).css('border', '1px solid red')
    }
    else {
        numberError.text('')
        numberError.hide()
        $(this).css('color', 'green')
        $(this).css('border', 'none')
    }
});

$('#card-number').on('change', function () {
    $(this).css('color', 'black')
});

// month validation
$('#month').on('input', function () {
    var month = $(this).val()

    if(month == null || month == '') {
        expError.text('Month can\'t leave empty')
        expError.show()
        $(this).css('border', '1px solid red')
    } else if(month > 12) {
        expError.text('Month can\'t exceed 12')
        expError.show()
        $(this).css('color', 'red')
        $(this).css('border', '1px solid red')
    }
    else {
        expError.text('')
        expError.hide()
        $(this).css('color', 'black')
        $(this).css('border', 'none')
    }
});

// year validation
$('#year').on('input', function () {
    var year = $(this).val()

    if(year == null || year == '') {
        expError.text('Year can\'t leave empty')
        expError.show()
        $(this).css('border', '1px solid red')
    } else if(year < 2022 || year > 2100) {
        expError.text('Invalid year')
        expError.show()
        $(this).css('color', 'red')
        $(this).css('border', '1px solid red')
    }
    else {
        expError.text('')
        expError.hide()
        $(this).css('color', 'black')
        $(this).css('border', 'none')
    }
});

// cvv validation
$('#cvv').on('input', function () {
    var cvv = $(this).val()

    if(cvv == null || cvv == '') {
        cvvError.text('cvv can\'t leave empty')
        cvvError.show()
        $(this).css('border', '1px solid red')
    } else if(cvv < 100 || cvv > 999) {
        cvvError.text('Invalid cvv')
        cvvError.show()
        $(this).css('color', 'red')
        $(this).css('border', '1px solid red')
    }
    else {
        cvvError.text('')
        cvvError.hide()
        $(this).css('color', 'black')
        $(this).css('border', 'none')
    }
});

// submit validation
$('#card-payment-form').submit(function (e) { 
    
    var name = $('#user-name').val()
    var num = $('#card-number').val()
    var month = $('#month').val()
    var year = $('#year').val()
    var cvv = $('#cvv').val()

    if (name == null || name == '') {
        e.preventDefault()
    } else if (num == null || num == '') {
        e.preventDefault()
    } else if (month == null || month == '') {
        e.preventDefault()
    } else if (year == null || year == '') {
        e.preventDefault()
    } else if (cvv == null || cvv == '') {
        e.preventDefault()
    } else if(num.length != 16) {
        e.preventDefault()
    } else if (month > 12) {
        e.preventDefault()
    } else if (year < 2022 || year > 2100) {
        e.preventDefault()
    } else if (cvv < 100 || cvv > 999) {
        e.preventDefault()
    } else {
        
    }
});