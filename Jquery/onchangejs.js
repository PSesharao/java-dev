$(document).ready(function () {
    var result = '';
    $('.inputfield').change(function () {
      if (result == '' ) {
          result += $(this).val();
      }
      else {
          result += '<br>' + $(this).val();
      }

      $('#divResult').html(result);
      //$('#divResult').html("<br>");
      // result = '';
  });
});