BEGIN TRANSACTION;
CREATE TABLE `teams` (
	`project`	INTEGER NOT NULL,
	`staff`	INTEGER NOT NULL,
	`rol`	TEXT NOT NULL,
	PRIMARY KEY(`project`,`staff`),
	FOREIGN KEY(`project`) REFERENCES projects(id),
	FOREIGN KEY(`staff`) REFERENCES staff(id)
);
CREATE TABLE "story_predecessors" (
	`story`	INTEGER NOT NULL,
	`predecessor`	INTEGER NOT NULL,
	PRIMARY KEY(`story`,`predecessor`),
	FOREIGN KEY(`story`) REFERENCES `feature`(`id`),
	FOREIGN KEY(`predecessor`) REFERENCES `feature`(`id`)
);
CREATE TABLE "staff" (
	`id`	INTEGER NOT NULL,
	`name`	TEXT NOT NULL,
	`phone`	TEXT NOT NULL,
	`email`	TEXT NOT NULL UNIQUE,
	PRIMARY KEY(`id`)
);
CREATE TABLE "sprints" (
	`id`	INTEGER NOT NULL,
	`start_date`	TEXT NOT NULL,
	`project`	INTEGER NOT NULL,
	`weeks`	INTEGER NOT NULL,
	PRIMARY KEY(`id`),
	FOREIGN KEY(`project`) REFERENCES `project`(`id`)
);
CREATE TABLE "sprint_backlog" (
	`story`	INTEGER NOT NULL,
	`sprint`	INTEGER NOT NULL,
	PRIMARY KEY(`story`,`sprint`),
	FOREIGN KEY(`story`) REFERENCES `features`(`id`),
	FOREIGN KEY(`sprint`) REFERENCES `sprints`(`id`)
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
	`responsible`	TEXT,
	PRIMARY KEY(`id`),
	FOREIGN KEY(`project`) REFERENCES `projects`(`id`),
	FOREIGN KEY(`responsible`) REFERENCES staff(id)
);
COMMIT;
