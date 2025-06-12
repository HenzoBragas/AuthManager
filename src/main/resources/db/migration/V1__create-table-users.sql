<<<<<<< HEAD

CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

=======
--Tabela Roles(ADMIN)
CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
)

-- Tabela Users
>>>>>>> 59c86dd3ad96f5912498130f6da5d1a6403b3172
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    status BOOLEAN NOT NULL
<<<<<<< HEAD
);

=======
)

--Relacionemnto Muitos-para-Muitos: user_roles
>>>>>>> 59c86dd3ad96f5912498130f6da5d1a6403b3172
CREATE TABLE users_roles (
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
<<<<<<< HEAD
=======

>>>>>>> 59c86dd3ad96f5912498130f6da5d1a6403b3172
)
