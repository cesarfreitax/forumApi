INSERT INTO usuario (nome, email, senha) VALUES ('admin', 'admin@email.com', '$2a$12$qvlHurygOuufndpzsMNxCu8EoeaZ5MqPjLbAgdBMkH4f2THVunocC');

INSERT INTO role (nome) VALUES ('ADMIN');

INSERT INTO usuario_role (usuario_id, role_id) VALUES (3, 2);