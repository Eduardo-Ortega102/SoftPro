BEGIN TRANSACTION;
CREATE TABLE `team` (
	`project`	INTEGER,
	`staff`	INTEGER,
	`rol`	TEXT NOT NULL,
	PRIMARY KEY(`project`,`staff`),
	FOREIGN KEY(`project`) REFERENCES project(id),
        FOREIGN KEY(`staff`) REFERENCES staff(id)
);









CREATE TABLE `task` (
	`id`	INTEGER AUTOINCREMENT,
	`duracion estimada`	TEXT,
	`duracion final`	TEXT,
	`feature`	INTEGER,
	`staff`	INTEGER,
        PRIMARY KEY(`id`),
	FOREIGN KEY(`feature`) REFERENCES feature(id),
	FOREIGN KEY(`staff`) REFERENCES staff(id)
);
CREATE TABLE `staff` (
	`id`	INTEGER AUTOINCREMENT,
	`telefono`	TEXT NOT NULL UNIQUE,
	`mail`	TEXT NOT NULL UNIQUE,
	`nombre`	TEXT NOT NULL,
	PRIMARY KEY(`id`)
);






CREATE TABLE `sprintbacklog` (
	`feature`	INTEGER,
	`sprint`	INTEGER,
	PRIMARY KEY(`feature`),
	FOREIGN KEY(`feature`) REFERENCES backlog(feature),
	FOREIGN KEY(`sprint`) REFERENCES sprint(id)
);








CREATE TABLE `sprint` (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`fechainicio`	TEXT NOT NULL,
	`fechafin`	TEXT
);
CREATE TABLE `project` (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`nombre`	TEXT NOT NULL,
	`tipo`	TEXT NOT NULL
);
CREATE TABLE "feature" (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`estado`	INTEGER NOT NULL,
	`descripcion`	INTEGER,
	`detalles`	INTEGER,
	`tipo`	INTEGER NOT NULL,
	`prioridad`	INTEGER,
	`puntos`	INTEGER
);


CREATE TABLE `backlog` (
	`feature`	INTEGER,
        `project`	INTEGER,	
	PRIMARY KEY(`feature`),
	FOREIGN KEY(`project`) REFERENCES project(id),
	FOREIGN KEY(`feature`) REFERENCES feature(id)
);
COMMIT;
