BEGIN TRANSACTION;
CREATE TABLE `teams` (
	`project`	INTEGER NOT NULL,
	`staff`	INTEGER NOT NULL,
	`rol`	TEXT NOT NULL,
	PRIMARY KEY(`project`,`staff`),
	FOREIGN KEY(`project`) REFERENCES projects(id),
	FOREIGN KEY(`staff`) REFERENCES staff(id)
);
CREATE TABLE "tasks" (
	`id`	INTEGER NOT NULL,
	`state`	TEXT NOT NULL,
	`feature`	INTEGER NOT NULL,
	`estimated_duration`	INTEGER,
	`real_duration`	INTEGER,
	`responsible`	INTEGER,
	`description`	TEXT NOT NULL,
	`details`	TEXT,
	PRIMARY KEY(`id`),
	FOREIGN KEY(`feature`) REFERENCES `features`(`id`),
	FOREIGN KEY(`responsible`) REFERENCES `staff`(`id`)
);
CREATE TABLE `task_predecessors` (
	`task`	INTEGER NOT NULL,
	`predecessor`	INTEGER NOT NULL,
	PRIMARY KEY(`task`,`predecessor`),
	FOREIGN KEY(`task`) REFERENCES task(id),
	FOREIGN KEY(`predecessor`) REFERENCES task(id)
);
CREATE TABLE "staff" (
	`id`	INTEGER NOT NULL,
	`name`	TEXT NOT NULL,
	`phone`	TEXT NOT NULL,
	`email`	TEXT NOT NULL UNIQUE,
	PRIMARY KEY(`id`)
);
CREATE TABLE `sprints` (
	`id`	INTEGER NOT NULL,
	`start_date`	TEXT NOT NULL,
	`end_date`	TEXT,
	`project`	INTEGER NOT NULL,
	PRIMARY KEY(`id`),
	FOREIGN KEY(`project`) REFERENCES `project`(`id`)
);
CREATE TABLE `sprint_backlog` (
	`task`	INTEGER NOT NULL,
	`sprint`	INTEGER NOT NULL,
	PRIMARY KEY(`task`,`sprint`),
	FOREIGN KEY(`task`) REFERENCES tasks(id),
	FOREIGN KEY(`sprint`) REFERENCES sprints(id)
);
CREATE TABLE `risks` (
	`id`	INTEGER NOT NULL,
	`description`	TEXT NOT NULL,
	`project`	INTEGER NOT NULL,
	`contingency_plan`	TEXT,
	PRIMARY KEY(`id`),
	FOREIGN KEY(`project`) REFERENCES project(id)
);
CREATE TABLE `projects` (
	`id`	INTEGER NOT NULL,
	`name`	TEXT NOT NULL UNIQUE,
	`type`	TEXT NOT NULL,
	PRIMARY KEY(`id`)
);
CREATE TABLE "features" (
	`id`	INTEGER NOT NULL,
	`state`	TEXT NOT NULL,
	`type`	TEXT NOT NULL,
	`description`	TEXT NOT NULL,
	`project`	INTEGER NOT NULL,
	`points`	INTEGER,
	`priority`	INTEGER,
	`details`	TEXT,
	PRIMARY KEY(`id`),
	FOREIGN KEY(`project`) REFERENCES `projects`(`id`)
);
COMMIT;
