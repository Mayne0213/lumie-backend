-- Counseling Schedules (상담 일정) table
CREATE TABLE counseling_schedules (
    id BIGSERIAL PRIMARY KEY,
    academy_id BIGINT NOT NULL REFERENCES academies(id) ON DELETE CASCADE,
    counselor_id BIGINT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    schedule_date DATE NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    slot_duration_minutes INT NOT NULL DEFAULT 30,
    max_reservations INT NOT NULL DEFAULT 1,
    is_available BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

-- Counseling Reservations (상담 예약)
CREATE TABLE counseling_reservations (
    id BIGSERIAL PRIMARY KEY,
    schedule_id BIGINT NOT NULL REFERENCES counseling_schedules(id) ON DELETE CASCADE,
    student_id BIGINT NOT NULL REFERENCES students(id) ON DELETE CASCADE,
    reservation_time TIME NOT NULL,
    topic VARCHAR(200),
    notes TEXT,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_counseling_schedules_academy_id ON counseling_schedules(academy_id);
CREATE INDEX idx_counseling_schedules_counselor_id ON counseling_schedules(counselor_id);
CREATE INDEX idx_counseling_schedules_date ON counseling_schedules(schedule_date);
CREATE INDEX idx_counseling_reservations_schedule_id ON counseling_reservations(schedule_id);
CREATE INDEX idx_counseling_reservations_student_id ON counseling_reservations(student_id);

COMMENT ON TABLE counseling_schedules IS 'Counseling schedule slots';
COMMENT ON TABLE counseling_reservations IS 'Student counseling reservations';
