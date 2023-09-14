$(function() {
  $('.changeButton').on('click', function() {
      let form = $(this).closest('.changeForm');
      let statusCell = form.parent().siblings('.statusCell');
      let formData = form.serialize();
      $.ajax({
          type: 'POST',
          url: '/changeStatus',
          data: formData,
          success: function(response) {
              statusCell.html('<span class="badge rounded-pill bg-success">完了</span>');
              form.empty();
          },
          error: function(error) {
              console.error(error);
          }
      });
  });
});