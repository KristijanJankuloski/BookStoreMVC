console.log("Script:-");
let addToCartButtons = document.querySelectorAll(".btn-add-to-cart");
addToCartButtons.forEach(button => {
    button.addEventListener('click', () => {
        let productId = button.id.split("-")[1];
        console.log(`Button product id:-${productId}`);
        fetch("/shoppingCart/add", {
            method:"POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                id: productId
            })
        }).then(response => response.json())
            .then(data => {
                console.log(data);
        }).catch(err => console.log(err));
    });
});