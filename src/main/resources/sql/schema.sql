create table greeting
(
    id int auto_increment,
    content varchar(255) not null,
    constraint greeting_pk
        primary key (id)
);

create table users
(
    `id`       bigint(11) unsigned NOT NULL AUTO_INCREMENT,
    `username` varchar(100) not null,
    `password` varchar(100) not null,
    `enabled`  boolean     not null,
    PRIMARY KEY (`id`),
    UNIQUE KEY `username_unique` (`username`)
);

create table authorities
(
    `id`        bigint(11) unsigned NOT NULL AUTO_INCREMENT,
    `user_id`   bigint(11) unsigned NOT NULL,
    `authority` varchar(50) not null,
    PRIMARY KEY (`id`),
    UNIQUE KEY `authorities_unique` (`user_id`, `authority`)
);

ALTER TABLE `authorities`
    ADD CONSTRAINT `fk_authorities`
        FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
