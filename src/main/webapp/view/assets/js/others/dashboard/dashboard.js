let chartOrderBySold = null;
let chartOrderByStatus = null;
let chartCustomerTop10 = null;
let chartProductTop10 = null;

const API_ENDPOINT = "api/v1/";

let backgroundColor = [
    "rgba(255, 99, 132, 0.5)",
    "rgba(255, 159, 64, 0.5)",
    "rgba(255, 205, 86, 0.5)",
    "rgba(75, 192, 192, 0.5)",
    "rgba(54, 162, 235, 0.5)"
];

let borderColor = [
    "rgb(255, 99, 132)",
    "rgb(255, 159, 64)",
    "rgb(255, 205, 86)",
    "rgb(75, 192, 192)",
    "rgb(54, 162, 235)"
];

document.addEventListener("DOMContentLoaded", function () {
    initChart();
});

let duration = document.getElementById("duration");

duration.addEventListener("change", function () {
    initChart();
});

function initChart() {
    initChartOrderBySold();
    initChartOrderByStatus();
    initChartCustomerTop10();
    initChartProductTop10();
}

function initChartOrderBySold() {
    if (chartOrderBySold) {
        chartOrderBySold.destroy();
    }

    fetch(API_ENDPOINT + "order?by=sold&duration=" + duration.value, {
        method: "GET"
    }).then((response) => response.json()).then((data) => {
        let ctx = document.getElementById("order-by-sold").getContext("2d");
        let delayed;

        chartOrderBySold = new Chart(ctx, {
            type: "bar",
            data: {
                labels: data.labels,
                datasets: [
                    {
                        label: "Đơn hàng",
                        data: data.dataset,
                        backgroundColor: backgroundColor,
                        borderColor: borderColor,
                        borderWidth: 1,
                        fill: false
                    }
                ]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                scales: {
                    y: {
                        beginAtZero: true
                    }
                },
                animation: {
                    onComplete: () => {
                        delayed = true;
                    },
                    delay: (context) => {
                        let delay = 0;
                        if (
                                context.type === "data" &&
                                context.mode === "default" &&
                                !delayed
                                ) {
                            delay = context.dataIndex * 300 + context.datasetIndex * 100;
                        }
                        return delay;
                    }
                }
            }
        });

        console.log("initChartOrderBySold");
    }).catch((error) => console.error("Error fetching data:", error));
}

function initChartOrderByStatus() {
    if (chartOrderByStatus) {
        chartOrderByStatus.destroy();
    }

    fetch(API_ENDPOINT + "order?by=status&duration=" + duration.value, {
        method: "GET"
    }).then((response) => response.json()).then((data) => {
        let ctx = document.getElementById("order-by-status").getContext("2d");
        let delayed;

        chartOrderByStatus = new Chart(ctx, {
            type: "doughnut",
            data: {
                labels: data.labels,
                datasets: [
                    {
                        label: "Đơn hàng",
                        data: data.dataset,
                        backgroundColor: backgroundColor,
                        borderColor: borderColor,
                        borderWidth: 1,
                        fill: false
                    }
                ]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                animation: {
                    onComplete: () => {
                        delayed = true;
                    },
                    delay: (context) => {
                        let delay = 0;
                        if (
                                context.type === "data" &&
                                context.mode === "default" &&
                                !delayed
                                ) {
                            delay = context.dataIndex * 300 + context.datasetIndex * 100;
                        }
                        return delay;
                    }
                }
            }
        });

        console.log("initChartOrderByStatus");
    }).catch((error) => console.error("Error fetching data:", error));
}

function initChartCustomerTop10() {
    if (chartCustomerTop10) {
        chartCustomerTop10.destroy();
    }

    fetch(API_ENDPOINT + "customer?duration=" + duration.value, {
        method: "GET"
    }).then((response) => response.json()).then((data) => {
        let ctx = document.getElementById("customer-top-10").getContext("2d");
        let delayed;

        chartCustomerTop10 = new Chart(ctx, {
            type: "bar",
            data: {
                labels: data.labels,
                datasets: [
                    {
                        label: "Tổng số đơn hàng đã mua",
                        data: data.dataset,
                        backgroundColor: backgroundColor,
                        borderColor: borderColor,
                        borderWidth: 1,
                        fill: false
                    }
                ]
            },
            options: {
                indexAxis: "y",
                responsive: true,
                maintainAspectRatio: false,
                scales: {
                    y: {
                        beginAtZero: true
                    }
                },
                animation: {
                    onComplete: () => {
                        delayed = true;
                    },
                    delay: (context) => {
                        let delay = 0;
                        if (
                                context.type === "data" &&
                                context.mode === "default" &&
                                !delayed
                                ) {
                            delay = context.dataIndex * 300 + context.datasetIndex * 100;
                        }
                        return delay;
                    }
                }
            }
        });

        console.log("initChartCustomerTop10");
    }).catch((error) => console.error("Error fetching data:", error));
}

function initChartProductTop10() {
    if (chartProductTop10) {
        chartProductTop10.destroy();
    }

    fetch(API_ENDPOINT + "product?duration=" + duration.value, {
        method: "GET"
    }).then((response) => response.json()).then((data) => {
        let ctx = document.getElementById("product-top-10").getContext("2d");
        let delayed;

        chartProductTop10 = new Chart(ctx, {
            type: "bar",
            data: {
                labels: data.labels,
                datasets: [
                    {
                        label: "Sản phẩm",
                        data: data.dataset,
                        backgroundColor: backgroundColor,
                        borderColor: borderColor,
                        borderWidth: 1,
                        fill: false
                    }
                ]
            },
            options: {
                indexAxis: "y",
                responsive: true,
                maintainAspectRatio: false,
                scales: {
                    y: {
                        beginAtZero: true
                    }
                },
                animation: {
                    onComplete: () => {
                        delayed = true;
                    },
                    delay: (context) => {
                        let delay = 0;
                        if (
                                context.type === "data" &&
                                context.mode === "default" &&
                                !delayed
                                ) {
                            delay = context.dataIndex * 300 + context.datasetIndex * 100;
                        }
                        return delay;
                    }
                }
            }
        });

        console.log("initChartProductTop10");
    }).catch((error) => console.error("Error fetching data:", error));
}
