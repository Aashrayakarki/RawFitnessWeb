
    function validateForm() {
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    if (email == "" || password == "") {
    alert("Email and password must be filled out");
    return false;
}
    return true;
}
