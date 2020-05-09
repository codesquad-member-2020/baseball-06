INSERT INTO team (name)
VALUES ('SK w away');

INSERT INTO team (name)
VALUES ('DOOSAN d home');


INSERT INTO player (team_id, type, name)
VALUES (1, 0, '투수어웨이');

INSERT INTO player (team_id, type, name)
VALUES (2, 0, '투수홈');


INSERT INTO player (team_id, type, name, batting_average)
VALUES (1, 1, '타자어웨이1', 0.333);

INSERT INTO player (team_id, type, name, batting_average)
VALUES (1, 1, '타자어웨이2', 0.333);

INSERT INTO player (team_id, type, name, batting_average)
VALUES (1, 1, '타자어웨이3', 0.333);

INSERT INTO player (team_id, type, name, batting_average)
VALUES (1, 1, '타자어웨이4', 0.333);

INSERT INTO player (team_id, type, name, batting_average)
VALUES (1, 1, '타자어웨이5', 0.333);

INSERT INTO player (team_id, type, name, batting_average)
VALUES (2, 1, '타자홈1', 0.333);

INSERT INTO player (team_id, type, name, batting_average)
VALUES (2, 1, '타자홈2', 0.333);

INSERT INTO player (team_id, type, name, batting_average)
VALUES (2, 1, '타자홈3', 0.333);

INSERT INTO player (team_id, type, name, batting_average)
VALUES (2, 1, '타자홈4', 0.333);

INSERT INTO player (team_id, type, name, batting_average)
VALUES (2, 1, '타자홈5', 0.333);


INSERT INTO game (away, home, away_user, home_user, end)
VALUES (1, 2, 'dan@gmail.com', 'sigrid@naver.com', 0);

