function defaultThings() {
    var nameErr = document.getElementById("nameError");
    var discountErr = document.getElementById("discountError");
    var priceErr = document.getElementById("priceError");
    
    nameErr.style.display = "none";
    discountErr.style.display = "none";
    priceErr.style.display = "none";
}

function showNameErr() {
    var nameErr = document.getElementById("nameError");
    nameErr.style.display = "flex";
}

function showDiscountErr() {
    var discountErr = document.getElementById("discountError");
    discountErr.style.display = "flex";
}

function showPriceErr() {
    var priceErr = document.getElementById("priceError");
    priceErr.style.display = "flex";
}

// Validations

function validateName() {
    var serviceName = document.getElementById("text-input")
    var nameErr = document.getElementById("nameError")

    if(serviceName.value == '' || serviceName.value == null){
        let errorText = "Name cannot leave empty"
        nameErr.innerText = errorText
        showNameErr()
        serviceName.style.border = "1px solid red"
    } else {
        nameErr.style.display = "none"
        serviceName.style.border = "none"
    }
}

function validateDiscount() {
    var discountErr = document.getElementById("discountError")
    var discount = document.forms['insertForm']['discount']

    if (discount.value == null || discount.value == '') {
        let errorText = 'Discount cannot leave empty'
        discountErr.innerText = errorText
        showDiscountErr()
        discount.style.border = '1px solid red'
    } else if (discount.value > 50) {
        let errorText = 'Discount cannot exceed 50%'
        discountErr.innerText = errorText
        showDiscountErr()
        discount.style.border = '1px solid red'
    } else {
        discountErr.style.display = "none"
        discount.style.border = "none"
    }
}

function validatePrice() {
    var priceErr = document.getElementById("priceError")
    var price = document.forms['insertForm']['price']

    if(price.value == '' || price.value == null) {
        let errorText = 'Price cannot leave empty'
        priceErr.innerText = errorText
        showPriceErr()
        price.style.border = '1px solid red'
    } else if(price.value < 0) {
        let errorText = 'Price should be greater than 0'
        priceErr.innerText = errorText
        showPriceErr()
        price.style.border = '1px solid red'
    } else {
        priceErr.style.display = 'none'
        price.style.border = 'none'
    }
}

function validateForm() {
    
    var serviceName = document.forms['insertForm']['serviceName'].value
    var discount = document.forms['insertForm']['discount'].value
    var price = document.forms['insertForm']['price'].value

    if(serviceName != null && serviceName != '' && discount != null && discount != '' && price != null && price != '') {
        return true
    }

    return false
}