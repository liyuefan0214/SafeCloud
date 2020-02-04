Drop table IF exists `users`;
create table `users`(
    `id` int(10) unsigned not null AUTO_INCREMENT,
    `username` varchar(500) not null,
    `password` varchar(500) not null,
    `phone_number` varchar(500) not null,
    `email` varchar(500) not null,
    `create_time` datetime not null,
    `update_time` datetime not null,
    primary key(`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

drop TABLE if exists `folder`;
create table `folder`(
    `id` int(10) unsigned not null AUTO_INCREMENT,
    `floder_name` varchar(500) not null,
	`floder_path` VARCHAR(500) not null,
    `floder_size` decimal(19,0) DEFAULT 0.0,
    `uid` int(10) unsigned not null,
    `create_time` datetime not null,
    `update_time` datetime not null,
    primary key(`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

drop table if exists `file`;
create table `file`(
    `id` int(10) unsigned not null AUTO_INCREMENT,
    `file_name` varchar(500) not null,
    `file_path` varchar(500) not null,
    `file_size` varchar(500) not null,
    `file_type` varchar(500) not null,
    `fid` int(10) unsigned not null,
    `create_time` datetime not null,
    `update_time` datetime not null,
    primary key(`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;














--
-- Dumping data for table `thread`
--

LOCK TABLES `thread` WRITE;
/*!40000 ALTER TABLE `thread` DISABLE KEYS */;
/*!40000 ALTER TABLE `thread` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-17 17:06:20
