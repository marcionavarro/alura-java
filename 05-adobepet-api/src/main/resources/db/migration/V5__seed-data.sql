-- Seed data: abrigos, tutores, pets, adocoes
-- IDs are set explicitly to keep references stable in tests/dev

INSERT INTO abrigos (id, nome, telefone, email) VALUES
  (1, 'Abrigo Central', '(11)99999-0001', 'central@abrigo.org'),
  (2, 'Abrigo Norte', '(11)99999-0002', 'norte@abrigo.org');

INSERT INTO tutores (id, nome, telefone, email) VALUES
  (1, 'João Silva', '(11)98888-0001', 'joao.silva@example.com'),
  (2, 'Maria Oliveira', '(11)98888-0002', 'maria.oliveira@example.com'),
  (3, 'Carlos Pereira', '(11)98888-0003', 'carlos.pereira@example.com');

INSERT INTO pets (id, tipo, nome, raca, idade, cor, peso, abrigo_id, adotado) VALUES
  (1, 'Cachorro', 'Rex', 'Vira-lata', 3, 'Marrom', 12.50, 1, true),
  (2, 'Gato', 'Luna', 'Siamês', 2, 'Branco', 4.20, 1, false),
  (3, 'Cachorro', 'Thor', 'Pastor Alemão', 5, 'Preto', 30.00, 2, false),
  (4, 'Gato', 'Mimi', 'SRD', 1, 'Cinza', 3.10, 2, true),
  (5, 'Cachorro', 'Bela', 'Poodle', 4, 'Branco', 8.30, 1, false);

INSERT INTO adocoes (id, data, tutor_id, pet_id, motivo, status, justificativa_status) VALUES
  (1, '2026-07-01 10:00:00', 1, 1, 'Tenho espaço e tempo para cuidar.', 'APROVADA', 'Documentos verificados e entrevista OK'),
  (2, '2026-07-02 12:00:00', 2, 2, 'Adoramos gatos e temos experiência.', 'AGUARDANDO_AVALIACAO', NULL),
  (3, '2026-07-03 15:30:00', 3, 3, 'Tenho referências, mas sem intenção de adotar ainda.', 'REPROVADA', 'Não passou na entrevista'),
  (4, '2026-07-04 09:20:00', 1, 4, 'Quero um companheiro para casa.', 'APROVADA', 'Aprovado pela equipe');

-- Nota: os campos adoptado nos pets foram ajustados acima (true para pets 1 e 4)

