CREATE TABLE clients(
id UUID PRIMARY KEY,
name VARCHAR(100),
dob DATE,
address VARCHAR(100),
email VARCHAR(30),
phone VARCHAR(15)
);
CREATE TABLE insurance(
id UUID PRIMARY KEY,
policy_number VARCHAR(20),
type VARCHAR(10),
coverage_amount INTEGER,
premium INTEGER,
start_date DATE,
end_date DATE,
client_id UUID REFERENCES clients
);
CREATE TABLE claims(
id UUID PRIMARY KEY,
claim_number VARCHAR(20),
description VARCHAR(60),
claim_date DATE,
claim_status BOOLEAN,
insurance_id UUID REFERENCES insurance
);