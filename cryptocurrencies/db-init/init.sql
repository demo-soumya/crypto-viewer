CREATE DATABASE crypto_db;

-- Switch to the database
\c crypto_db;

-- Create the table for cryptocurrencies
CREATE TABLE cryptocurrency (
    id VARCHAR(50) PRIMARY KEY,
    symbol VARCHAR(10) NOT NULL,
    name VARCHAR(100) NOT NULL,
    current_price DECIMAL(15, 2) NOT NULL,
    market_cap BIGINT NOT NULL,
    total_volume BIGINT NOT NULL,
    high_24h DECIMAL(15, 2) NOT NULL,
    low_24h DECIMAL(15, 2) NOT NULL,
    last_updated TIMESTAMP NOT NULL
);

