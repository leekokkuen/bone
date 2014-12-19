CREATE TABLE `idresource` (  
  `currentid` bigint(20) NOT NULL,
  PRIMARY KEY (`currentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO idresource(currentid) VALUES(10000000000000000);

CREATE FUNCTION nextid()
RETURNS bigint(20) 
BEGIN
DECLARE result bigint(20);
    UPDATE idresource i
    SET i.currentid = i.currentId + 1;

    SELECT currentId
    FROM idresource
    into result;

    RETURN(result);
END;
CREATE TABLE `purchaseorders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `createTime` datetime NOT NULL,
  `endTime` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `customer` varchar(30) NOT NULL,
`modelNo` varchar(30) NOT NULL,
  `quantity` float NOT NULL,
  `price` float NOT NULL,
`amount` float NOT NULL,
`currency` varchar(30) NOT NULL,
`purchasePrice` float NOT NULL,
`purchaseAmount` float NOT NULL,
`money` float NOT NULL,
`profit` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sendGoodsRecords` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `createTime` datetime NOT NULL,
  `endTime` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `purchaseOrderId` bigint(20) NOT NULL,
  `sendTime` datetime NOT NULL,
  `sendCode` varchar(255) NOT NULL,
  `remark` varchar(255) ,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `collectionMoneyRecords` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `createTime` datetime NOT NULL,
  `endTime` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `purchaseOrderId` bigint(20) NOT NULL,
  `collectionTime` datetime NOT NULL,
  `money` float NOT NULL,
  `remark` varchar(255) ,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;













CREATE TABLE `SimpleTypes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `classType` varchar(255) NOT NULL,
  `version` int(11) NOT NULL,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `createTime` datetime NOT NULL,
  `endTime` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `createTime` datetime NOT NULL,
  `endTime` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,

  
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `purchaseorders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `createTime` datetime NOT NULL,
  `endTime` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `customer` varchar(30) NOT NULL,
  `modelNo` varchar(30) NOT NULL,
  `quantity` float NOT NULL,
  `price` float NOT NULL,
  `amount` float NOT NULL,
  `currency` varchar(30) NOT NULL,
  `purchasePrice` float NOT NULL,
  `purchaseAmount` float NOT NULL,
  `money` float NOT NULL,
  `profit` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;