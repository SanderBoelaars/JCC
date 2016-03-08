create database if not exists demo;

use demo;

drop table if exists bierdop;
drop table if exists postzegel;
drop table if exists _set;

CREATE TABLE `bierdop`
(
	`naam`						varchar(255)	NOT NULL,
	`merk`						varchar(255)	NOT NULL,
	`set_naam`					varchar(255)	NOT NULL,
	PRIMARY KEY (`naam`)
);
CREATE TABLE `postzegel`
(
	`naam`						varchar(255)	NOT NULL,
	`lengte`					int(10)			NOT NULL,
	`breedte`					int(10)			NOT NULL,
	`set_naam`					varchar(255)	NOT NULL,
	PRIMARY KEY (`naam`)
);
CREATE TABLE `_set`
(
	`naam`						varchar(255)	NOT NULL,
	`jaartal`					int(4)			NOT NULL,
	PRIMARY KEY(`naam`)
);

ALTER TABLE `bierdop` ADD FOREIGN KEY (`set_naam`) REFERENCES `_set`(`naam`);
ALTER TABLE `postzegel` ADD FOREIGN KEY (`set_naam`) REFERENCES `_set`(`naam`);