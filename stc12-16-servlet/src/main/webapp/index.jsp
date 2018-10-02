<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
<H1>Заголовок страницы</H1>
<p>
  Абзац текста
</p>
<div>
  <a href="/hello">Hello link</a><BR>
  <a href="/iterator">Iterator link</a><BR>
  <a href="/students">Students</a><BR><BR>


  <form method="post" action="/hello">
    <input type="text" name="testText">
    <input type="submit">
  </form>
  <BR><BR>
  <p>Форма добавления Города в табличку</p>
  <form method="post" action="/cities">
    <label>CityName <input type="text" name="CityName"></label><br>
    <label>Population <input type="text" name="Population"></label>
    <input type="submit">
  </form>

  <br><br><a href="/cities">Cities</a><BR><BR>
</div>
</body>
</html>