-- Q&A Board (질문게시판) table
CREATE TABLE qna_boards (
    id BIGSERIAL PRIMARY KEY,
    academy_id BIGINT REFERENCES academies(id) ON DELETE CASCADE,
    author_id BIGINT NOT NULL REFERENCES users(id) ON DELETE SET NULL,
    title VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    category VARCHAR(50),
    is_answered BOOLEAN NOT NULL DEFAULT FALSE,
    is_private BOOLEAN NOT NULL DEFAULT FALSE,
    view_count INT NOT NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

-- Q&A Files
CREATE TABLE qna_files (
    id BIGSERIAL PRIMARY KEY,
    qna_id BIGINT NOT NULL REFERENCES qna_boards(id) ON DELETE CASCADE,
    file_name VARCHAR(255) NOT NULL,
    file_path VARCHAR(500) NOT NULL,
    file_size BIGINT,
    mime_type VARCHAR(100),
    created_at TIMESTAMP NOT NULL DEFAULT NOW()
);

-- Q&A Comments (답변)
CREATE TABLE qna_comments (
    id BIGSERIAL PRIMARY KEY,
    qna_id BIGINT NOT NULL REFERENCES qna_boards(id) ON DELETE CASCADE,
    author_id BIGINT NOT NULL REFERENCES users(id) ON DELETE SET NULL,
    content TEXT NOT NULL,
    is_answer BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_qna_boards_academy_id ON qna_boards(academy_id);
CREATE INDEX idx_qna_boards_author_id ON qna_boards(author_id);
CREATE INDEX idx_qna_boards_is_answered ON qna_boards(is_answered);
CREATE INDEX idx_qna_files_qna_id ON qna_files(qna_id);
CREATE INDEX idx_qna_comments_qna_id ON qna_comments(qna_id);

COMMENT ON TABLE qna_boards IS 'Question and answer board';
