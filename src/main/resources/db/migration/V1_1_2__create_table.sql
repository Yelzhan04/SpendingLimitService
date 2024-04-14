CREATE TABLE
    IF NOT EXISTS exchange_rates (
        id               SERIAL PRIMARY KEY,
        currency_from    VARCHAR(255) NOT NULL,
        currency_to      VARCHAR(255) NOT NULL,
        exchange_rate    NUMERIC(19, 4) NOT NULL,
        rate_date        DATE NOT NULL
);
