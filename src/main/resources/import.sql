-- ROLES
INSERT INTO roles (id, nombre) VALUES (1, 'ADMINISTRADOR');
INSERT INTO roles (id, nombre) VALUES (2, 'ACOMODADOR');
INSERT INTO roles (id, nombre) VALUES (3, 'CLIENTE');

-- USUARIOS
INSERT INTO usuarios (id, contrasena, nombre_usuario, id_rol) VALUES
                                                                          (1, 'admin', '$2a$10$5Vh3B2cWWhK1q8oe4JSFYOv9iVt1kdeRbOSksVLqO1e9cMplZcphm', 'Admin Uno', 1), -- contraseña: 123456
                                                                          (2, 'acomo', '$2a$10$5Vh3B2cWWhK1q8oe4JSFYOv9iVt1kdeRbOSksVLqO1e9cMplZcphm', 'Acom Uno', 2),   -- contraseña: 123456
                                                                          (3, 'client', '$2a$10$5Vh3B2cWWhK1q8oe4JSFYOv9iVt1kdeRbOSksVLqO1e9cMplZcphm', 'Cliente Uno', 3); -- contraseña: 123456
