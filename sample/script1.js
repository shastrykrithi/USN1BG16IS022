document.getElementById('btn').onmouseover=changeOnMouseOver;
document.getElementById('btn').onmouseout=chnageout;
function changeOnMouseOver(){
   var but=document.getElementById('btn');
   but.style.background="green";
}
function chnageout(){
    var but=document.getElementById('btn');
   but.style.background="yellow";
}
document.querySelector('#hid').textContent="WELCOME";