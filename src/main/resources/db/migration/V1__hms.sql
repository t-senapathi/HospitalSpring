CREATE DATABASE `hospital` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `t_admin` (
                           `username` varchar(16) NOT NULL,
                           `email` varchar(255) DEFAULT NULL,
                           `password` varchar(32) NOT NULL,
                           `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                           `is_deleted` tinyint(4) DEFAULT '0',
                           `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                           `pk_admin_id` int(11) NOT NULL AUTO_INCREMENT,
                           PRIMARY KEY (`pk_admin_id`),
                           UNIQUE KEY `pk_admin_id_UNIQUE` (`pk_admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_branch` (
                            `pk_branch_id` int(11) NOT NULL AUTO_INCREMENT,
                            `branch_location` varchar(45) NOT NULL,
                            `fk_hospital_id` int(11) NOT NULL,
                            `is_deleted` tinyint(4) NOT NULL DEFAULT '0',
                            `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                            `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                            PRIMARY KEY (`pk_branch_id`),
                            KEY `fk_Branch_Hospital_idx` (`fk_hospital_id`),
                            CONSTRAINT `fk_Branch_Hospital` FOREIGN KEY (`fk_hospital_id`) REFERENCES `t_hospital` (`pk_hospital_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

CREATE TABLE `t_branch_admin_mapping` (
                                          `fk_branch_id` int(11) NOT NULL,
                                          `fk_admin_id` int(11) NOT NULL,
                                          `is_deleted` tinyint(4) DEFAULT '0',
                                          `create_time` datetime DEFAULT NULL,
                                          `update_time` timestamp(2) NULL DEFAULT NULL,
                                          KEY `branch id_idx` (`fk_branch_id`),
                                          KEY `admin id_idx` (`fk_admin_id`),
                                          CONSTRAINT `admin id` FOREIGN KEY (`fk_admin_id`) REFERENCES `t_admin` (`pk_admin_id`),
                                          CONSTRAINT `branch id` FOREIGN KEY (`fk_branch_id`) REFERENCES `t_branch` (`pk_branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_branch_user_mapping` (
                                         `fk_branch_id` int(11) NOT NULL,
                                         `fk_user_id` int(11) NOT NULL,
                                         `is_deleted` tinyint(4) NOT NULL DEFAULT '0',
                                         `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                         `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                         KEY `branch_user_map_idx` (`fk_branch_id`),
                                         KEY `user_id_idx` (`fk_user_id`),
                                         CONSTRAINT `branch_id` FOREIGN KEY (`fk_branch_id`) REFERENCES `t_branch` (`pk_branch_id`),
                                         CONSTRAINT `user_id` FOREIGN KEY (`fk_user_id`) REFERENCES `t_user` (`pk_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_doctor` (
                            `pk_doctor_id` int(11) NOT NULL AUTO_INCREMENT,
                            `doctor_specialisation` varchar(45) DEFAULT NULL,
                            `fk_user_id` int(11) NOT NULL,
                            `is_deleted` tinyint(4) DEFAULT '0',
                            `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                            `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                            `experience` int(11) DEFAULT NULL,
                            PRIMARY KEY (`pk_doctor_id`),
                            KEY `fk_doctor_user1_idx` (`fk_user_id`),
                            CONSTRAINT `fk_doctor_user1` FOREIGN KEY (`fk_user_id`) REFERENCES `t_user` (`pk_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

CREATE TABLE `t_hospital` (
                              `pk_hospital_id` int(11) NOT NULL AUTO_INCREMENT,
                              `hospital_name` varchar(45) NOT NULL,
                              `is_deleted` tinyint(4) NOT NULL DEFAULT '0',
                              `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                              `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                              PRIMARY KEY (`pk_hospital_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `t_patient` (
                             `pk_patient_id` int(11) NOT NULL AUTO_INCREMENT,
                             `fk_user_id` int(11) NOT NULL,
                             `patient_height` int(11) DEFAULT NULL,
                             `patient_weight` int(11) DEFAULT NULL,
                             `is_deleted` tinyint(4) DEFAULT '0',
                             `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                             `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                             `door_no` varchar(45) DEFAULT NULL,
                             `street` varchar(45) DEFAULT NULL,
                             `city` varchar(45) DEFAULT NULL,
                             `blood_group` varchar(45) DEFAULT NULL,
                             PRIMARY KEY (`pk_patient_id`),
                             KEY `fk_patient_user1_idx` (`fk_user_id`),
                             CONSTRAINT `fk_patient_user1` FOREIGN KEY (`fk_user_id`) REFERENCES `t_user` (`pk_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

CREATE TABLE `t_patient_doctor_mapping` (
                                            `disease` varchar(45) DEFAULT NULL,
                                            `fk_patient_id` int(11) NOT NULL,
                                            `fk_doctor_id` int(11) NOT NULL,
                                            `is_deleted` tinyint(4) DEFAULT '0',
                                            `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                                            `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                            `pk_patient_doctor_id` int(11) NOT NULL AUTO_INCREMENT,
                                            PRIMARY KEY (`pk_patient_doctor_id`),
                                            KEY `id_idx` (`fk_patient_id`),
                                            KEY `doctor id_idx` (`fk_doctor_id`),
                                            CONSTRAINT `doctor id` FOREIGN KEY (`fk_doctor_id`) REFERENCES `t_user` (`pk_user_id`),
                                            CONSTRAINT `patient id` FOREIGN KEY (`fk_patient_id`) REFERENCES `t_user` (`pk_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `t_role` (
                          `pk_role_id` int(11) NOT NULL AUTO_INCREMENT,
                          `role_desc` varchar(45) NOT NULL,
                          `is_deleted` tinyint(4) NOT NULL DEFAULT '0',
                          `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                          PRIMARY KEY (`pk_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `t_user` (
                          `username` varchar(16) NOT NULL,
                          `password` varchar(32) NOT NULL,
                          `pk_user_id` int(11) NOT NULL AUTO_INCREMENT,
                          `fk_role_id` int(11) NOT NULL,
                          `first_name` varchar(45) NOT NULL,
                          `last_name` varchar(45) DEFAULT NULL,
                          `age` int(11) DEFAULT NULL,
                          `is_deleted` tinyint(4) NOT NULL DEFAULT '0',
                          `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                          PRIMARY KEY (`pk_user_id`),
                          UNIQUE KEY `username_UNIQUE` (`username`),
                          KEY `fk_role_id_idx` (`fk_role_id`),
                          CONSTRAINT `fk_role_id` FOREIGN KEY (`fk_role_id`) REFERENCES `t_role` (`pk_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
