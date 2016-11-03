CREATE TABLE customer (
	customer_id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
	name varchar(45) NOT NULL,
	address varchar(255) NOT NULL,
	create_date datetime NOT NULL,
	PRIMARY KEY (customer_id)
)ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

