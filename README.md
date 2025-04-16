# Diplom_3 - UI Автоматизация тестирования веб-приложения Stellar Burgers
## Описание проекта
Проект автоматизации тестирования веб-интерфейса приложения Stellar Burgers с использованием Selenium WebDriver.
## Технологии
- Java 11
- Maven
- Selenium WebDriver
- JUnit 4
- Allure
- Rest Assured
- JavaFaker
- WebDriverManager
## Запуск тестов
### Запуск в Chrome (по умолчанию)
```mvn clean test```
### Запуск в Firefox
```mvn clean test -Dbrowser=firefox```
### Генерация Allure отчета
```mvn allure:serve```