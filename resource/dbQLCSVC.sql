-- Tạo database
CREATE DATABASE QLCSVC;
USE QLCSVC;

-- Bảng roles
CREATE TABLE roles (
    role_id INT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(50) NOT NULL UNIQUE
);

-- Bảng functions
CREATE TABLE functions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

-- Bảng permission_types
CREATE TABLE permission_types (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

-- Bảng permissions
CREATE TABLE permissions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    role_id INT,
    function_id INT,
    permission_type_id INT,
    allowed BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (role_id) REFERENCES roles(role_id),
    FOREIGN KEY (function_id) REFERENCES functions(id),
    FOREIGN KEY (permission_type_id) REFERENCES permission_types(id),
    UNIQUE(role_id, function_id, permission_type_id)
);

-- Bảng users
CREATE TABLE users (
    user_id VARCHAR(10) PRIMARY KEY,
    fullname VARCHAR(100),
    username VARCHAR(50),
    yearold VARCHAR(50),
    email VARCHAR(100),
    phoneNumber VARCHAR(15),
    password VARCHAR(255),
    status VARCHAR(20),
    deleted TINYINT(1),
    thumbnail VARCHAR(500),
    role_id INT,
    FOREIGN KEY (role_id) REFERENCES roles(role_id)
);

-- Bảng room
INSERT INTO room (room_id, room_number, seating_capacity, status)
VALUES 
('R001', 'A101', 50, 'AVAILABLE'),
('R002', 'A102', 50, 'AVAILABLE'),
('R003', 'B201', 60, 'AVAILABLE'),
('R004', 'B202', 45, 'MAINTENANCE'),
('R005', 'C301', 80, 'AVAILABLE'),
('R006', 'C302', 70, 'OCCUPIED');


-- Bảng devices (sửa lại từ định nghĩa đầu tiên, bỏ định nghĩa thứ hai)
CREATE TABLE devices (
    id VARCHAR(255) PRIMARY KEY,
    device_name VARCHAR(255) NOT NULL,
    device_type VARCHAR(255) NOT NULL,
    purchase_date DATE,
    supplier VARCHAR(255),
    price DECIMAL(10, 2), -- Đổi từ value thành price
    status ENUM('AVAILABLE', 'UNAVAILABLE', 'UNDER_MAINTENANCE', 'BROKEN', 'DISCARDED') DEFAULT 'AVAILABLE', -- Đồng bộ với DeviceStatus
    room_id VARCHAR(255),
    quantity INT DEFAULT 1,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (room_id) REFERENCES room(room_id) -- Sửa tham chiếu từ rooms(id) thành room(room_id)
);

-- Bảng device_borrow_requests (đổi tên từ borrowing_device_request)
CREATE TABLE device_borrow_requests (
    id_request VARCHAR(10) PRIMARY KEY,
    lecturer_user VARCHAR(10) NOT NULL,
    device_id VARCHAR(10) NOT NULL,
    request_date DATETIME NOT NULL,
    due_date DATETIME NOT NULL,
    borrowing_request ENUM('PENDING', 'APPROVED', 'REJECTED', 'COMPLETED', 'CANCELLED') NOT NULL, -- Đồng bộ với BorrowingRequestStatus
    FOREIGN KEY (lecturer_user) REFERENCES users(user_id),
    FOREIGN KEY (device_id) REFERENCES devices(id), -- Sửa tham chiếu từ devices(device_id) thành devices(id)
    CHECK (due_date > request_date)
);

-- Bảng borrowing_room_request
CREATE TABLE borrowing_room_request (
    id_request VARCHAR(10) PRIMARY KEY,
    lecturer_user VARCHAR(10) NOT NULL,
    room_id VARCHAR(10) NOT NULL,
    request_date DATETIME NOT NULL,
    due_date DATETIME NOT NULL,
    borrowing_request ENUM('PENDING', 'APPROVED', 'RETURNED', 'REJECTED') NOT NULL,
    FOREIGN KEY (lecturer_user) REFERENCES users(user_id),
    FOREIGN KEY (room_id) REFERENCES room(room_id),
    CHECK (due_date > request_date)
);

-- Bảng incident
CREATE TABLE incident (
    id_report VARCHAR(10) PRIMARY KEY,
    reported_by VARCHAR(10) NOT NULL,
    device_id VARCHAR(10),
    room_id VARCHAR(10),
    description TEXT NOT NULL,
    report_date DATETIME NOT NULL,
    handled_by VARCHAR(10),
    status ENUM('PENDING', 'IN_PROGRESS', 'RESOLVED') NOT NULL,
    FOREIGN KEY (reported_by) REFERENCES users(user_id),
    FOREIGN KEY (device_id) REFERENCES devices(id), -- Sửa tham chiếu từ devices(device_id) thành devices(id)
    FOREIGN KEY (room_id) REFERENCES room(room_id),
    FOREIGN KEY (handled_by) REFERENCES users(user_id),
    CHECK ((device_id IS NOT NULL OR room_id IS NOT NULL))
);

-- Trigger tự động tạo ID

-- Trigger cho bảng room
DELIMITER //
CREATE TRIGGER before_insert_room
BEFORE INSERT ON room
FOR EACH ROW
BEGIN
    DECLARE new_id INT;
    SET new_id = (SELECT COALESCE(MAX(CAST(SUBSTRING(room_id, 2) AS UNSIGNED)), 0) + 1 FROM room WHERE room_id LIKE 'R%');
    SET NEW.room_id = CONCAT('R', LPAD(new_id, 3, '0'));
END //
DELIMITER ;

-- Trigger cho bảng devices (giữ nguyên từ định nghĩa đầu tiên)
DELIMITER //
CREATE TRIGGER before_insert_devices
BEFORE INSERT ON devices
FOR EACH ROW
BEGIN
    DECLARE max_id INT;
    DECLARE new_id VARCHAR(10);
    SELECT IFNULL(MAX(CAST(SUBSTRING(id, 2) AS UNSIGNED)), 0)
    INTO max_id
    FROM devices;
    SET new_id = CONCAT('D', LPAD(max_id + 1, 3, '0'));
    SET NEW.id = new_id;
END //
DELIMITER ;

-- Trigger cho bảng borrowing_room_request
DELIMITER //
CREATE TRIGGER before_insert_borrowing_room_request
BEFORE INSERT ON borrowing_room_request
FOR EACH ROW
BEGIN
    DECLARE new_id INT;
    SET new_id = (SELECT COALESCE(MAX(CAST(SUBSTRING(id_request, 3) AS UNSIGNED)), 0) + 1 FROM borrowing_room_request WHERE id_request LIKE 'BR%');
    SET NEW.id_request = CONCAT('BR', LPAD(new_id, 3, '0'));
END //
DELIMITER ;

-- Trigger cho bảng device_borrow_requests (đổi tên từ before_insert_borrowing_device_request)
DELIMITER //
CREATE TRIGGER before_insert_device_borrow_requests
BEFORE INSERT ON device_borrow_requests
FOR EACH ROW
BEGIN
    DECLARE new_id INT;
    SET new_id = (SELECT COALESCE(MAX(CAST(SUBSTRING(id_request, 3) AS UNSIGNED)), 0) + 1 FROM device_borrow_requests WHERE id_request LIKE 'BD%');
    SET NEW.id_request = CONCAT('BD', LPAD(new_id, 3, '0'));
END //
DELIMITER ;

-- Trigger cho bảng incident
DELIMITER //
CREATE TRIGGER before_insert_incident
BEFORE INSERT ON incident
FOR EACH ROW
BEGIN
    DECLARE new_id INT;
    SET new_id = (SELECT COALESCE(MAX(CAST(SUBSTRING(id_report, 4) AS UNSIGNED)), 0) + 1 FROM incident WHERE id_report LIKE 'INC%');
    SET NEW.id_report = CONCAT('INC', LPAD(new_id, 3, '0'));
END //
DELIMITER ;

-- Trigger cho bảng users
DELIMITER //
CREATE TRIGGER before_insert_users
BEFORE INSERT ON users
FOR EACH ROW
BEGIN
    DECLARE max_id INT;
    DECLARE new_id VARCHAR(10);
    SELECT IFNULL(MAX(CAST(SUBSTRING(user_id, 4) AS UNSIGNED)), 0)
    INTO max_id
    FROM users;
    SET new_id = CONCAT('MTL', LPAD(max_id + 1, 4, '0'));
    IF NEW.user_id IS NULL OR NEW.user_id = '' THEN
        SET NEW.user_id = new_id;
    END IF;
END //
DELIMITER ;

-- Trigger cập nhật trạng thái phòng khi đơn mượn được duyệt hoặc từ chối
DELIMITER //
CREATE TRIGGER after_update_borrowing_room_request
AFTER UPDATE ON borrowing_room_request
FOR EACH ROW
BEGIN
    IF NEW.borrowing_request = 'APPROVED' THEN
        UPDATE room
        SET status = 'OCCUPIED'
        WHERE room_id = NEW.room_id;
    ELSEIF NEW.borrowing_request IN ('REJECTED', 'RETURNED') THEN
        UPDATE room
        SET status = 'AVAILABLE'
        WHERE room_id = NEW.room_id;
    END IF;
END //
DELIMITER ;

-- Trigger cập nhật trạng thái thiết bị khi đơn mượn được duyệt hoặc từ chối (đổi tên và sửa logic)
DELIMITER //
CREATE TRIGGER after_update_device_borrow_requests
AFTER UPDATE ON device_borrow_requests
FOR EACH ROW
BEGIN
    IF NEW.borrowing_request = 'APPROVED' THEN
        UPDATE devices
        SET status = 'UNAVAILABLE'
        WHERE id = NEW.device_id;
    ELSEIF NEW.borrowing_request IN ('REJECTED', 'COMPLETED', 'CANCELLED') THEN
        UPDATE devices
        SET status = 'AVAILABLE'
        WHERE id = NEW.device_id;
    END IF;
END //
DELIMITER ;

-- Dữ liệu mẫu

-- 1. Insert roles
INSERT INTO roles (role_name)
VALUES ('MAINTENANCE'), ('LECTURER'), ('ADMIN');

-- 2. Insert users
INSERT INTO users (user_id, fullname, username, yearold, email, phoneNumber, password, status, deleted, thumbnail, role_id)
VALUES 
('MTL0001', 'Nguyễn Anh Nguyên', 'nguyen34', '12/09/2000', 'nanh@gmail.com', '0983772722', 'c985809daeefd685a992c96fd7f64c0ab6c50e9ad97f89859e6b46a8e562c99c', 'ACTIVE', 0, 'https://res.cloudinary.com/dtuhfcdph/image/upload/v1745922241/bfmj6ald6mw73zrddcn5.jpg', 3),
('MTL0002', 'Vo Thien Linh', 'vothienlinh', '15/05/1999', 'vothienlinh2@gmail.com', '0912345678', 'c985809daeefd685a992c96fd7f64c0ab6c50e9ad97f89859e6b46a8e562c99c', 'ACTIVE', 0, "https://res.cloudinary.com/dtuhfcdph/image/upload/v1745922241/bfmj6ald6mw73zrddcn5.jpg", 1),
('MTL0003', 'Nguyen Van A', 'nguyenvana', '20/03/1998', 'vana@example.com', '0912345678', 'c985809daeefd685a992c96fd7f64c0ab6c50e9ad97f89859e6b46a8e562c99c', 'ACTIVE', 0, "https://res.cloudinary.com/dtuhfcdph/image/upload/v1745922241/bfmj6ald6mw73zrddcn5.jpg", 2);

-- 3. Insert rooms
INSERT INTO room (room_number, seating_capacity, status)
VALUES 
('B201', 60, 'AVAILABLE'),
('B202', 45, 'MAINTENANCE'),
('C301', 80, 'AVAILABLE'),
('C302', 70, 'UNAVAILABLE');

-- 4. Insert devices (đồng bộ với cấu trúc mới)
INSERT INTO devices (device_name, device_type, purchase_date, supplier, price, status, room_id, quantity)
VALUES 
('SmartBoard', 'Electronics', '2023-11-10', 'EduSmart', 15000000.00, 'AVAILABLE', (SELECT room_id FROM room WHERE room_number = 'B201'), 2),
('Speaker', 'Audio', '2023-12-05', 'SoundPro', 2000000.00, 'MAINTENANCE', (SELECT room_id FROM room WHERE room_number = 'B202'), 4),
('Camera', 'Video', '2024-03-18', 'VisionX', 8000000.00, 'AVAILABLE', (SELECT room_id FROM room WHERE room_number = 'C301'), 3),
('Laptop', 'Computer', '2024-04-10', 'TechCorp', 12000000.00, 'AVAILABLE', (SELECT room_id FROM room WHERE room_number = 'C302'), 6);


-- 5. Insert borrowing_room_request
INSERT INTO borrowing_room_request (lecturer_user, room_id, request_date, due_date, borrowing_request)
VALUES
('MTL0002', (SELECT room_id FROM room WHERE room_number = 'B201'), '2025-04-19 09:00:00', '2025-04-19 11:00:00', 'APPROVED'),
('MTL0003', (SELECT room_id FROM room WHERE room_number = 'C301'), '2025-04-22 10:00:00', '2025-04-22 12:00:00', 'PENDING'),
('MTL0004', (SELECT room_id FROM room WHERE room_number = 'C302'), '2025-04-23 13:00:00', '2025-04-23 15:00:00', 'REJECTED'),
('MTL0001', (SELECT room_id FROM room WHERE room_number = 'B202'), '2025-04-24 08:00:00', '2025-04-24 10:00:00', 'PENDING');


-- 6. Insert device_borrow_requests (đồng bộ với cấu trúc mới)
INSERT INTO device_borrow_requests (lecturer_user, device_id, request_date, due_date, borrowing_request)
VALUES
('MTL0002', (SELECT id FROM devices WHERE device_name = 'SmartBoard'), '2025-04-19 09:00:00', '2025-04-19 11:00:00', 'APPROVED'),
('MTL0003', (SELECT id FROM devices WHERE device_name = 'Speaker'), '2025-04-20 10:00:00', '2025-04-20 12:00:00', 'REJECTED'),
('MTL0004', (SELECT id FROM devices WHERE device_name = 'Camera'), '2025-04-21 13:00:00', '2025-04-21 15:00:00', 'PENDING'),
('MTL0001', (SELECT id FROM devices WHERE device_name = 'Laptop'), '2025-04-22 08:00:00', '2025-04-22 10:00:00', 'APPROVED');

-- 7. Insert incident
INSERT INTO incident (reported_by, room_id, description, report_date, status)
VALUES
('MTL0002', (SELECT room_id FROM room WHERE room_number = 'B202'), 'Speaker not working properly', '2025-04-20 10:15:00', 'PENDING'),
('MTL0003', (SELECT room_id FROM room WHERE room_number = 'C301'), 'Camera connection issue', '2025-04-21 08:30:00', 'RESOLVED'),
('MTL0004', (SELECT room_id FROM room WHERE room_number = 'C302'), 'Broken table near board', '2025-04-21 14:00:00', 'PENDING'),
('MTL0001', (SELECT room_id FROM room WHERE room_number = 'A102'), 'Air conditioner not functioning', '2025-04-19 09:45:00', 'RESOLVED');


-- 8. Insert permission_types
INSERT INTO permission_types (id, name) VALUES
(1, 'view'),
(2, 'add'),
(3, 'edit'),
(4, 'delete');

-- 9. Insert functions
INSERT INTO functions (id, name) VALUES
(1, 'Quản lý phòng'),
(2, 'Quản lý thiết bị'),
(3, 'Quản lý người dùng'),
(4, 'Phân quyền'),
(5, 'Mượn phòng'),
(6, 'Mượn thiết bị'),
(7, 'Trả cơ sở vật chất'),
(8, 'Báo cáo sự cố'),
(9, 'Xử lý sự cố');

-- 10. Insert permissions
INSERT INTO permissions (id, role_id, function_id, permission_type_id, allowed) VALUES
(421, 3, 1, 1, 1), -- MAINTENANCE: view Quản lý phòng
(422, 3, 1, 2, 1), -- MAINTENANCE: add Quản lý phòng
(423, 3, 1, 3, 1), -- MAINTENANCE: edit Quản lý phòng
(424, 3, 1, 4, 1), -- MAINTENANCE: delete Quản lý phòng
(425, 2, 1, 1, 1), -- LECTURER: view Quản lý phòng
(426, 2, 1, 2, 0), -- LECTURER: add Quản lý phòng
(427, 2, 1, 3, 0), -- LECTURER: edit Quản lý phòng
(428, 2, 1, 4, 0), -- LECTURER: delete Quản lý phòng
(429, 1, 1, 1, 0), -- ADMIN: view Quản lý phòng
(430, 1, 1, 2, 0), -- ADMIN: add Quản lý phòng
(431, 1, 1, 3, 0), -- ADMIN: edit Quản lý phòng
(432, 1, 1, 4, 0), -- ADMIN: delete Quản lý phòng
(433, 3, 2, 1, 1), -- MAINTENANCE: view Quản lý thiết bị
(434, 3, 2, 2, 1), -- MAINTENANCE: add Quản lý thiết bị
(435, 3, 2, 3, 1), -- MAINTENANCE: edit Quản lý thiết bị
(436, 3, 2, 4, 1), -- MAINTENANCE: delete Quản lý thiết bị
(437, 2, 2, 1, 1), -- LECTURER: view Quản lý thiết bị
(438, 2, 2, 2, 0), -- LECTURER: add Quản lý thiết bị
(439, 2, 2, 3, 0), -- LECTURER: edit Quản lý thiết bị
(440, 2, 2, 4, 0), -- LECTURER: delete Quản lý thiết bị
(441, 1, 2, 1, 0), -- ADMIN: view Quản lý thiết bị
(442, 1, 2, 2, 0), -- ADMIN: add Quản lý thiết bị
(443, 1, 2, 3, 0), -- ADMIN: edit Quản lý thiết bị
(444, 1, 2, 4, 0), -- ADMIN: delete Quản lý thiết bị
(445, 3, 3, 1, 1), -- MAINTENANCE: view Quản lý người dùng
(446, 3, 3, 2, 1), -- MAINTENANCE: add Quản lý người dùng
(447, 3, 3, 3, 1), -- MAINTENANCE: edit Quản lý người dùng
(448, 3, 3, 4, 1), -- MAINTENANCE: delete Quản lý người dùng
(449, 2, 3, 1, 0), -- LECTURER: view Quản lý người dùng
(450, 2, 3, 2, 0), -- LECTURER: add Quản lý người dùng
(451, 2, 3, 3, 0), -- LECTURER: edit Quản lý người dùng
(452, 2, 3, 4, 0), -- LECTURER: delete Quản lý người dùng
(453, 1, 3, 1, 0), -- ADMIN: view Quản lý người dùng
(454, 1, 3, 2, 0), -- ADMIN: add Quản lý người dùng
(455, 1, 3, 3, 0), -- ADMIN: edit Quản lý người dùng
(456, 1, 3, 4, 0), -- ADMIN: delete Quản lý người dùng
(457, 3, 4, 1, 1), -- MAINTENANCE: view Phân quyền
(458, 3, 4, 2, 1), -- MAINTENANCE: add Phân quyền
(459, 3, 4, 3, 1), -- MAINTENANCE: edit Phân quyền
(460, 3, 4, 4, 1), -- MAINTENANCE: delete Phân quyền
(461, 2, 4, 1, 0), -- LECTURER: view Phân quyền
(462, 2, 4, 2, 1), -- LECTURER: add Phân quyền
(463, 2, 4, 3, 0), -- LECTURER: edit Phân quyền
(464, 2, 4, 4, 0), -- LECTURER: delete Phân quyền
(465, 1, 4, 1, 0), -- ADMIN: view Phân quyền
(466, 1, 4, 2, 0), -- ADMIN: add Phân quyền
(467, 1, 4, 3, 0), -- ADMIN: edit Phân quyền
(468, 1, 4, 4, 0); -- ADMIN: delete Phân quyền

