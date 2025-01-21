# CardDemo Application

CardDemo is a Spring Boot-based application designed to manage and process transactions, merchants, and card accounts. This updated guide focuses on **testing transactions** using `curl` commands.

---

## Prerequisites

- **Java**: Ensure you have Java 21 installed.
- **Gradle**: Ensure you have Gradle installed or use the Gradle wrapper provided in the project.
- **PostgreSQL**: Install and configure PostgreSQL or use Docker for the database setup.
- **Docker** (optional): For containerized deployment.

---

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/your-repo/card-demo.git
cd card-demo
```

### Set Up the Database

#### Using Docker (Recommended)
Run the following command to start PostgreSQL using Docker:

```bash
docker-compose up -d
```

This will create a PostgreSQL database with the following configurations:
- **Database**: `card_demo`
- **User**: `myuser`
- **Password**: `mypassword`
- **Port**: `5432`

#### Manual Setup
1. Create a database named `card_demo`.
2. Create a user with the username `myuser` and password `mypassword`.
3. Grant the user all privileges on the `card_demo` database.

---

### Build and Run the Application

#### Build the Project
```bash
./gradlew build
```

#### Run the Application
```bash
./gradlew bootRun
```

The application will start at [http://localhost:8085](http://localhost:8085).

---

## Testing Transactions with `curl`

### Create a Transaction
```bash
curl -X POST http://localhost:8085/api/transactions \
-H "Content-Type: application/json" \
-d '{
  "accountId": "ACC123",
  "cardNumber": "1234567812345678",
  "transactionAmount": 200.00,
  "originalDate": "2025-01-20",
  "processingDate": "2025-01-21",
  "transactionCategoryCode": "FOOD",
  "transactionDescription": "Grocery Shopping",
  "transactionSource": "POS",
  "transactionTypeCode": "PURCHASE",
  "merchantId": 1
}'
```

### Get All Transactions
```bash
curl -X GET http://localhost:8085/api/transactions
```

### Get a Transaction by ID
```bash
curl -X GET http://localhost:8085/api/transactions/1
```

### Update a Transaction
```bash
curl -X PUT http://localhost:8085/api/transactions/1 \
-H "Content-Type: application/json" \
-d '{
  "accountId": "ACC123",
  "cardNumber": "1234567812345678",
  "transactionAmount": 250.00,
  "originalDate": "2025-01-20",
  "processingDate": "2025-01-22",
  "transactionCategoryCode": "ENT",
  "transactionDescription": "Movie Tickets",
  "transactionSource": "ONLINE",
  "transactionTypeCode": "PURCHASE",
  "merchantId": 2
}'
```

### Delete a Transaction
```bash
curl -X DELETE http://localhost:8085/api/transactions/1
```

---

## Run Tests

Use Gradle to execute all tests:
```bash
./gradlew test
```

View test results in `build/reports/tests/test/index.html`.

---

## Contribution

Feel free to fork the repository and submit pull requests. For major changes, please open an issue to discuss your ideas.

---

## License

This project is licensed under the [MIT License](LICENSE).
```

This `README.md` now highlights the essential `curl` commands specifically for **testing transactions**. Let me know if additional details or further changes are required!
