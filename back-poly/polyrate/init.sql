CREATE TABLE moeda (
    id_moeda SERIAL PRIMARY KEY,
    codigo VARCHAR(3)  NOT NULL UNIQUE,  -- BRL, USD
    nome VARCHAR(50) NOT NULL,
    created_at TIMESTAMP   NOT NULL DEFAULT now()
);


CREATE TABLE taxa_cambio (
    id_taxa_cambio SERIAL PRIMARY KEY,
    moeda_origem_id INTEGER NOT NULL REFERENCES moeda(id_moeda) ON DELETE RESTRICT,
    moeda_destino_id INTEGER NOT NULL REFERENCES moeda(id_moeda) ON DELETE RESTRICT,
    taxa NUMERIC(18,8) NOT NULL CHECK (taxa > 0),
    data_referencia DATE NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    CONSTRAINT uq_taxa_par_data UNIQUE (moeda_origem_id, moeda_destino_id, data_referencia),
    CONSTRAINT ck_moedas_diferentes CHECK (moeda_origem_id <> moeda_destino_id)
);

CREATE TABLE cedente (
    id_cedente SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    documento VARCHAR(20)  NOT NULL UNIQUE,  -- CNPJ
    created_at TIMESTAMP    NOT NULL DEFAULT now()
);


CREATE TABLE tipo_recebivel (
    id_tipo_recebivel SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    codigo_estrategia VARCHAR(50)  NOT NULL UNIQUE,  -- ex: DUPLICATA_MERCANTIL, CHEQUE_PRE_DATADO
    spread_percentual NUMERIC(7,4) NOT NULL CHECK (spread_percentual >= 0),
    created_at TIMESTAMP    NOT NULL DEFAULT now()
);

CREATE TABLE recebivel (
    id_recebivel SERIAL PRIMARY KEY,
    cedente_id INTEGER NOT NULL REFERENCES cedente(id_cedente) ON DELETE RESTRICT,
    tipo_recebivel_id INTEGER NOT NULL REFERENCES tipo_recebivel(id_tipo_recebivel) ON DELETE RESTRICT,
    valor_face NUMERIC(18,2) NOT NULL CHECK (valor_face > 0),
    moeda_titulo_id INTEGER NOT NULL REFERENCES moeda(id_moeda) ON DELETE RESTRICT,
    data_vencimento DATE NOT NULL,
    data_operacao DATE NOT NULL DEFAULT CURRENT_DATE,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDENTE',  -- PENDENTE | LIQUIDADO | CANCELADO
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    updated_at TIMESTAMP,
    CONSTRAINT ck_status_recebivel CHECK (status IN ('PENDENTE','LIQUIDADO','CANCELADO')),
    CONSTRAINT ck_vencimento_futuro CHECK (data_vencimento >= data_operacao)
);


CREATE TABLE transacao (
    id_transacao SERIAL PRIMARY KEY,
    recebivel_id INTEGER NOT NULL REFERENCES recebivel(id_recebivel) ON DELETE RESTRICT,
    taxa_base_aplicada NUMERIC(9,6)  NOT NULL,
    spread_aplicado NUMERIC(9,6)  NOT NULL,
    taxa_cambio_aplicada NUMERIC(18,8),                 -- NULL se não houver conversão (mesma moeda)
    moeda_pagamento_id INTEGER NOT NULL REFERENCES moeda(id_moeda) ON DELETE RESTRICT,
    valor_presente_calculado NUMERIC(18,2) NOT NULL,
    valor_liquido_final NUMERIC(18,2) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'LIQUIDADO',
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    CONSTRAINT ck_status_transacao CHECK (status IN ('LIQUIDADO','ESTORNADO'))
);

CREATE INDEX idx_transacao_created_at ON transacao(created_at);
CREATE INDEX idx_transacao_moeda_pagamento ON transacao(moeda_pagamento_id);
CREATE INDEX idx_recebivel_cedente ON recebivel(cedente_id);