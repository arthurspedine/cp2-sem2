create table t_seg_seguro
(
    id    NUMBER GENERATED BY DEFAULT AS IDENTITY,
    valor NUMBER(8,2) not null,
    tipo  varchar2(50) unique not null,
    primary key (id)

);