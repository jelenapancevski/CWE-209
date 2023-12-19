function updateOrderAndNavigate() {
    // Retrieve the object from session storage
    var orderFromSession = JSON.parse(sessionStorage.getItem("order"));

    // Get CSRF token from the meta tag
    var csrfToken = document.querySelector('meta[name="_csrf"]').content;
    var csrfHeaderName = document.querySelector('meta[name="_csrf_header"]').content;

    // Create a hidden form and add the order as a hidden input
    var form = document.createElement("form");
    form.method = "post";
    form.action = "/sendOrder";

    // Add CSRF token to the request headers
    var headers = {
        'Content-Type': 'application/json',
        [csrfHeaderName]: csrfToken,
        // Other headers...
    };

    // Create a hidden input for the order
    var input = document.createElement("input");
    input.type = "hidden";
    input.name = "order";
    input.value = JSON.stringify(orderFromSession);

    // Append input to the form
    form.appendChild(input);

    // Append the form to the body
    document.body.appendChild(form);

    // Submit the form
    fetch('/sendOrder', {
        method: 'POST',
        headers: headers,
        body: JSON.stringify(orderFromSession),
    })
        .then(response => {
            // Handle the response as needed
            console.log('Order sent successfully');
            // Optionally, you can redirect to another page after the order is sent
            //window.location.href = '/basket';
        })
        .catch(error => {
            console.error('Error sending order:', error);
            // Handle errors
        });
}

/*var loggeduser;
function showdate(date) {
    let newdate = new Date(date);
    let dates = (newdate.getDate() < 10) ? '0' + newdate.getDate() : newdate.getDate();
    dates += "/";
    dates += ((newdate.getMonth() + 1) < 10) ? '0' + (newdate.getMonth() + 1) : "" + (newdate.getMonth() + 1);
    dates += "/" + newdate.getFullYear();
    return dates;
}

map: Map<string, Product> = new Map();
function initMap() {
    this.order.totalprice = 0;
    this.order.products.forEach(product => {
        this.productService.product(product['productid']).subscribe((prod: Product) => {
            this.map.set(product['productid'], prod);
            this.order.totalprice += JSON.parse(product['amount']) * this.map.get(product['productid']).price;
        })
    });
}
function calctotalprice() {

    this.order.totalprice = 0;
    this.order.products.forEach(product => {
        this.productService.product(product['productid']).subscribe((prod: Product) => {
            this.map.set(product['productid'], prod);
            this.order.totalprice += JSON.parse(product['amount']) * this.map.get(product['productid']).price;
        })
    });


}

*/

/*

    send()
{
    this.orderService.add(this.order).subscribe((message: String) => {
        sessionStorage.removeItem('order');
        document.location.reload();
    })
}

*/