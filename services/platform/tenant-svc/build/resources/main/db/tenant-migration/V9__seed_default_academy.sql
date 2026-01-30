-- Seed default academy for new tenant
INSERT INTO academies (name, description, is_default, status)
VALUES ('기본 학원', '테넌트 생성 시 자동으로 생성된 기본 학원입니다.', TRUE, 'ACTIVE');
