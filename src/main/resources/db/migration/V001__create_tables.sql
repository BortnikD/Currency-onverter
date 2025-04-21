CREATE TABLE IF NOT EXISTS public.exchange_sessions (
    id BIGSERIAL PRIMARY KEY,
    base_currency VARCHAR(3) NOT NULL,
    date Date NOT NULL
);

CREATE TABLE IF NOT EXISTS public.exchange_rates (
    id BIGSERIAL PRIMARY KEY,
    session_id BIGINT REFERENCES public.exchange_sessions(id) ON DELETE CASCADE,
    currency VARCHAR(3) NOT NULL,
    rate NUMERIC(13, 5) NOT NULL
);
