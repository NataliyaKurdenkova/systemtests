<!doctype html>
<html lang="ru" xmlns:form="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Test</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700;800&display=swap');
    </style>
    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/main.min.css">
</head>
<body>
<header>
    <div class="header-container">
        <div class="header-rows header-rows-1">
            <div class="header-logo">
                <img class="header-logo-img" src="../img/logo.svg" alt="logo">
            </div>
            <div class="header-title">
                <img class="header-title-image" src="../img/Title.png" alt="title-img">
                <img class="right-img" src="../img/right-img.svg" alt="img">
            </div>
        </div>
        <div class="header-rows header-rows-4">
            <div class="header-columns-output">
                <p class="header-columns-output-p" id="FIO-output">${name}</p>
            </div>
            <div class="header-columns-exit">
                <form action="/logout" method="post">
                    <input class="header-columns-exit-input" type="submit" value="Выход">
                </form>
            </div>
        </div>
    </div>
</header>
<section class="result-container grid">
    <div class="result-question-testname ffs">Название теста: {testname}</div>
    <div class="result-question-container grid">
        <div class="result-question-tittle ffs">Результат по вопросам:</div>
        <div class="result-table grid">
                   <#list answusers as answuser>-
            <div class="result-table-content grid">
                <div class="result-table-question ffs grid"><p> ${answuser.questionName} </p></div>
                       <#list answuser.answerName as ans>
                <div class="result-table-answer ffs grid"><p>${ans}</p></div>
                        </#list>
                <div class="result-table-correct grid"><p class="result-answer ffs">${answuser.correct}</p></div>
            </div>
                    </#list>
        </div>
    </div>
    <div class="result-question-balls">Общее количество баллов: ${balls}</div>
    <div class="result-action-block grid">
        <form action="/start/${idtest}" method="get">
            <input type="submit" value="Пересдать">
        </form>
        <form action="/lich_page" method="get">
            <input type="submit" value="Домой">
        </form>
    </div>
</section>
<footer class="footer">
    <div class="title-column title-column-social">
        <ul class="wrapper">
            <li class="icon facebook">
                <span class="tooltip">Facebook</span>
                <i class="fa fa-facebook"></i>
            </li>
            <li class="icon twitter">
                <span class="tooltip">Twitter</span>
                <i class="fa fa-twitter"></i>
            </li>
            <li class="icon instagram">
                <span class="tooltip">Instagram</span>
                <i class="fa fa-instagram"></i>
            </li>
            <li class="icon github">
                <span class="tooltip">Github</span>
                <i class="fa fa-github"></i>
            </li>
            <li class="icon youtube">
                <span class="tooltip">Youtube</span>
                <i class="fa fa-youtube"></i>
            </li>
        </ul>
    </div>
</footer>
</body>
<script>
    var result = document.getElementsByClassName("result-answer");
    for (i = 0; i < result.length; i++) {
        if (result[i].innerHTML == "0") {
            result[i].parentElement.classList.add("answer-nocorrect");
            result[i].innerHTML = "Ошибка"
        } else {
            result[i].parentElement.classList.add("answer-correct");
            result[i].innerHTML = "Верно"
        }
    }
</script>
</html>