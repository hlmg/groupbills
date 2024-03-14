INSERT INTO member (login_id, password, name)
VALUES ('login_id1', '1234', 'name1'),
       ('login_id2', '1234', 'name2'),
       ('login_id3', '1234', 'name3'),
       ('login_id4', '1234', 'name4');

INSERT INTO settlement (name)
VALUES ('settlement1'),
       ('settlement2'),
       ('settlement3'),
       ('settlement4');

-- Settlement #1
INSERT INTO settlement_participant (SETTLEMENT_ID, MEMBER_ID)
VALUES (1, 1),
       (1, 2);
INSERT INTO expense (name, settlement_id, payer_member_id, amount, expense_date_time)
VALUES ('train', 1, 1, 80000, CURRENT_TIMESTAMP()),
       ('hotel', 1, 2, 200000, CURRENT_TIMESTAMP()),
       ('dinner', 1, 1, 50000, CURRENT_TIMESTAMP());

-- Settlement #2
INSERT INTO settlement_participant (SETTLEMENT_ID, MEMBER_ID)
VALUES (2, 1),
       (2, 2),
       (2, 3),
       (2, 4);
INSERT INTO expense (name, settlement_id, payer_member_id, amount, expense_date_time)
VALUES ('train', 2, 1, 150000, CURRENT_TIMESTAMP()),
       ('hotel', 2, 2, 30000, CURRENT_TIMESTAMP()),
       ('dinner', 2, 1, 80000, CURRENT_TIMESTAMP()),
       ('dinner', 2, 4, 80000, CURRENT_TIMESTAMP());

-- Settlement #3
INSERT INTO settlement_participant (SETTLEMENT_ID, MEMBER_ID)
VALUES (3, 1),
       (3, 2),
       (3, 3),
       (3, 4);
INSERT INTO expense (name, settlement_id, payer_member_id, amount, expense_date_time)
VALUES ('train', 3, 1, 100000, CURRENT_TIMESTAMP()),
       ('hotel', 3, 2, 100000, CURRENT_TIMESTAMP()),
       ('hotel', 3, 2, 200000, CURRENT_TIMESTAMP());

-- Settlement #4
INSERT INTO settlement_participant (SETTLEMENT_ID, MEMBER_ID)
VALUES (4, 1),
       (4, 2),
       (4, 3);
INSERT INTO expense (name, settlement_id, payer_member_id, amount, expense_date_time)
VALUES ('chicken', 4, 1, 100, CURRENT_TIMESTAMP());
