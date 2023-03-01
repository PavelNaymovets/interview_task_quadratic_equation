# Тестовое задание
### Описание
Реализовать веб приложение для вычисления корней квадратного уравнения вида ax^2 + bx + c = 0.
### Требования
* Пользователь отправляет POST запрос на endpoint c данными в формате JSON с полями: a, b, c - коэффициенты кв.уравнения;
* Программа должна сохранить значения коэффициентов и рассчитанных корней уравнения в базу данных;
* Программа должна вернуть значение корней уравнения в формате JSON с полями: x1, x2;
* Если найти корни уравнения нельзя - вернуть пользователю ошибку.
## Решение
### Структура проекта
Проект состоит из 1 модуля, который содержит:
* _REST_ веб-сервис для вычисления корней кв. уравнения;
* _H2_ in-memory БД для хранения значения коэффициентов и рассчитанных корней кв. уравнения;
### _REST_ веб-сервис
Веб-сервис запускается на `http://localhost:8080/task` и поддерживает запросы по следующему _URL_:
* `.../api/v1/equation/resolve - POST`

В теле `POST`-запроса передаются коэффициенты `a`, `b`, `c` кв. уравнения в формате _JSON_:
```
{
    "a": 1,
    "b": 1,
    "c": -2
}
```
В ответ на запрос будет возвращена сущность _[EquationResponse](https://github.com/PavelNaymovets/interview_task_quadratic_equation/blob/master/src/main/java/com/interview/task/quadraticEquation/controller/rest/EquationResponse.java)_ с корнями уравнения в формате JSON:
```
{
    "x1": 1.0,
    "x2": -2.0
}
```
В случае, если корней уравнения нет, пробрасывается исключение _[NoRootsOfEquationException](https://github.com/PavelNaymovets/interview_task_quadratic_equation/blob/master/src/main/java/com/interview/task/quadraticEquation/exception/NoRootsOfEquationException.java)_, которое затем отлавливается и обрабатывается глобальным перехватчиком исключений _[GlobalExceptionHandler](https://github.com/PavelNaymovets/interview_task_quadratic_equation/blob/master/src/main/java/com/interview/task/quadraticEquation/exception/GlobalExceptionHandler.java)_.
В ответ пользователю возвращается сущность-обертка _ResponseEntity_, которая содержит сущность _[AppError](https://github.com/PavelNaymovets/interview_task_quadratic_equation/blob/master/src/main/java/com/interview/task/quadraticEquation/exception/AppError.java)_ со статус кодом 
и сообщением об ошибке, в формате JSON:
```
{
    "statusCode": 400,
    "message": "No roots"
}
```
### База данных
При старте приложения система миграции БД _Flyway_ создает в БД таблицу `equation` с помощью _SQL_-скрипта [V1__ordersData.sql](https://github.com/PavelNaymovets/interview_task_quadratic_equation/blob/master/src/main/resources/db/migration/V1__ordersData.sql).

БД поддерживает веб-консоль: `http://localhost:8080/task/h2-console`. _Datasource_: `jdbc:h2:mem:mydatabase`. Маппинг сущности:
* _EquationEntity_ (таблица `equation`) - таблица с корнями и коэффициентами кв. уравнения;
### Тесты
В `src/test/` есть несколько простых юнит-тестов на пару позитивных сценариев (см. [тут](https://github.com/PavelNaymovets/interview_task_quadratic_equation/blob/master/src/test/java/com/interview/task/quadraticEquation/TaskApplicationTests.java)).
### Заупск приложения
Запуск приложения из класса _[QuadraticEquationApplication](https://github.com/PavelNaymovets/interview_task_quadratic_equation/blob/master/src/main/java/com/interview/task/quadraticEquation/QuadraticEquationApplication.java)_.
Запуск тестов из класса _[TaskApplicationTests](https://github.com/PavelNaymovets/interview_task_quadratic_equation/blob/master/src/test/java/com/interview/task/quadraticEquation/TaskApplicationTests.java)_, или через консоль 
командой `mwnw test`.
### Логирование
Приложение логирует свои действия в консоль. В том числе запросы, которые формируются к БД с помощью Hibernate в
соответствии с конфигурационным файлом проекта [application.yaml](https://github.com/PavelNaymovets/interview_task_quadratic_equation/blob/master/src/main/resources/application.yaml).