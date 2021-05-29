CREATE TABLE occurrences (
    id bigint not null auto_increment,
    delivery_id bigint not null,
    description text not null,
    date_register datetime not null,

    primary key(id)
);

ALTER TABLE occurrences ADD CONSTRAINT fk_occurrence_delivery
FOREIGN KEY (delivery_id) REFERENCES deliveries(id);