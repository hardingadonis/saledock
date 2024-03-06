$(document).ready(function () {
    $('#update-product').on('submit', function (e) {
        e.preventDefault();

        var formData = new FormData(this);

        $.ajax({
            type: 'POST',
            url: $(this).attr('action'),
            data: formData,
            processData: false,
            contentType: false,
            success: function (response) {
                Swal.fire({
                    title: 'Thành công!',
                    text: 'Cập nhật sản phẩm thành công',
                    icon: 'success',
                    timer: 1500
                }).then((result) => {
                    if (result.dismiss === Swal.DismissReason.timer) {
                        console.log('I was closed by the timer')
                    }
                    window.location.href = 'product';
                });

                setTimeout(function () {
                    window.location.href = 'product';
                }, 1500);
            },
            error: function (response) {

            }
        });
    });
});