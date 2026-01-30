-- Exams (시험) table
CREATE TABLE exams (
    id BIGSERIAL PRIMARY KEY,
    academy_id BIGINT NOT NULL REFERENCES academies(id) ON DELETE CASCADE,
    name VARCHAR(200) NOT NULL,
    description TEXT,
    exam_type VARCHAR(50) NOT NULL,
    subject VARCHAR(100),
    total_score DECIMAL(10,2),
    passing_score DECIMAL(10,2),
    exam_date DATE,
    duration_minutes INT,
    status VARCHAR(20) NOT NULL DEFAULT 'DRAFT',
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

-- Exam Results (시험 결과)
CREATE TABLE exam_results (
    id BIGSERIAL PRIMARY KEY,
    exam_id BIGINT NOT NULL REFERENCES exams(id) ON DELETE CASCADE,
    student_id BIGINT NOT NULL REFERENCES students(id) ON DELETE CASCADE,
    score DECIMAL(10,2),
    grade VARCHAR(10),
    rank INT,
    percentile DECIMAL(5,2),
    feedback TEXT,
    graded_at TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    UNIQUE(exam_id, student_id)
);

-- Exam Question Results (문항별 결과)
CREATE TABLE exam_question_results (
    id BIGSERIAL PRIMARY KEY,
    exam_result_id BIGINT NOT NULL REFERENCES exam_results(id) ON DELETE CASCADE,
    question_number INT NOT NULL,
    question_text TEXT,
    correct_answer TEXT,
    student_answer TEXT,
    is_correct BOOLEAN,
    score DECIMAL(10,2),
    max_score DECIMAL(10,2),
    created_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_exams_academy_id ON exams(academy_id);
CREATE INDEX idx_exams_status ON exams(status);
CREATE INDEX idx_exam_results_exam_id ON exam_results(exam_id);
CREATE INDEX idx_exam_results_student_id ON exam_results(student_id);
CREATE INDEX idx_exam_question_results_exam_result_id ON exam_question_results(exam_result_id);

COMMENT ON TABLE exams IS 'Exam definitions';
COMMENT ON TABLE exam_results IS 'Student exam results';
COMMENT ON TABLE exam_question_results IS 'Per-question results';
