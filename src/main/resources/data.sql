-- data.sql file is used to seed database
INSERT INTO accommodation (id, name) VALUES (69, 'Negotino');

INSERT INTO airbnb_users (id, name, accommodation_id) VALUES (1, 'Dimi', 69);

create materialized view USER_PER_ACCOMMODATION as(
    select u.id, accommodation_id
    from accommodation a join airbnb_users u on u.accommodation_id = a.id
)
