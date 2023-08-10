// *------- For Home Page -------*/



    // document.getElementById("registerbtn").addEventListener("click", function (){
    //     fetch("/login")
    //         .then(response => response.text())
    //         .then(result => {
    //             console.log(result);
    //         });
    // });

function registerbtn(){
    window.location.href="/signup/signup"
}


function optionbtn() {
    var pages = [
        "weightlifting.html",
        "boxing.html",
        "calisthenics.html"
    ];
    var current = 0;
    var button = document.getElementById("myButton");

    button.addEventListener("click", function() {
        current++;
    
        if (current >= pages.length) {
            current = 0;
        }
        window.location.href = pages[current];
    });
    
    
}





function fn(){
    let checkboxes = document.querySelectorAll("input[type='checkbox']");

    for (let i = 0; i < checkboxes.length; i++) {
        checkboxes[i].addEventListener("change", function() {
        for (let j = 0; j < checkboxes.length; j++) {
        if (checkboxes[j] !== this) {
            checkboxes[j].checked = false;
        }
    }
});
}
}

// ---------PopUp------- //
function openForm() {
    var form=document.getElementById("myform")
    form.classList.toggle('active');
    var blur =document.getElementById("ass");
    blur.classList.toggle('active');
    // var close=document.getElementById("myform")
    // close.classList.toggle('close')
}

function print(){
    var p=document.getElementById("list").value;
    var f=document.getElementById("myform")
    var blur =document.getElementById("ass")
    // for (let index = 0; index < p.length; index++) {
    //     var element = p[index];
    //     console.log(element);
    //     if(a=="Weightlifting"){
    //         console.log("yes")
    //     }else(
    //         console.log("no")
    //     )
    // }
    
    if(p="Weightlifting"){
        f.classList.toggle('active')
        blur.classList.toggle('active');
        alert("Registered Successfully for Weightlifting");

        
    }else{
        alert("")
    }


}

  
  
