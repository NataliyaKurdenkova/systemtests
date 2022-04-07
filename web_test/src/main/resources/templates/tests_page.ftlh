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
<div>
<table>
    <tr>
        <th>№</th>
        <th>Название</th>
        <th>Проходной балл</th>
        <th>Общее количество вопросов</th>
        <th>Количество вопросов, для тестирования</th>
        <th>Время</th>
    </tr>
    <#list tests as test>
        <tr>
            <td>${test.idtest}</td>
            <td>${test.name}</td>
            <td>${test.passball}</td>
            <td>${test.totalque}</td>
            <td>${test.needque}</td>
            <td>${test.time}</td>
            <td><form action="/pass_test/${test.idtest}" method="post"><input type="submit" value="Пройти"></form></td>
        </tr>
    </#list>
</table>

</div>
</body>
</html>