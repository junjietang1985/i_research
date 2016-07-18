CREATE TABLE `apartment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `last_sync` date NOT NULL,
  `square` double unsigned NOT NULL,
  `price` double unsigned NOT NULL,
  `room` int(11) NOT NULL,
  `immo_id` bigint(20) NOT NULL,
  `private_offer` tinyint(1) NOT NULL,
  `title` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `latitude` float unsigned DEFAULT NULL,
  `longitude` float unsigned DEFAULT NULL,
  `area_text_search` varchar(100) NOT NULL,
  `district` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;