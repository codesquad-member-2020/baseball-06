INSERT INTO team (name)
VALUES ('BE HONUX');
INSERT INTO team (name)
VALUES ('DOOSAN d home');
INSERT INTO team (name)
VALUES ('FE CRONG');
INSERT INTO team (name)
VALUES ('SAMSUNG l home');
INSERT INTO team (name)
VALUES ('SKT away');
INSERT INTO team (name)
VALUES ('GIANT home');


INSERT INTO player (team_id, type, name)
VALUES (1, 0, '투수HONUX');
INSERT INTO player (team_id, type, name, batting_average)
VALUES (1, 1, '타자1DION', 0.333);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (1, 1, '타자2JINIE', 0.333);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (1, 1, '타자3CORY', 0.333);

INSERT INTO player (team_id, type, name)
VALUES (2, 0, '투수JK');
INSERT INTO player (team_id, type, name, batting_average)
VALUES (2, 1, '타자1DAVID', 0.333);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (2, 1, '타자2DELMA', 0.333);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (2, 1, '타자3XP', 0.333);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (2, 1, '타자4ALEX', 0.333);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (2, 1, '타자5HAMIL', 0.333);

INSERT INTO player (team_id, type, name)
VALUES (3, 0, '투수CRONG');
INSERT INTO player (team_id, type, name, batting_average)
VALUES (3, 1, '타자1SIGRID', 0.333);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (3, 1, '타자2WON', 0.333);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (3, 1, '타자3SALLY', 0.333);

INSERT INTO player (team_id, type, name)
VALUES (4, 0, '투수HENRY');
INSERT INTO player (team_id, type, name, batting_average)
VALUES (4, 1, '타자1DAN', 0.333);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (4, 1, '타자2OLAF', 0.333);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (4, 1, '타자3SOLAR', 0.333);

INSERT INTO player (team_id, type, name)
VALUES (5, 0, '투수SARAH');
INSERT INTO player (team_id, type, name, batting_average)
VALUES (5, 1, '타자1HOI', 0.333);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (5, 1, '타자2DOOCHI', 0.333);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (5, 1, '타자3ELLIE', 0.333);

INSERT INTO player (team_id, type, name)
VALUES (6, 0, '투수GIANT');
INSERT INTO player (team_id, type, name, batting_average)
VALUES (6, 1, '타자1HAN', 0.333);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (6, 1, '타자2POOGLE', 0.333);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (6, 1, '타자3DINGO', 0.333);

INSERT INTO game (away_id, home_id, away_user, home_user)
VALUES (1, 2, 'dan@gmail.com', 'sigrid@naver.com');

INSERT INTO game (away_id, home_id)
VALUES (3, 4);

INSERT INTO game (away_id, home_id)
VALUES (5, 6);


