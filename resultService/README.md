# resultService - сервис проверки результатов тестирования и храниния истории выполнения

## Описание
 Сервис способен проверить правильность выполнения тестов учащимися, а так же хранить историю результатов выполненых тестов учащимся

### Взаимодействие
  Сервис хранит в себе краткую информацию об вопросах и тестах, полученные при синхронизации с examService

### Схема БД

![db_resultService](https://github.com/TurkinDV/ege-skill/blob/8c19b5b414056e0ea37b58bc6f55b60407879736/docs/pic/Database%20ER%20diagram%20resultService.png)

### Технологии
- Java
- Spring
- Maven
- Mockito
- JUnit
- PostgreSQL

## TODO
1. TODO находящиеся внутри кода
2. Добавить возможность смотреть статистику теста
3. Добавить проверку на целостность теста при отправке результатов учащимся
4. Добавить синхронизацию с examService
