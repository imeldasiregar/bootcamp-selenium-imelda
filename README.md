# bootcamp-selenium-imelda

## Tugas Course: API Testing dengan Postman & Rest-Assured + TestNG

## Deskripsi
Proyek ini berisi contoh pengujian API menggunakan **Rest-Assured** dan **TestNG** pada Java. Semua skenario pengujian dapat dijalankan secara otomatis menggunakan Maven.

## Prasyarat
- Java 21 atau lebih baru
- Maven 3.x
- Koneksi internet (untuk download dependency)

## Setup
1. **Clone repository ini:**
   ```sh
   git clone https://github.com/username/bootcamp-selenium-imelda.git
   cd bootcamp-selenium-imelda

2. **Install dependency:** 

    ```mvn clean install```

    ```mvn test```

## Contoh Output
    ```
    Response: {
        "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
    }
    ```

#### Data Provider
```src/test/java/testng/DataProviderTest.java```

#### Test Suite
```src/test/resources/testng_simple_suite.xml```
```src/test/resources/testng_simple_suite.xml```

#### Assertion
```src/test/java/testng/AssertTest.java```

#### IRetryAnalyzer
```src/test/java/testng/RetryTest.java```

reference: https://testng.org/
