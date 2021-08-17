
var Name=/^[A-Z]{1}[a-z]{1,9}$/;
$('#userName').on('keydown',function (event) {
    var input=(event.key);
    let inputName=$('#userName').val();
    if (Name.test(inputName)){
        if (input=="Enter"){
            $('#email').focus();
        }
    }else {
        // $('#custName').css('border','2px solid red');
        $('#userName').focus();
    }
});

var Email=/^[a-z]{1,19}(@gmail.com)$/;
$('#email').on('keydown',function (event) {
    var input=(event.key);
    let inputName=$('#email').val();
    if (Email.test(inputName)){
        if (input=="Enter"){
            $('#address').focus();
        }
    }else {
        $('#email').focus();
    }
});

var Adrees=/^[a-z]{1,30}$/;
$('#address').on('keydown',function (event) {
    var input=(event.key);
    let inputAddress=$('#address').val();
    if (Adrees.test(inputAddress)){
        if (input=="Enter"){
            $('#contact').focus();
        }
    }else {
        $('#address').focus();
    }
});

$('#phone').on('keydown',function (event) {
    var input=(event.key);
        if (input=="Enter"){
            $('#password').focus();
        }
    else {
        $('#phone').focus();
    }
});

var Password=/^[a-z]{6}$/;
$('#password').on('keydown',function (event) {
    var input=(event.key);
    let password=$('#password').val();
    if (Password.test(password)){
        if (input=="Enter"){
            // $('#password').focus();
        }
    }else {
        $('#password').focus();
    }
});
