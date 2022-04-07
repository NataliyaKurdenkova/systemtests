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
    <div>Данный тест содержит ${kolvo} вопросов.</div>
    <div>Проходной балл ${ball}.</div>
    <div>Время на тест ограниченно и составляет ${time}.</div>

    <div>
        <form action="/start" method="post">
            <input type="submit" value="Начать тест">
        </form>

    </div>
</section>
</body>
</html>