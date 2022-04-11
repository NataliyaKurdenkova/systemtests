<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>Система тестирования</h1>
<section>
    <div>
        <table>
            <p> Добро пожаловать, ${name} !</p>
            <p>Выход </p>
        </table>
    </div>
    <div>
        <p>${nametest}</p>
    </div>
    <div>${msg}</div>
    <div>Время прохождения теста ${time}.</div>
    <div> Набрали ${ball} баллов.</div>

    <div>
        <form action="/start" method="post">
            <input type="submit" value="Пройти заново">
        </form>

    </div>
    <div>
        <form action="/lich_page" method="post">
            <input type="submit" value="Вернуться на Главную страницу">
        </form>

    </div>
</section>
</body>
</html>