create table t_seg_pagamento
(
    id             NUMBER GENERATED BY DEFAULT AS IDENTITY,
    id_contratacao NUMBER NOT NULL,
    valor          NUMBER(8, 2) NOT NULL,
    dt_pagamento   DATE   NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_contratacao) REFERENCES t_seg_contratacao (id)
);