# Description

restful API to create products with other type

# Prerequisites

* Java 17;
* Apache Maven 3;
* Docker 20.10

# How to build

```
mvn package
```

# How to start

```
mvn spring-boot:run
```

# Example

##### Crete new product:
```
curl --location --request POST 'localhost:8080/products/new' \
--header 'Content-Type: application/json' \
--data-raw '{
    "serialNumber": 10101,
    "manufacturer": "LF",
    "price": 800,
    "quantityOnStock": 300,
    "productType":"PC",
    "formFactor":"DESKTOP"
}'
```

##### Get product:
paste instead **ID** created product id
```
curl --location --request GET 'localhost:8080/products/ID'
```

##### Update product:
paste instead **ID** created product id
```
curl --location --request PUT 'localhost:8080/products/ID' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": "ID",
    "serialNumber": 10101,
    "manufacturer": "LF",
    "price": 800,
    "quantityOnStock": 30,
    "productType": "PC",
    "formFactor": "DESKTOP"
}'
```

##### Get all products by type:
paste instead **TYPE** created product id
```
curl --location --request GET 'localhost:8080/products?productType=TYPE'
```

##### Delete product:
paste instead **ID** created product id
```
curl --location --request DELETE 'localhost:8080/products/ID'
```

##### Delete user:
when a user is deleted, the entire list of his friends is deleted, but the friends of the user remain in their friend lists
```
curl --location --request DELETE 'localhost:8080/users/1'
```
