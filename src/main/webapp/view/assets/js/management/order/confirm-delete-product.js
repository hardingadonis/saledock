/* global Swal */

function confirmDelete(productId) {
    Swal.fire({
        title: "Bạn có chắc chắn muốn xoá sản phẩm ra khỏi đơn hàng?",
        text: "Bạn không thể khôi phục lại được!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Vâng, Xoá nó!"
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                type: "GET",
                url: "./add-order?action=delete&productId=" + productId,
                data: {productId: productId},
                success: function (response) {
                    Swal.fire({
                        title: "Xoá thành công!",
                        text: "Sản phẩm đã được xoá.",
                        icon: "success"
                    }).then(() => {
                        location.reload();
                    });
                },
                error: function (error) {
                    console.error("Lỗi xoá sản phẩm:", error);
                }
            });
        }
    });
}
