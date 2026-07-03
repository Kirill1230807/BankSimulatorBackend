CREATE TABLE IF NOT EXISTS users
(
    id            UUID PRIMARY KEY,
    first_name    VARCHAR(255),
    last_name     VARCHAR(255),
    email         VARCHAR(255) UNIQUE NOT NULL,
    phone_number  VARCHAR(50) UNIQUE  NOT NULL,
    birthday      DATE                NOT NULL,
    password_hash VARCHAR(255)        NOT NULL,
    role          VARCHAR(50) DEFAULT 'USER',
    status        VARCHAR(50) DEFAULT 'ACTIVE',
    created_at    TIMESTAMP   DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX IF NOT EXISTS idx_users_email ON users (email);
CREATE INDEX IF NOT EXISTS idx_users_phone ON users (phone_number);