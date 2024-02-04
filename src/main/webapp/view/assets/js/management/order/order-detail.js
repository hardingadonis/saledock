//Ngày tạo
window.onload = function () {
    var input = document.getElementById('createAt');
    var date = new Date(input.value);
    input.value = date.toLocaleString();
};


const prices = document.getElementsByClassName("price");

for (let price of prices) {
    const amount = parseFloat(price.textContent || price.value);

    price.textContent = formatCurrencyVND(amount);
    price.value = formatCurrencyVND(amount);
}

function formatCurrencyVND(amount) {
    const formatter = new Intl.NumberFormat('vi-VN', {
        style: 'currency',
        currency: 'VND'
    });

    return formatter.format(amount);
}
