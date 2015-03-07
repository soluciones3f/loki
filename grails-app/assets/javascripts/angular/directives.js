'use strict';

/* Directives */
angular.module('loki.directives', ["loki.services"])

/**
 * dummy directive
 */
  .directive("dummyDirective", ["$injector", "$log", function($injector, $log) {
    return {
      // require: "ngModel",
      restrict: "A",
      // transclude: true,

      link: function(scope, element, attrs) {
        $log.debug("log", scope, element, attrs);

      }
    }
  }])

  // Generate a Excel with the model information
  .directive("lokiExport", [function() {

    // Abstraction to create a Workbook
    var Workbook = function() { this.Sheets = {}, this.SheetNames = []; }
    Workbook.prototype.addSheet = function( name, worksheet ) { 
      this.Sheets[name] = worksheet;
      this.SheetNames.push(name);
    }
    Workbook.prototype.save = function(filename) {
      function s2ab(s) {
        var buf = new ArrayBuffer(s.length);
        var view = new Uint8Array(buf);
        for (var i=0; i!=s.length; ++i) view[i] = s.charCodeAt(i) & 0xFF;
        return buf;
      }

      var wbout = XLSX.write(this, {bookType:'xlsx', bookSST:true, type: 'binary'}); 
      saveAs(new Blob([s2ab(wbout)],{type:"application/octet-stream"}), filename);
    }

    // Abstraction to create a Worksheet
    var Worksheet = function() {  }
    Worksheet.prototype.setCell = function( ref, value ) {
      this[ref] = { v: value, t: "s" }
      if(typeof value == "number") this[ref].t = "n"
    }

    function generateWorkbook(data) {

      // Create a workbook with a worksheet
      var workbook = new Workbook();
      var worksheet = new Worksheet();
      workbook.addSheet("Sheet1", worksheet);

      // Set spreadsheet headers
      worksheet.setCell( "A1", "Fecha" );
      worksheet.setCell( "B1", "Horas" );
      worksheet.setCell( "C1", "Usuario" );
      worksheet.setCell( "D1", "Id Proyecto" );
      worksheet.setCell( "E1", "Nombre Proyecto" );

      // Send other Rows
      for(var row = 0; row < data.length; row++ ) {
        worksheet.setCell( "A" + (row+2), data[row].date );
        worksheet.setCell( "B" + (row+2), data[row].hours );
        worksheet.setCell( "C" + (row+2), data[row].username )
        worksheet.setCell( "D" + (row+2), data[row].project.id )
        worksheet.setCell( "E" + (row+2), data[row].project.name )
      }

      // Set spreedsheet range
      worksheet["!ref"]  = "A1:E" + (data.length+1);

      // Download excel file
      workbook.save("test.xlsx");
    }

    function linkFunction(scope, element, attrs) {
      element.click(function() {
        generateWorkbook(scope.lokiExport)
      })
    };

    return {
      scope: { lokiExport: "=" },
      link: linkFunction
    }
  }])

;

