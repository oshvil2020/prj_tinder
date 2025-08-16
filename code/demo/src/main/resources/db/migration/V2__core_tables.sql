-- Enable case-insensitive email type (optional; comment out if you prefer VARCHAR)
CREATE EXTENSION IF NOT EXISTS citext;

-- users & auth
CREATE TABLE IF NOT EXISTS app_user (
  id            BIGSERIAL PRIMARY KEY,
  email         CITEXT UNIQUE NOT NULL,   -- or VARCHAR(255) UNIQUE NOT NULL
  password_hash TEXT,
  created_at    TIMESTAMPTZ DEFAULT now(),
  updated_at    TIMESTAMPTZ DEFAULT now(),
  is_deleted    BOOLEAN DEFAULT false
);

-- profile (1:1 with app_user)
CREATE TABLE IF NOT EXISTS profile (
  user_id      BIGINT PRIMARY KEY REFERENCES app_user(id) ON DELETE CASCADE,
  display_name VARCHAR(50) NOT NULL,
  city         VARCHAR(80) NOT NULL,
  bio          VARCHAR(280),
  birth_year   SMALLINT,
  created_at   TIMESTAMPTZ DEFAULT now(),
  updated_at   TIMESTAMPTZ DEFAULT now()
);

