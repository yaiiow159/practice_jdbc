CREATE DATABASE IF NOT EXISTS new_schema;
CREATE USER IF NOT EXISTS 'root'@'%' IDENTIFIED BY 'root';
GRANT ALL PRIVILEGES ON new_schema.* TO 'root'@'%';

FLUSH PRIVILEGES;

USE new_schema;

DROP TABLE IF EXISTS Member;

CREATE TABLE Member (
    mId CHAR(20) NOT NULL,
    pId CHAR(10) NOT NULL,
    name VARCHAR(20) NOT NULL,
    birthday DATE,
    phone VARCHAR(20),
    address VARCHAR(40),
    email VARCHAR(20),
    introducer CHAR(20)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DELETE FROM Member;

INSERT INTO Member VALUES
('a0910001', 'A220123456', 'Jenny', '1979-01-01', '02-22220001', '台北市中山北路100號', 'jenny@ms1.hinet.net', 'b09055555'),
('a0911234', 'A12255888', 'Tony', '1980-12-12', '02-22880001', '台北市羅斯福路200號', 'tony@ms1.hinet.net', 'a0910001'),
('a0921111', 'A100999777', 'David', '1975-11-22', '04-2688888', '台中市沙鹿路200號', 'david@ms1.hinet.net', 'a0911234'),
('b09055555', 'C200456789', 'Jennifer', '1981-05-30', '03-33330001', '新竹市新源路300號', 'jen33@ms3.hinet.net', NULL),
('b0922468', 'R100200300', 'Jackson', '1980-03-03', '07-2345678', '高雄市博愛路70號', 'jad99@ms9.hinet.net', NULL),
('c0927777', 'B123123123', 'Su', '1982-06-06', NULL, '高雄市博愛路70號', 'su88@ms2.hinet.net', 'b09055555'); 