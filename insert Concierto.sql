use conciertos;



INSERT INTO cliente ( Nombre, Apellido1,Apellido2, Correo, Telefono) VALUES
('Juan', 'Pérez', 'González', 'juan.perez@mail.com', 312456789),
('María', 'García', 'Martínez', 'maria.garcia@mail.com', 31654321),
('Carlos', 'Sánchez', 'Ramírez', 'carlos.sanchez@mail.com', 326789123),
('Ana', 'López', 'Fernández', 'ana.lopez@mail.com', 321654987),
('Luis', 'Martínez', 'Sánchez', 'luis.martinez@mail.com', 325123456);

INSERT INTO concierto (Nombre, Artista, Fecha, Lugar, PrecioBase) VALUES
('Rock en Vivo', 'Queen', '2025-03-01', 'Estadio A', 50.00),
('Fiesta Electrónica', 'David Guetta', '2025-03-10', 'Club B', 40.00),
('Concierto Clásico', 'Yo-Yo Ma', '2025-04-05', 'Teatro C', 60.00),
('Festival Reggaeton', 'Bad Bunny', '2025-04-12', 'Arena D', 45.00),
('Concierto Pop', 'Ariana Grande', '2025-05-20', 'Auditorio E', 55.00),
('Festival de Jazz', 'Miles Davis', '2025-06-10', 'Teatro F', 65.00),
('Concierto de Música Latina', 'Shakira', '2025-07-15', 'Estadio G', 70.00),
('R&B Soul', 'Alicia Keys', '2025-08-01', 'Teatro H', 50.00),
('Festival Metal', 'Metallica', '2025-09-05', 'Arena I', 75.00),
('Tour de Hip-Hop', 'Kendrick Lamar', '2025-10-12', 'Estadio J', 80.00);


INSERT INTO ticket(ID_Cliente, ID_Concierto, Zona, FechaCompra,PrecioFinal) VALUES
(1, 2, 'VIP', '2025-03-01', 100.00),
(2, 1, 'General', '2025-03-10', 60.00),
(1, 3, 'VIP', '2025-04-05', 120.00),
(4, 1, 'General', '2025-04-12', 90.00),
(5, 4, 'VIP', '2025-05-20', 110.00);


INSERT INTO zona (NombreZona, Capacidad, PrecioAdicional) VALUES
( 'General', 500, 20.00),
( 'centro', 300, 15.00),
( 'lateral_der', 200, 10.00),
( 'lateral_izq', 100, 25.00),
( 'VIP', 50, 30.00);
