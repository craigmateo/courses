var start, end;
var time;
var yellow_angle = 0;
var red_angle = 0;
var view = 0;

$('.shape').mouseout(function(){
    time=0;
});

// Get id on mouseover

$('.shape').mouseover(function() {
 var id=this.id;
 
//Make the DIV element draggable:
dragElement(document.getElementById((id)));  
function dragElement(elmnt) {
  var pos1 = 0, pos2 = 0, pos3 = 0, pos4 = 0;
  if (document.getElementById(elmnt.id + "")) {
    /* if present, the header is where you move the DIV from:*/
    document.getElementById(elmnt.id + "").onmousedown = dragMouseDown;
  } else {
    /* otherwise, move the DIV from anywhere inside the DIV:*/
    elmnt.onmousedown = dragMouseDown;
  }

  function dragMouseDown(e) {
    start = +new Date();
    e = e || window.event;
    // get the mouse cursor position at startup:
    pos3 = e.clientX;
    pos4 = e.clientY;
    document.onmouseup = closeDragElement;
    // call a function whenever the cursor moves:
    document.onmousemove = elementDrag;
  }

  function elementDrag(e) {
    e = e || window.event;
    // calculate the new cursor position:
    pos1 = pos3 - e.clientX;
    pos2 = pos4 - e.clientY;
    pos3 = e.clientX;
    pos4 = e.clientY;
    // set the element's new position:
    elmnt.style.top = (elmnt.offsetTop - pos2) + "px";
    elmnt.style.left = (elmnt.offsetLeft - pos1) + "px";
  }

  function closeDragElement() {
    /* stop moving when mouse button is released:*/
    document.onmouseup = null;
    document.onmousemove = null;
    end = +new Date();
    time = end-start;
    //console.log(time);
    if(time<120) {
      rotate();
    start=0;
    end=0;  
    time=0;  
    } 
  }
}
  
function rotate() {
  //console.log("rotate!")
  var angle = 90;
  $('#'+id).css('transform','rotate(' + red_angle + 'deg)');
  
  red_angle = red_angle+angle;
  console.log(red_angle);
  }  
}); 

function rearrange() {
if(view==0) {
  $('#blue').css("left", "547px");
  $('#blue').css("top", "100px");
  $('#green').css("left", "548px");
  $('#green').css("top", "500px");
  $('#red').css("width", "150px");
  $('#red').css("height", "400px");
  $('#red').css("clip-path","polygon(0% 0%, 100% 0%, 100% 100%)");
  $('#red').css("left", "647px");
  $('#red').css("top", "350px");
  $('#yellow').css("width", "150px");
  $('#yellow').css("height", "400px");
  $('#yellow').css("clip-path","polygon(0% 0%, 0% 100%, 100% 100%)");
  $('#yellow').css("left", "547px");
  $('#yellow').css("top", "100px");
  $('#eq1').css("left", "248px");
  document.getElementById("eq1").innerHTML="<math>"+"13 &times; 5 = 65"+"</math>";
  document.getElementById("length").innerHTML=13;
  document.getElementById("width").innerHTML=5;
  $('#length').css("left", "475px");
  $('#width').css("left", "650px");
  }
  
  if (view==1) {  
  $('#blue').css("left", "297px");
  $('#blue').css("top", "99px");
  $('#green').css("left", "148px");
  $('#green').css("top", "99px");
  $('#red').css("width", "400px");
  $('#red').css("height", "150px");
  $('#red').css("clip-path","polygon(100% 0, 0% 100%, 100% 100%)");
  $('#red').css("left", "148px");
  $('#red').css("top", "348px");
  $('#yellow').css("width", "400px");
  $('#yellow').css("height", "150px");
  $('#yellow').css("clip-path","polygon(0% 0%, 0% 100%, 100% 0%)");
  $('#yellow').css("left", "148px");
  $('#yellow').css("top", "348px");
  document.getElementById("eq1").innerHTML="<math>"+"8 &times; 8 = 64"+"</math>";
  $('#eq1').css("left", "737px");
  $('#eq1').css("top", "25px");  
    document.getElementById("length").innerHTML=8;
  document.getElementById("width").innerHTML=8;  
  $('#length').css("left", "557px");
    $('#length').css("top", "237px");
    $('#width').css("left", "337px");
  }
  if (view==0) {
    view=1;
  }
  else {
    view=0;
  }
  
};