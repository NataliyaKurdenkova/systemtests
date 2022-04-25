<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Новый тест</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600;800&display=swap');
    </style>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/main.min.css">
</head>
<body>
<header>
    <div class="header-container">
        <div class="header-rows header-rows-1">
            <div class="header-logo">
                <img class="header-logo-img" src="img/logo.svg" alt="logo">
            </div>
            <div class="header-title">
                <img class="header-title-image" src="img/Title.png" alt="title-img">
                <img class="right-img" src="img/right-img.svg" alt="img">
            </div>
        </div>
        <div class="header-rows header-rows-4">
            <div class="header-columns-output">
                <p class="header-columns-output-p" id="FIO-output">${name}</p>
            </div>
            <div class="header-columns-exit">
                <form action="/" method="post">
                    <input class="header-columns-exit-input" type="submit" value="Выход">
                </form>
            </div>
        </div>
    </div>
</header>
<section class="newtest-container grid">
    <div class="newtest-question-container grid">
        <!-- <p class="test-question-id">${idtest}</p>-->
        <div class="newtest-question-title grid"><p class="">Новый тест</p></div>
        <div class="newtest-question grid">
            <p class="">Название</p>
            <input class="newtest-question-input" type="text" placeholder="Введите название теста">
        </div>
    </div>
    <div class="newtest-answers-container grid">
        <div class="newtest-answers-block grid scroll-container">
            <!--    <#list answers as answer>-->
            <ul class="treeCSS">
                <li>Сайт
                    <ul>
                        <li>Тест 1
                            <ul>
                                <li>Вопрос 1
                                <li>Вопрос 2
                                <li>Вопрос 3
                            </ul>
                        <li>Тест 2
                            <ul>
                                <li>Вопрос 1
                                <li>Вопрос 2
                                <li>Вопрос 3
                            </ul>
                        <li>Тест 3
                            <ul>
                                <li>Вопрос 1
                                <li>Вопрос 2
                                <li>Вопрос 3
                            </ul>
                        <li>Тест 4
                            <ul>
                                <li>Вопрос 1
                                <li>Вопрос 2
                                <li>Вопрос 3
                            </ul>
                        <li>Тест 5
                            <ul>
                                <li>Вопрос 1
                                <li>Вопрос 2
                                <li>Вопрос 3
                            </ul>
                    </ul>
            </ul>
            <!--</#list>-->
        </div>
        <div class="newtest-answers-block grid scroll-container">
            <form action="" class="newtest-answers-form grid">
                <div class="newtest-answer-title grid">
                    <label for="answer">Содержание вопроса:</label>
                    <textarea name="" id="answer"></textarea>
                </div>
                <div class="newtest-answer-type grid">
                    <label for="val"><span>Тип вопроса:</span></label>
                    <select onchange="answerType()" id="val">
                        <option value=radio>один вариант</option>
                        <option value=checkbox>Несколько вариантов</option>
                    </select>
                </div>
                <div class="newtest-answer-container grid" id="answers-container">
                    <!--    <#list answers as answer>-->
                    <div class="newtest-answer grid">
                        <input type="radio" class="answer_type" name="newtest_answer">
                        <textarea name="" id=""></textarea>
                    </div>
                    <!--</#list>-->
                    <div class="newtest-answer grid">
                        <input type="radio" class="answer_type" name="newtest_answer">
                        <textarea name="" id=""></textarea>
                    </div>
                    <div class="newtest-answer grid">
                        <input type="radio" class="answer_type" name="newtest_answer">
                        <textarea name="" id=""></textarea>
                    </div>
                    <div class="newtest-answer grid">
                        <input type="radio" class="answer_type" name="newtest_answer">
                        <textarea name="" id=""></textarea>
                    </div>
                </div>
                <div class="newtest-answer-add grid">
                    <button onclick="addAnswer()">Добавить ответ</button>
                </div>
            </form>
        </div>
    </div>
    <div class="newtest-action-container grid">
        <div class="newtest-action-block grid">
            <form action="/" method="post">
                <input type="submit" value="Добавить тест">
            </form>
            <form action="/" method="post">
                <input type="submit" value="Добавить вопрос">
            </form>
        </div>
        <div class="newtest-action-block grid">
            <form action="/" method="post">
                <input type="submit" value="Сохранить">
            </form>
            <form action="/" method="post">
                <input type="submit" value="Список тестов">
            </form>
        </div>
    </div>
</section>
<script>
    (function() {
        var ul = document.querySelectorAll('.treeCSS > li:not(:only-child) ul, .treeCSS ul ul');
        for (var i = 0; i < ul.length; i++) {
            var div = document.createElement('div');
            div.className = 'drop';
            div.innerHTML = '+'; // картинки лучше выравниваются, т.к. символы на одном браузере ровно выглядят, на другом — чуть съезжают
            ul[i].parentNode.insertBefore(div, ul[i].previousSibling);
            div.onclick = function() {
                this.innerHTML = (this.innerHTML == '+' ? '−' : '+');
                this.className = (this.className == 'drop' ? 'drop dropM' : 'drop');
            }
        }
    })();
    function answerType() {
        <!-- SQL запрос на изменение типа поля Input и перезагрузка страницы -->
    };
    function addAnswer() {
        <!-- SQL запрос на добавление строчки в таблицу и перезагрузка страницы -->
    };
</script>
</body>
</html>