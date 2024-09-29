ALTER SEQUENCE user_seq RESTART WITH 6;

INSERT INTO users
    (id, archive, email, name, password, role)
VALUES (5, false, 'petr@mail.ua',
        'petr', 'pass', 'CLIENT'),
       (6, false, 'tom@mail.ua',
        'tom', 'pass', 'MANAGER'),
       (7, false, 'admin@mail.ua',
        'admin2', 'apass', 'ADMIN');
