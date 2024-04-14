CREATE TABLE
    IF NOT EXISTS monthly_limits (
        id           SERIAL PRIMARY KEY,
        category     VARCHAR(255) NOT NULL,
        limit_usd    NUMERIC(19, 2) NOT NULL
);
