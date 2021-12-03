DROP SCHEMA IF EXISTS christians_oe;
CREATE SCHEMA christians_oe;

USE christians_oe;

DROP TABLE IF EXISTS ferry;
CREATE TABLE ferry(
                      id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      depature_time_interval TIMESTAMP,
                      island_time TIME
);


CREATE TABLE locations(
                          id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          location_name VARCHAR(40),
                          y_pos DOUBLE,
                          x_pos DOUBLE,
                          quiz_id int not null

);



CREATE TABLE quizes(
                       id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       quiz_name VARCHAR (40),
                       questions VARCHAR (500),
                       answers VARCHAR (500),
                       location_id int not null,
                       FOREIGN KEY(location_id) references locations(id)
);
ALTER TABLE locations ADD FOREIGN KEY(quiz_id) references quizes(id);

CREATE TABLE routes(
                       id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       route_name VARCHAR (40),
                       route_length DOUBLE,
                       location_id int not null,
                       guided_tour_id int not null,
                       FOREIGN KEY(location_id) references locations(id)

);



CREATE TABLE guided_tours(
                             id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                             guided_tour_name VARCHAR (40),
                             time DATETIME,
                             answers VARCHAR (500),
                             description VARCHAR (40),
                             route_id int not null,
                             FOREIGN KEY(route_id) references routes(id)
);

ALTER TABLE routes ADD FOREIGN KEY(guided_tour_id) references guided_tours(id);

CREATE TABLE file_manager(
                             id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                             file_name VARCHAR (40),
                             time_stamp DATETIME,
                             data_type VARCHAR (200),
                             guided_tour_id int not null,
                             FOREIGN KEY(guided_tour_id) references guided_tours(id)
);
