# TVS

Standalone-приложение сервис и клиент соответственно находятся в папках Lab3TVS_service и Lab3TVS_client. 
Для взаимодействия требуется база данных postgres, поднятая на localhost ( + изменить креды доступа).
После изменения методов в сервисе, на клиенте надо генерировать классы заново с помощью команды:
```
mvn clean jaxws:wsimport
```