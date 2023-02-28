create table equation
(
    id            bigserial     primary key,
    a             decimal       not null,
    b             decimal       not null,
    c             decimal       not null,
    x1            decimal       not null,
    x2            decimal       not null,
    created_at    timestamp default current_timestamp,
    updated_at    timestamp default current_timestamp
);