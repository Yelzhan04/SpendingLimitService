CREATE TABLE
    IF NOT EXISTS transactions (
        id                                SERIAL PRIMARY KEY,
        transaction_date                  DATE NOT NULL,
        account_from                      BIGINT NOT NULL,
        account_to                        BIGINT NOT NULL,
        currency_shortname                VARCHAR(255) NOT NULL,
        amount                            NUMERIC(19, 2) NOT NULL,
        expense_category                  VARCHAR(255) NOT NULL,
        limit_id                          BIGINT,
        exchange_rate_id                  BIGINT,
        FOREIGN KEY (limit_id)            REFERENCES monthly_limits(id),
        FOREIGN KEY (exchange_rate_id)    REFERENCES exchange_rates(id)
);
