# Currency Converter 🌍💱

**My first experience in Kotlin.**  
A simple currency converter application written using Spring Framework 🌱.

## Features

- 🛠 **Built with Kotlin**: 100% Kotlin-based code for modern, concise, and safe programming.
- 🌱 **Spring Framework**: Leverages Spring for dependency injection and application configuration.
- 💱 **Currency Conversion**: Convert between popular currencies with ease.

## Setup and Usage

1. Clone this repository:
   ```bash
   git clone https://github.com/BortnikD/Currency-onverter.git
   ```
2. Navigate into the project directory:
   ```bash
   cd CurrencyConverter
   ```
3. Build and run the application
   ```bash
     ./gradlew bootRun
   ```
4. Run docker
   ```bash
   docker-compose up --build
   ```

## API data structure

GET `api/converter?name={name}&amount={amount}`
```json
{
  "amount": 74.86732,
  "base": "USD",
  "date": "2025-04-17",
  "rates": {
    "AUD": 117.6,
    "BGN": 128.9,
    "BRL": 440.3,
    "CAD": 103.95,
    "CHF": 61.231,
    "CNY": 546.34,
    "CZK": 1648.19,
    "DKK": 492.12,
    "EUR": 65.904,
    "GBP": 56.594,
    "HKD": 581.24,
    "HUF": 26862.0,
    "IDR": 1262870.0,
    "ILS": 275.82,
    "INR": 6394.0,
    "ISK": 9562.0,
    "JPY": 10675.0,
    "KRW": 106048.0,
    "MXN": 1491.05,
    "MYR": 329.97,
    "NOK": 788.57,
    "NZD": 125.99,
    "PHP": 4243.34,
    "PLN": 281.7,
    "RON": 328.04,
    "SEK": 726.77,
    "SGD": 98.23,
    "THB": 2491.16,
    "TRY": 2851.02,
    "ZAR": 1409.86
  }
}
```

GET `api/converter/compare?from=USD&to=EUR`
```json
0.88028
```

### Errors handling
```json
{
  "error": "Missing Request Value",
  "message": "400 BAD_REQUEST \"Required query parameter 'from' is not present.\"",
  "status": "BAD_REQUEST",
  "timestamp": "2025-04-18T18:42:31.1326182"
}
```