INSERT INTO users VALUES
('employee','{noop}password',1),
('manager', '{noop}password',1);

INSERT INTO authorities values
('employee','ROLE_EMPLOYEE'),
('manager', 'ROLE_EMPLOYEE'),
('manager', 'ROLE_MANAGER');
