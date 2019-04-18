var btn = document.getElementById("views");
var card = document.getElementById("card");
var card3 = document.getElementById("card3");
btn.addEventListener("click", ()=>{
    card3.style.display ="block";
    card2.style.display ='none';
    card.style.display = "none";
})
var btn = document.getElementById("submit");
btn.addEventListener("click", ()=>{

    card3.style.display ="none";
    card2.style.display ='none';
    card.style.display = "block";
})
var combtn = document.getElementById("comment");
combtn.addEventListener("click", ()=>{
    card3.style.display ="none";
    card2.style.display ='block';
    card.style.display = "block";
})

var input = document.getElementById("input");
var button = document.getElementById("submit1");
var list = document.getElementById("list");
button.addEventListener("click", ()=>{
   list.insertAdjacentHTML('afterbegin', '<li id="comm" class="border border-dark rounded p-1">' + input.value + '</li>');
   card.style.display = "block";
   card3.style.display ="none";
   card2.style.display = "none";
   input.value = "";
})
