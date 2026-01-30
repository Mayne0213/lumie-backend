-- Academies (학원) table
CREATE TABLE academies (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    address VARCHAR(500),
    phone VARCHAR(20),
    email VARCHAR(255),
    business_number VARCHAR(20),
    is_default BOOLEAN NOT NULL DEFAULT FALSE,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

-- Academy files (logos, documents)
CREATE TABLE academy_files (
    id BIGSERIAL PRIMARY KEY,
    academy_id BIGINT NOT NULL REFERENCES academies(id) ON DELETE CASCADE,
    file_type VARCHAR(50) NOT NULL,
    file_name VARCHAR(255) NOT NULL,
    file_path VARCHAR(500) NOT NULL,
    file_size BIGINT,
    mime_type VARCHAR(100),
    created_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_academy_files_academy_id ON academy_files(academy_id);

COMMENT ON TABLE academies IS 'Academy (학원) information';
COMMENT ON TABLE academy_files IS 'Files associated with academies';
