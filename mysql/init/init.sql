SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `sample` DEFAULT CHARACTER SET utf8mb4;
USE `sample`;

CREATE TABLE IF NOT EXISTS `class_info` (
  `grade_no` INTEGER NOT NULL COMMENT '学年',
  `class_no` INTEGER NOT NULL COMMENT '学級',
  `created_at` DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '作成日',
  `updated_at` DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '更新日',
  PRIMARY KEY (`grade_no`, `class_no`)
)
COMMENT = 'クラス';

CREATE TABLE IF NOT EXISTS `teacher` (
  `teacher_id` SERIAL NOT NULL COMMENT '教員番号',
  `family_name` VARCHAR(20) COMMENT '苗字',
  `first_name` VARCHAR(20) COMMENT '名前',
  `created_at` DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '作成日',
  `updated_at` DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '更新日',
  PRIMARY KEY (`teacher_id`)
)
COMMENT = '教員';

CREATE TABLE IF NOT EXISTS `student` (
  `student_id` SERIAL NOT NULL COMMENT '生徒番号',
  `family_name` VARCHAR(20) COMMENT '苗字',
  `first_name` VARCHAR(20) COMMENT '名前',
  `created_at` DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '作成日',
  `updated_at` DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '更新日',
  PRIMARY KEY (`student_id`)
)
COMMENT = '生徒';

CREATE TABLE IF NOT EXISTS `subject` (
  `subject_id` SERIAL NOT NULL COMMENT '科目番号',
  `subject_name` VARCHAR(20) NOT NULL COMMENT '苗字',
  `created_at` DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '作成日',
  `updated_at` DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '更新日',
  PRIMARY KEY (`subject_id`)
)
COMMENT = '科目';

CREATE TABLE IF NOT EXISTS `record` (
  `student_id` BIGINT unsigned NOT NULL COMMENT '生徒番号',
  `subject_id` BIGINT unsigned NOT NULL COMMENT '科目番号',
  `score` INTEGER NOT NULL COMMENT '点数',
  `created_at` DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '作成日',
  `updated_at` DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '更新日',
  PRIMARY KEY (`student_id`, `subject_id`),
  foreign key student_id_foreign_key (`student_id`) references `student` (`student_id`),
  foreign key subject_id_foreign_key (`subject_id`) references `subject` (`subject_id`)
)
COMMENT = '成績';

CREATE USER 'system' IDENTIFIED BY 'system';

GRANT ALL ON `sample`.* TO 'system';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;