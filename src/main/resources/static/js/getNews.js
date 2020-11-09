function getNews() {
  // 1. Создаём новый объект XMLHttpRequest
var xhr = new XMLHttpRequest();

// 2. Конфигурируем его: GET-запрос на URL 'phones.json'
xhr.open('GET', '/getNews', true);
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
  div = document.createElement("div");
  div.setAttribute("class","news");
 title = document.createElement("h1");
 title.append(element.title);
 newsText = document.createElement("div");
 newsText.setAttribute("class","newsText");
 newsText.setAttribute("id",element.id);
 fullNewsText = document.createElement("div");
 fullNewsText.setAttribute("id","full_news"+element.id);
 fullNewsText.setAttribute("hidden","true");
 fullNewsText.append(element.text);

 miniNewsText = document.createElement("div");
  miniNewsText.setAttribute("id","mini_news"+element.id);
  miniNewsText.append(element.miniNews);

 newsText.append(fullNewsText,miniNewsText);
  img = document.createElement("img");
  img.setAttribute("src", element.image);
  openAll = document.createElement("span");
  openAll.setAttribute("onclick", "openFullNews("+element.id+")");
  openAll.append("Подробнее...");

  div.append(title);
  div.append(img);
  div.append(newsText);
  div.append(openAll);
document.getElementById("newses").append(div);


       });
}
}
xhr.send();
    }

var c = true;

    function openFullNews(id) {
    if (c) {
   openAll = document.createElement("span");
     openAll.setAttribute("onclick", "openFullNews("+id+")");
     openAll.append("Скрыть");
     event.currentTarget.replaceWith(openAll);
    document.getElementById("full_news"+id).removeAttribute("hidden");
    document.getElementById("mini_news"+id).setAttribute("hidden","true");
c = false;
    } else {
   openAll = document.createElement("span");
        openAll.setAttribute("onclick", "openFullNews("+id+")");
        openAll.append("Подробнее...");
      event.currentTarget.replaceWith(openAll);
      document.getElementById("full_news"+id).setAttribute("hidden","true");
        document.getElementById("mini_news"+id).removeAttribute("hidden");
    c = true;
    }

    }
