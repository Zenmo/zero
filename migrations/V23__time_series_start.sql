ALTER TABLE public.time_series
    DROP COLUMN timestamp;

ALTER TABLE public.time_series
    ADD start TIMESTAMP DEFAULT '2022-12-31 23:00:00'::TIMESTAMP WITHOUT TIME ZONE NOT NULL;