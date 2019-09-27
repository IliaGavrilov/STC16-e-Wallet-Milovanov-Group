# О приложении 
Проект "Агрегатор банковских счетов" является учебным и был создан для тестирования модели взаимодейтсвия сотрудников банков с клиентами. Проект находится на стадии разработки, тестируются различные функции, ведется доработка ролевых моделей.

Реализованы 3 ролевые модели: 
- Администратор; 
- Банковский сотрудник; 
- Пользователь.

Реализованы функции:
- Авторизация/регистрация/редактирование пользователя, разлогирование;
- Создание банковского продукта, создание заявки, обработка заявок, пополнение счета;
- обновление дашборда.

Технологии:
- Spring Boot (MVC, Security, Data JPA); 
- Maven;
- Liquibase;
- PosrgreSQL;
- Thymeleaf;
- Bootstrap;
- TFS;
- Heroku (continuous integration).

# Запуск приложения локально
- Установить и запустить PostgreSQL; 
- При запуске приложения Liquibase создаст таблицы в БД postgres;
- Запустить приложение и обратиться в браузере по http://localhost:8080/ 

![image](https://drive.google.com/file/d/1qo58AMKYlxBZYcGkPd5lGXxRWsS9aOvB/view)
