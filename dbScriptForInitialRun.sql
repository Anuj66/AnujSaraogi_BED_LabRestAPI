INSERT IGNORE INTO roles(id, name) VALUES(1, 'ROLE_ADMIN');
INSERT IGNORE INTO roles(id, name) VALUES(2, 'ROLE_USER');

INSERT IGNORE INTO USERS(id, username, password)
VALUES(1, "admin", "$2a$12$d.VT3b8mcCKNSz7gMro4Ne.eoLV0ta5jX/i2rX8EIL0GbQJT0xAnO"); --Password: 123456

SET @user_id = 1,
    @role_id = 1;
INSERT INTO user_roles
    (user_id, role_id)
VALUES
    (@user_id, @role_id)
ON DUPLICATE KEY UPDATE
    user_id = @user_id,
    role_id = @role_id;