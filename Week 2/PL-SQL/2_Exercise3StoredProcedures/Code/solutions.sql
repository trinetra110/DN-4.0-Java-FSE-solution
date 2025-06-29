
-- Create accounts table
CREATE TABLE accounts (
  account_id   NUMBER PRIMARY KEY,
  account_type VARCHAR2(20),
  balance      NUMBER(10,2)
);

-- Create employees table
CREATE TABLE employees (
  employee_id    NUMBER PRIMARY KEY,
  name           VARCHAR2(50),
  department_id  NUMBER,
  salary         NUMBER(10,2)
);

-- Insert sample accounts
INSERT INTO accounts VALUES (101, 'SAVINGS', 1000);
INSERT INTO accounts VALUES (102, 'SAVINGS', 2000);
INSERT INTO accounts VALUES (201, 'CURRENT', 5000);
INSERT INTO accounts VALUES (202, 'CURRENT', 3000);

-- Insert sample employees
INSERT INTO employees VALUES (1, 'Alice', 10, 50000);
INSERT INTO employees VALUES (2, 'Bob', 10, 60000);
INSERT INTO employees VALUES (3, 'Charlie', 20, 45000);

COMMIT;

--------------------------------------------------------------------------------
-- Scenario 1: Monthly interest for savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE accounts
    SET balance = balance * 1.01
    WHERE account_type = 'SAVINGS';
    COMMIT;
END;
/

--------------------------------------------------------------------------------
-- Scenario 2: Employee bonus update
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department_id IN NUMBER,
    p_bonus_percent IN NUMBER
) IS
BEGIN
    UPDATE employees
    SET salary = salary + (salary * p_bonus_percent / 100)
    WHERE department_id = p_department_id;
    COMMIT;
END;
/

--------------------------------------------------------------------------------
-- Scenario 3: Fund transfer between accounts
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
) IS
    v_balance NUMBER;
BEGIN
    SELECT balance INTO v_balance FROM accounts WHERE account_id = p_from_account FOR UPDATE;
    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;

    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_account;

    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_account;

    COMMIT;
END;
/

--------------------------------------------------------------------------------
-- SHOW BEFORE: Account balances
PROMPT === BEFORE: Accounts ===
SELECT * FROM accounts;

-- Run Scenario 1
EXEC ProcessMonthlyInterest;

-- SHOW AFTER Scenario 1
PROMPT === AFTER Interest Applied ===
SELECT * FROM accounts;

--------------------------------------------------------------------------------
-- SHOW BEFORE: Employee salaries
PROMPT === BEFORE: Employees ===
SELECT * FROM employees;

-- Run Scenario 2
EXEC UpdateEmployeeBonus(10, 10); -- 10% bonus

-- SHOW AFTER Scenario 2
PROMPT === AFTER Bonus Update ===
SELECT * FROM employees;

--------------------------------------------------------------------------------
-- SHOW BEFORE: Fund Transfer
PROMPT === BEFORE Transfer: Accounts ===
SELECT * FROM accounts;

-- Run Scenario 3
EXEC TransferFunds(101, 202, 500);

-- SHOW AFTER Transfer
PROMPT === AFTER Transfer: Accounts ===
SELECT * FROM accounts;
