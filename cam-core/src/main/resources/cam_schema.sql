 DROP TABLE IF EXISTS cam_role ;
 DROP TABLE IF EXISTS cam_permission ;
 DROP TABLE IF EXISTS cam_authorization ;

CREATE TABLE `cam_role` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `user_criteria` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `cam_permission` (
  `id` varchar(32) NOT NULL,
  `action` varchar(100) DEFAULT NULL,
  `object_type` varchar(100) DEFAULT NULL,
  `criteria` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `cam_authorization` (
  `id` varchar(32) NOT NULL,
  `role_id` varchar(32) DEFAULT NULL,
  `perm_id` varchar(32) DEFAULT NULL,
  `authorized_by` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;