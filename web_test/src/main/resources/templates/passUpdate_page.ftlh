<!doctype html>

<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div>

    <h1>Восстановление пароля</h1>
    <br>
    <h2>Введите новый пароль</h2>


    <br>


    <br>
    <form action="/enterNewPass?${idUser}" method="post">


        <label>Name</label><br>

        <input name="pass1"  placeholder="Новый пароль">
        <br>
        <input name="pass2" placeholder="Подтвердите новый пароль">
        <br>
        <button type="submit">Обновить пароль</button>
    </form>
</div>

</body>
</html>