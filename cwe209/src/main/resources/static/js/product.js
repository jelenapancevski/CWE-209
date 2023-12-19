//add to bucket
     /*   add(amount)
{
    this.order = JSON.parse(sessionStorage.getItem("order"));
    if (this.order == null) {
        //new order
        this.order = new Order();
        this.order.buyer = this.user._id;
        this.order.date = new Date();
        this.order.notified = null;
        this.order.status = 'pending';
        this.order.products = [];
    }
    let found = false;
    this.order.products.forEach((product) => {
        if (product['productid'] == this.product._id) {
            product['amount'] += amount;
            found = true;
        }
    })
    if (!found) {
        this.order.products.push({"productid": this.product._id, "amount": amount});
    }
    sessionStorage.setItem("order", JSON.stringify(this.order));
    this.amount = null;
    this.message = "Proizvod je uspešno dodat u korpu!";

}*/