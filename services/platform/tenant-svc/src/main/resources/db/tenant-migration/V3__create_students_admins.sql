-- Admins (관리자) table
CREATE TABLE admins (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    academy_id BIGINT REFERENCES academies(id) ON DELETE SET NULL,
    admin_type VARCHAR(20) NOT NULL,
    permissions JSONB,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    UNIQUE(user_id)
);

-- Students (수강생) table
CREATE TABLE students (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    academy_id BIGINT NOT NULL REFERENCES academies(id) ON DELETE CASCADE,
    student_number VARCHAR(50),
    grade VARCHAR(20),
    school_name VARCHAR(100),
    parent_name VARCHAR(100),
    parent_phone VARCHAR(20),
    enrollment_date DATE,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    UNIQUE(user_id)
);

CREATE INDEX idx_admins_academy_id ON admins(academy_id);
CREATE INDEX idx_students_academy_id ON students(academy_id);
CREATE INDEX idx_students_status ON students(status);

COMMENT ON TABLE admins IS 'Admin users with management permissions';
COMMENT ON TABLE students IS 'Enrolled students';
