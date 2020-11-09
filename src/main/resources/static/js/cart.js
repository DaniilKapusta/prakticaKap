var c = false;
function openForm() {
if (!c) {
    c = true;
    document.getElementById("myForm").style.display = "block";
}
else {

c = false;
    document.getElementById("myForm").style.display = "none";
}
}
function addToCard(id) {
if (document.getElementById("card:"+id) === null) {

var div = document.createElement("div");
div.setAttribute("class","cart-product");
div.setAttribute("id", "card:"+id);

row1 = document.createElement("TR");
row2 = document.createElement("TR");
row3 = document.createElement("TR");
row4 = document.createElement("TR");
row1.append(document.getElementById(id).querySelector("td[name='image']").cloneNode(true));
div.append(row1);
td1 = document.createElement("TD");
td1.append("Название: ");
row2.append(td1);
row2.append(document.getElementById(id).querySelector("td[name='name']").cloneNode(true));
div.append(row2);
td2 = document.createElement("TD");
td2.append("Цена:");
row3.append(td2);
var price = document.getElementById(id).querySelector("td[name='price']").cloneNode(true);
row3.append(price);
//var priceCalc = parseFloat(price.substring(0, price.length - 1));
div.append(row3);
td3 = document.createElement("TD");
td3.append("Количество: ");
row4.append(td3);
var td4 = document.createElement("TD");
td4.setAttribute("name", "count");
var maxCount = document.getElementById(id).querySelector("td[name='count']").cloneNode(true).textContent;
var countSelect = document.createElement("input");
countSelect.setAttribute("type","number");
countSelect.setAttribute("max", maxCount);
countSelect.setAttribute("onkeypress","return false");
countSelect.setAttribute("Value","0");
countSelect.setAttribute("min", "0");
countSelect.setAttribute("onchange","calcCart()");
countSelect.setAttribute("name","productCount")
td4.append(countSelect);
row4.append(td4);

div.append(row4);
var row5 = document.createElement("tr");
var td5 = document.createElement("td");
var button = document.createElement("button");
button.setAttribute("onclick","deleteProduct("+id+")");
button.setAttribute("class", "deleteButton");
button.append("Удалить");
td5.append(button);
row5.append(td5);
div.append(row5);
document.getElementById("table-cart").append(div);
calcCart();
}
else {
alert("Товар уже в корзине");
}
}

function deleteProduct(id) {
document.getElementById("card:"+id).remove();
calcCart();
}

function calcCart() {
//var priceCalc = parseFloat(price.substring(0, price.length - 1));
var price;
var count;
var sum = 0.00;
var priceStr;

var productList = document.getElementsByClassName("cart-product");
Array.prototype.forEach.call(productList, function(element) {
priceStr = element.querySelector("tr td[name='price'] span").textContent;
price = parseFloat(priceStr);
count = parseFloat(element.querySelector("tr td[name='count'] input").value);
sum += price*count;
});
document.getElementById("cart-sum").value = Math.round((sum)*100)/100;
//alert(Math.round((sum)*100)/100);
}

