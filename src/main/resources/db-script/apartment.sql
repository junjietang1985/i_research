CREATE TABLE `apartment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `last_sync` date NOT NULL,
  `sqare` float unsigned NOT NULL,
  `price` float unsigned NOT NULL,
  `room` int(11) NOT NULL,
  `immo_id` bigint(20) NOT NULL,
  `private_offer` tinyint(1) NOT NULL,
  `title` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `latitude` float unsigned NOT NULL,
  `longitude` float unsigned NOT NULL,
  `area_text_search` varchar(100) NOT NULL,
  `district` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;