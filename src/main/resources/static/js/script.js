function qq(table){
  // 1. Создаём новый объект XMLHttpRequest
var xhr = new XMLHttpRequest();


xhr.open('GET', '/getProductsData', true);
xhr.responseType = "json";
// 3. Отсылаем запрос
xhr.onload = function() {

// 4. Если код ответа сервера не 200, то это ошибка
if (xhr.status != 200) {
  // обработать ошибку
  alert( xhr.status + ': ' + xhr.statusText ); // пример вывода: 404: Not Found
} else {
  // вывести результат
 
  // Создаем строку таблицы и добавляем ее
  xhr.response.forEach(element => {
      

  var row = document.createElement("TR");
  table.appendChild(row);

  // Создаем ячейки в вышесозданной строке
  // и добавляем тх
  var td1 = document.createElement("TD");
  td1.setAttribute("name","image");
  var td2 = document.createElement("TD");
  td2.setAttribute("name","name");
  var td3 = document.createElement("TD");
  td3.setAttribute("name","price");
  var td4 = document.createElement("TD");
  td4.setAttribute("name","count");
  row.setAttribute("id",element.id);


  row.appendChild(td1);
  row.appendChild(td2);
  row.appendChild(td3);
  row.appendChild(td4);


  // Наполняем ячейки
  td1.innerHTML = ("<img src = "+element.image+" ></img>");
  td2.innerHTML = element.productName;
  td3.innerHTML = "<span>"+element.price+"</span>$";
  td4.innerHTML = (element.productCount);


  buttonTable = document.createElement("TR");
  table.appendChild(buttonTable);
  buttonTable.innerHTML ="<td style='border: none;'><button  onclick = 'addToCard("+element.id+");'>Добавить</button></td>";
});
}
}
xhr.send();
    }