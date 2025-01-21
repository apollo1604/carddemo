-- Clean existing data from the tables
DELETE FROM transactions;
DELETE FROM card_accounts;
DELETE FROM merchants;

-- Reset auto-increment sequences (PostgreSQL-specific)
ALTER SEQUENCE transactions_transaction_id_seq RESTART WITH 1;
ALTER SEQUENCE merchants_merchant_id_seq RESTART WITH 1;

-- Insert merchants
INSERT INTO merchants (merchant_name, merchant_city, merchant_zip)
VALUES
    ('Merchant A', 'New York', '10001'),
    ('Merchant B', 'Los Angeles', '90001'),
    ('Merchant C', 'Chicago', '60601'),
    ('Merchant D', 'Houston', '77001'),
    ('Merchant E', 'Phoenix', '85001');

-- Insert card accounts
INSERT INTO card_accounts (account_id, card_number)
VALUES
    ('12345678901', '1111222233334444'),
    ('98765432109', '5555666677778888'),
    ('11223344556', '9999000011112222'),
    ('22334455667', '2222333344445555'),
    ('33445566778', '6666777788889999'),
    ('44556677889', '0000111122223333'),
    ('55667788990', '3333444455556666'),
    ('66778899001', '7777888899990000'),
    ('77889900112', '8888999900001111'),
    ('88990011223', '9999111122223333');

-- Insert 40 transactions
INSERT INTO transactions (card_number, account_id, transaction_amount, transaction_type_code, transaction_category_code, transaction_source, transaction_description, original_date, processing_date, merchant_id)
VALUES
    ('1111222233334444', '12345678901', 50.75, 'T001', 'C001', 'Online', 'Purchase at Store A', '2025-01-01', '2025-01-02', 1),
    ('5555666677778888', '98765432109', 100.50, 'T002', 'C002', 'POS', 'Purchase at Store B', '2025-01-01', '2025-01-02', 2),
    ('9999000011112222', '11223344556', 250.00, 'T003', 'C003', 'Mobile', 'Purchase at Store C', '2025-01-02', '2025-01-03', 3),
    ('2222333344445555', '22334455667', 300.75, 'T004', 'C004', 'Web', 'Purchase at Store D', '2025-01-03', '2025-01-04', 4),
    ('6666777788889999', '33445566778', 75.50, 'T005', 'C005', 'Kiosk', 'Purchase at Store E', '2025-01-04', '2025-01-05', 5),

    ('0000111122223333', '44556677889', 125.00, 'T006', 'C006', 'POS', 'Purchase at Store F', '2025-01-05', '2025-01-06', 1),
    ('3333444455556666', '55667788990', 90.75, 'T007', 'C007', 'Online', 'Purchase at Store G', '2025-01-06', '2025-01-07', 2),
    ('7777888899990000', '66778899001', 150.00, 'T008', 'C008', 'POS', 'Purchase at Store H', '2025-01-07', '2025-01-08', 3),
    ('8888999900001111', '77889900112', 200.25, 'T009', 'C009', 'Mobile', 'Purchase at Store I', '2025-01-08', '2025-01-09', 4),
    ('9999111122223333', '88990011223', 500.50, 'T010', 'C010', 'POS', 'Purchase at Store J', '2025-01-09', '2025-01-10', 5),

    ('1111222233334444', '12345678901', 80.75, 'T011', 'C011', 'Online', 'Purchase at Store K', '2025-01-10', '2025-01-11', 1),
    ('5555666677778888', '98765432109', 60.50, 'T012', 'C012', 'POS', 'Purchase at Store L', '2025-01-11', '2025-01-12', 2),
    ('9999000011112222', '11223344556', 95.00, 'T013', 'C013', 'Mobile', 'Purchase at Store M', '2025-01-12', '2025-01-13', 3),
    ('2222333344445555', '22334455667', 125.75, 'T014', 'C014', 'Web', 'Purchase at Store N', '2025-01-13', '2025-01-14', 4),
    ('6666777788889999', '33445566778', 135.50, 'T015', 'C015', 'Kiosk', 'Purchase at Store O', '2025-01-14', '2025-01-15', 5),

    ('0000111122223333', '44556677889', 55.00, 'T016', 'C016', 'POS', 'Purchase at Store P', '2025-01-15', '2025-01-16', 1),
    ('3333444455556666', '55667788990', 110.75, 'T017', 'C017', 'Online', 'Purchase at Store Q', '2025-01-16', '2025-01-17', 2),
    ('7777888899990000', '66778899001', 145.00, 'T018', 'C018', 'POS', 'Purchase at Store R', '2025-01-17', '2025-01-18', 3),
    ('8888999900001111', '77889900112', 175.25, 'T019', 'C019', 'Mobile', 'Purchase at Store S', '2025-01-18', '2025-01-19', 4),
    ('9999111122223333', '88990011223', 250.50, 'T020', 'C020', 'POS', 'Purchase at Store T', '2025-01-19', '2025-01-20', 5);
