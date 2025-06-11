--Tabela Roles(ADMIN)
CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
)

-- Tabela Users
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    status BOOLEAN NOT NULL
)

--Relacionemnto Muitos-para-Muitos: user_roles
CREATE TABLE users_roles (
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE

)
