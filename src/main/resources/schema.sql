DROP TABLE IF EXISTS pedidos_cabecera;

DROP TABLE IF EXISTS pedidos_detalle;

CREATE TABLE pedidos_cabecera (
  id VARCHAR(50) PRIMARY KEY,
  direccion VARCHAR(50),
  email VARCHAR(50),
  telefono VARCHAR(20),
  horario TIME,
  fecha_alta DATE,
  monto_total DOUBLE,
  aplico_descuento BOOLEAN  
);

CREATE TABLE productos (
  id VARCHAR(50) PRIMARY KEY,
  nombre VARCHAR(50),
  descripcion_corta VARCHAR(50),
  descripcion_larga VARCHAR(150),
  precio_unitario DOUBLE
);


CREATE TABLE pedidos_detalle (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  cantidad INT,
  pedido_cabecera_id VARCHAR(50),
  producto_id VARCHAR(50),
  precio_unitario DOUBLE
);

ALTER TABLE pedidos_detalle ADD FOREIGN KEY (pedido_cabecera_id) REFERENCES pedidos_cabecera(id);

ALTER TABLE pedidos_detalle ADD FOREIGN KEY (producto_id) REFERENCES productos(id);
	