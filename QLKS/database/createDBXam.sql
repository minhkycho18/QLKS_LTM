USE management_hotel ;
CREATE TABLE management_hotel.admin (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NULL,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  email varchar(255) NOT NULL
  );

CREATE TABLE room (
  id_room VARCHAR(10) PRIMARY KEY NOT NULL,
  nameroom VARCHAR(255) NOT NULL,
  num_bed INT NOT NULL,
  description TEXT NULL,
  price DOUBLE NOT NULL,
  admin_id INT NOT NULL,
  CONSTRAINT `fk_room_admin`
    FOREIGN KEY (admin_id)
    REFERENCES management_hotel.admin (id)
);