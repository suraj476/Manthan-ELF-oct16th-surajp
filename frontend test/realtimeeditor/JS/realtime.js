function compile() {
    var html = document.getElementById("html");
    var code = document.getElementById("code").contentWindow.document;
  
    document.body.onkeyup = function() {
      code.open();
      code.writeln(
        html.value +
          "<style>" 
      );
      code.close();
    };
  }
  
  compile();