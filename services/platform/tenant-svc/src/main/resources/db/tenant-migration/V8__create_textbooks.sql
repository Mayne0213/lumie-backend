-- Textbooks (교재) table
CREATE TABLE textbooks (
    id BIGSERIAL PRIMARY KEY,
    academy_id BIGINT NOT NULL REFERENCES academies(id) ON DELETE CASCADE,
    name VARCHAR(200) NOT NULL,
    description TEXT,
    author VARCHAR(100),
    publisher VARCHAR(100),
    isbn VARCHAR(20),
    subject VARCHAR(100),
    grade_level VARCHAR(50),
    price DECIMAL(10,2),
    cover_image_path VARCHAR(500),
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_textbooks_academy_id ON textbooks(academy_id);
CREATE INDEX idx_textbooks_subject ON textbooks(subject);
CREATE INDEX idx_textbooks_status ON textbooks(status);

COMMENT ON TABLE textbooks IS 'Academy textbooks and learning materials';
