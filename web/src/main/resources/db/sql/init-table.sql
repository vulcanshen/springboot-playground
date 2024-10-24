create table if not exists web_token (
    id varchar not null,
    create_time bigint,
    expire_time bigint,
    token varchar unique not null,
    user_id varchar,
    primary key (id)
);