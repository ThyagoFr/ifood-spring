CREATE TABLE deliveries
(
    id                    bigint         not null auto_increment,
    client_id             bigint         not null,
    fee                   decimal(10, 2) not null,
    status                varchar(20)    not null,
    date_order            datetime       not null,
    date_completion       datetime       not null,

    receiver_name         varchar(255)   not null,
    receiver_public_place varchar(255)   not null,
    receiver_complement   varchar(255)   not null,
    receiver_neighborhood varchar(255)   not null,
    receiver_number       varchar(255)   not null,

    primary key(id)
);

ALTER TABLE deliveries ADD CONSTRAINT fk_delivery_client
FOREIGN KEY (client_id) REFERENCES clients(id);
