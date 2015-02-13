-- Create impact user
CREATE USER 'questions'@'localhost' IDENTIFIED BY 'questions_db_access';
-- Grant permissions to impact user
GRANT INSERT ON questions.* TO 'questions'@'localhost';
GRANT DELETE ON questions.* TO 'questions'@'localhost';
GRANT UPDATE ON questions.* TO 'questions'@'localhost';
GRANT SELECT ON questions.* TO 'questions'@'localhost';
-- Reload permissions
FLUSH PRIVILEGES;