CREATE DATABASE community_event_portal;
USE community_event_portal;

-- Table: Users
CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    city VARCHAR(100) NOT NULL,
    registration_date DATE NOT NULL
);

-- Table: Events
CREATE TABLE Events (
    event_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    city VARCHAR(100) NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    status ENUM('upcoming', 'completed', 'cancelled'),
    organizer_id INT,
    FOREIGN KEY (organizer_id) REFERENCES Users(user_id)
);

-- Table: Sessions
CREATE TABLE Sessions (
    session_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    title VARCHAR(200) NOT NULL,
    speaker_name VARCHAR(100) NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- Table: Registrations
CREATE TABLE Registrations (
    registration_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    event_id INT,
    registration_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- Table: Feedback
CREATE TABLE Feedback (
    feedback_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    event_id INT,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comments TEXT,
    feedback_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- Table: Resources
CREATE TABLE Resources (
    resource_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    resource_type ENUM('pdf', 'image', 'link'),
    resource_url VARCHAR(255) NOT NULL,
    uploaded_at DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);
-- USERS
INSERT INTO Users (user_id, full_name, email, city, registration_date) VALUES
(1, 'Alice Johnson', 'alice@example.com', 'New York', '2025-06-20'),
(2, 'Bob Smith', 'bob@example.com', 'Los Angeles', '2025-06-15'),
(3, 'Charlie Lee', 'charlie@example.com', 'Chicago', '2025-06-10'),
(4, 'Diana King', 'diana@example.com', 'New York', '2025-03-20'),
(5, 'Ethan Hunt', 'ethan@example.com', 'Los Angeles', '2025-06-25'),
(6, 'Grace Kim', 'grace@example.com', 'San Francisco', '2025-07-01'),
(7, 'Ivan Drew', 'ivan@example.com', 'New York', '2025-06-30'); -- unregistered user

-- EVENTS
INSERT INTO Events (event_id, title, description, city, start_date, end_date, status, organizer_id) VALUES
(1, 'Tech Innovators Meetup', 'Tech talks and networking.', 'New York', '2025-07-10 10:00:00', '2025-07-10 16:00:00', 'upcoming', 1),
(2, 'AI & ML Conference', 'AI breakthroughs.', 'Chicago', '2025-06-15 09:00:00', '2025-06-15 17:00:00', 'completed', 3),
(3, 'Frontend Bootcamp', 'Frontend dev crash course.', 'Los Angeles', '2025-07-05 10:00:00', '2025-07-07 16:00:00', 'upcoming', 2),
(4, 'HealthTech Expo', 'Healthcare meets tech.', 'Chicago', '2025-07-15 09:00:00', '2025-07-16 16:00:00', 'upcoming', 4);

-- SESSIONS
INSERT INTO Sessions (session_id, event_id, title, speaker_name, start_time, end_time) VALUES
(1, 1, 'Opening Keynote', 'Alice Johnson', '2025-07-10 10:00:00', '2025-07-10 11:00:00'),
(2, 1, 'Future of Web', 'Bob Smith', '2025-07-10 11:15:00', '2025-07-10 12:15:00'),
(3, 2, 'AI in Medicine', 'Charlie Lee', '2025-06-15 09:30:00', '2025-06-15 11:00:00'),
(4, 3, 'HTML & CSS', 'Bob Smith', '2025-07-05 10:00:00', '2025-07-05 12:00:00'),
(5, 3, 'JavaScript Basics', 'Alice Johnson', '2025-07-05 11:30:00', '2025-07-05 13:00:00'),
(6, 4, 'Telemedicine Panel', 'Grace Kim', '2025-07-15 10:00:00', '2025-07-15 12:00:00');

-- REGISTRATIONS
INSERT INTO Registrations (registration_id, user_id, event_id, registration_date) VALUES
(1, 1, 1, '2025-07-01'),
(2, 2, 1, '2025-07-02'),
(3, 3, 2, '2025-06-01'),
(4, 4, 2, '2025-03-28'),
(5, 5, 3, '2025-06-28'),
(6, 1, 4, '2025-07-03'),
(7, 2, 4, '2025-07-03');

-- FEEDBACK
INSERT INTO Feedback (feedback_id, user_id, event_id, rating, comments, feedback_date) VALUES
(1, 1, 1, 2, 'Needs better structure.', '2025-07-02'),
(2, 2, 1, 5, 'Fantastic!', '2025-07-03'),
(3, 3, 2, 4, 'Insightful.', '2025-06-16'),
(4, 4, 2, 5, 'Loved it.', '2025-06-17'),
(5, 1, 2, 5, 'Engaging.', '2025-06-18'),
(6, 2, 2, 5, 'Excellent.', '2025-06-19'),
(7, 3, 2, 5, 'Top notch.', '2025-06-20'),
(8, 4, 2, 5, 'Brilliant.', '2025-06-21'),
(9, 5, 2, 5, 'Very clear.', '2025-06-22'),
(10, 1, 2, 5, 'Super helpful.', '2025-06-23'),
(11, 2, 2, 5, 'Amazing insights.', '2025-06-24');

-- RESOURCES
INSERT INTO Resources (resource_id, event_id, resource_type, resource_url, uploaded_at) VALUES
(1, 1, 'pdf', 'https://portal.com/tech-agenda.pdf', '2025-07-01 10:00:00'),
(2, 2, 'image', 'https://portal.com/ai-image.jpg', '2025-06-10 09:00:00'),
(3, 3, 'link', 'https://portal.com/frontend-links', '2025-07-03 15:00:00');
