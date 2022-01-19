DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `avator` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`username`)
) DEFAULT CHARSET=utf8;

LOCK TABLES `admin` WRITE;
INSERT INTO `admin` VALUES (1,'admin1','123',null),(2,'admin2','456',null);
UNLOCK TABLES;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(80) DEFAULT NULL,
  `college` varchar(5) DEFAULT NULL,
  `class` YEAR DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`username`)
) DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (NULL,'tom','tom123',"tom@cats.com", "MCS", 2023),(NULL,'jerry','jerry456',"jerry@mouse.com", "CIT", 2024),(NULL,'Helen','123',"myhelen@gmail.com", "CFA", 2023);
UNLOCK TABLES;

DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `number` int(5) NOT NULL,
  `name` varchar(100) NOT NULL,
  `units` int(2) NOT NULL,
  `prof` varchar(50) DEFAULT NULL,
  `intro` varchar(4096) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`number`)
) DEFAULT CHARSET=utf8;

LOCK TABLES `courses` WRITE;
INSERT INTO `courses` VALUES (null,15112,'Fundamentals of Programming', 12, 'David Kosbie', 'An intro to CS course that teaches basic CS concepts and teach students write clear, robust and efficient code in Python programming. A final term project is included.'),
(null, 21241, 'Matrix Algebra', 10, 'Jason Howell', 'This course teaches the basic concepts and tools in linear algebra and matrices. Students will have a basic understanding of linear algebra. Both related calculations and proofs regarding basic linear algebra concepts will be covered');
UNLOCK TABLES;

DROP TABLE IF EXISTS `profs`;
CREATE TABLE `profs` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `intro` varchar(4096) DEFAULT NULL,
  `rating` int(4) unsigned DEFAULT NULL, 
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) DEFAULT CHARSET=utf8;

LOCK TABLES `profs` WRITE;
INSERT INTO `profs` VALUES (NULL, 'David Kosbie', 'Former tech lead of Microsoft, main prof of course 15-112 - a great CS intro course teaching Python and CS basic concepts', NULL),
(NULL, 'Anil Ada', 'Currently an Associate Teaching Professor in the Computer Science Department of Carnegie Mellon University. Main academic interests are education and theoretical computer science. Teach famous 15-251 course', NULL),
(NULL, 'Jason Howell', 'CMU math department. Kind and great. Teach 21241 linear algebra and matrices', NULL);
UNLOCK TABLES;

DROP TABLE IF EXISTS `courseprof`;
CREATE TABLE `courseprof` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `coursenumber` varchar(100) NOT NULL,
  `profname` varchar(50) DEFAULT NULL,
  `rating` int(4) unsigned DEFAULT NULL, 
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;

LOCK TABLES `courseprof` WRITE;
INSERT INTO `courseprof` VALUES (NULL, 15112, 'David Kosbie', NULL), (NULL, 21241, 'Jason Howell', NULL);
UNLOCK TABLES;

DROP TABLE IF EXISTS `courseeval`;
CREATE TABLE `courseeval` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user` varchar(45) NOT NULL,
  `coursenumber` varchar(100) NOT NULL,
  `profname` varchar(50) NOT NULL,
  `semester` varchar(5) NOT NULL,
  `rating` int(4) unsigned DEFAULT NULL, 
  `comment` varchar(4096) DEFAULT NULL,
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;

LOCK TABLES `courseeval` WRITE;
INSERT INTO `courseeval` VALUES (NULL, 'tom', 15112, 'David Kosbie', 'F19', 5, 'A good course!'), (NULL, 'Helen', 21241, 'Jason Howell', 'F19', 5, 'Kind and helpful professor!');
UNLOCK TABLES;

DROP TABLE IF EXISTS `profeval`;
CREATE TABLE `profeval` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user` varchar(45) NOT NULL,
  `profname` varchar(50) NOT NULL,
  `rating` int(4) unsigned DEFAULT NULL, 
  `comment` varchar(4096) DEFAULT NULL,
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;

LOCK TABLES `profeval` WRITE;
INSERT INTO `profeval` VALUES (NULL, 'Helen', 'David Kosbie', 5, 'An interesting prof!'), (NULL, 'tom', 'Jason Howell', 5, 'A kind guy!');
UNLOCK TABLES;





