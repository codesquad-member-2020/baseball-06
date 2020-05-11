INSERT INTO team (name)
VALUES ('SK w away');
INSERT INTO team (name)
VALUES ('DOOSAN d home');
INSERT INTO team (name)
VALUES ('NC d away');
INSERT INTO team (name)
VALUES ('SAMSUNG l home');


INSERT INTO player (team_id, type, name)
VALUES (1, 0, '투수SK');
INSERT INTO player (team_id, type, name, batting_average)
VALUES (1, 1, '타자1SK', 0.333);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (1, 1, '타자2SK', 0.333);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (1, 1, '타자3SK', 0.333);

INSERT INTO player (team_id, type, name)
VALUES (2, 0, '투수DOOSAN');
INSERT INTO player (team_id, type, name, batting_average)
VALUES (2, 1, '타자1DOOSAN', 0.333);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (2, 1, '타자2DOOSAN', 0.333);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (2, 1, '타자3DOOSAN', 0.333);

INSERT INTO player (team_id, type, name)
VALUES (3, 0, '투수NC');
INSERT INTO player (team_id, type, name, batting_average)
VALUES (3, 1, '타자1NC', 0.333);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (3, 1, '타자2NC', 0.333);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (3, 1, '타자3NC', 0.333);

INSERT INTO player (team_id, type, name)
VALUES (4, 0, '투수SAMSUNG');
INSERT INTO player (team_id, type, name, batting_average)
VALUES (4, 1, '타자1SAMSUNG', 0.333);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (4, 1, '타자2SAMSUNG', 0.333);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (4, 1, '타자3SAMSUNG', 0.333);


INSERT INTO game (away_id, home_id, away_user, home_user)
VALUES (1, 2, 'dan@gmail.com', 'sigrid@naver.com');

INSERT INTO game (away_id, home_id)
VALUES (2, 3);

