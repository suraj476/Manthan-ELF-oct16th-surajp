var colours =[ 	"#D2691E","#FF7F50", "#6495ED","#FFF8DC","#DC143C","#00FFFF","#00008B",
 "#008B8B","#B8860B", "#A9A9A9","#006400","#BDB76B","#8B008B" ]
 var variable;
 variable =0;
 document.querySelector("button").addEventListener("click",
  function()
  {
   variable = variable < colours.length ? ++variable : 0;
   document.querySelector("body").style.background = colours[variable]
  })