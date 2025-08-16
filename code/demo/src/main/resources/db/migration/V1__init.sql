-- V1_init.sql
CREATE TABLE IF NOT EXISTS __flyway_smoke_test (
  id BIGSERIAL PRIMARY KEY,
  created_at TIMESTAMPTZ DEFAULT now()
);

