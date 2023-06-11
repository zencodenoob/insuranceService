CREATE TABLE clients(
id UUID PRIMARY KEY,
name VARCHAR(50),
dob DATE,
address VARCHAR(100),
email VARCHAR(30),
phone VARCHAR(15)
);

CREATE TABLE claims(
id UUID PRIMARY KEY,
claim_number VARCHAR(20),
description VARCHAR(60),
claim_date DATE,
claim_status BOOLEAN
);
CREATE TABLE insurance(
id UUID PRIMARY KEY,
policy_number VARCHAR(20),
type VARCHAR(20),
coverage_amount INTEGER,
premium INTEGER,
start_date DATE,
end_date DATE,
client_id UUID REFERENCES clients,
claim_id UUID REFERENCES claims
);
CREATE TABLE users(
username VARCHAR(50) PRIMARY KEY,
password VARCHAR(50),
enabled TINYINT
);
CREATE TABLE authorities(
username VARCHAR(50) REFERENCES users,
authority VARCHAR(50)
);