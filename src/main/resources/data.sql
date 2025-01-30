-- Insert data into the 'match' table
INSERT INTO "match" (match_id, description, date, time, first_team, second_team, sport, date_created, date_updated) VALUES
(gen_random_uuid(), 'Quarter Finals', '2025-01-20', '15:00:00', 'Team A', 'Team B', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(gen_random_uuid(), 'Semi Finals', '2025-01-22', '18:00:00', 'Team C', 'Team D', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Insert data into the 'odd' table
INSERT INTO "odd" (odd_id, specifier, odd, match_id, date_created, date_updated) VALUES
(gen_random_uuid(), 'Win Team A', 2.50, (SELECT id FROM "match" WHERE description = 'Quarter Finals'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(gen_random_uuid(), 'Win Team B', 1.80, (SELECT id FROM "match" WHERE description = 'Quarter Finals'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(gen_random_uuid(), 'Win Team C', 3.00, (SELECT id FROM "match" WHERE description = 'Semi Finals'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(gen_random_uuid(), 'Win Team D', 2.10, (SELECT id FROM "match" WHERE description = 'Semi Finals'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);