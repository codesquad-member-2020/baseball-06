INSERT INTO team (name)
VALUES ('백엔드');
INSERT INTO team (name)
VALUES ('후론트');
INSERT INTO team (name)
VALUES ('iOS');
INSERT INTO team (name)
VALUES ('마스터');

INSERT INTO player (team_id, type, name)
VALUES (1, 0, '투수 Dan');
INSERT INTO player (team_id, type, name, batting_average)
VALUES (1, 1, '타자1 Dion', 0.393);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (1, 1, '타자2 David', 0.365);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (1, 1, '타자3 XP', 0.337);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (1, 1, '타자4 Solar', 0.389);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (1, 1, '타자5 해피밀', 0.328);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (1, 1, '타자6 Sunny', 0.328);

INSERT INTO player (team_id, type, name)
VALUES (2, 0, '투수 won');
INSERT INTO player (team_id, type, name, batting_average)
VALUES (2, 1, '타자1 Ellin', 0.384);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (2, 1, '타자2 hoo', 0.397);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (2, 1, '타자3 baekCo', 0.378);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (2, 1, '타자4 Taek', 0.356);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (2, 1, '타자5 hoi', 0.345);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (2, 1, '타자6 Huey', 0.345);

INSERT INTO player (team_id, type, name)
VALUES (3, 0, '투수 delma');
INSERT INTO player (team_id, type, name, batting_average)
VALUES (3, 1, '타자1 또치', 0.393);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (3, 1, '타자2 Olaf', 0.316);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (3, 1, '타자3 하이디', 0.377);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (3, 1, '타자4 Cory', 0.398);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (3, 1, '타자5 GangWoon', 0.323);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (3, 1, '타자6 jinie', 0.323);

INSERT INTO player (team_id, type, name)
VALUES (4, 0, '투수 JK');
INSERT INTO player (team_id, type, name, batting_average)
VALUES (4, 1, '타자1 Honux', 0.499);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (4, 1, '타자2 Crong', 0.373);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (4, 1, '타자3 Yagom', 0.393);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (4, 1, '타자4 Head', 0.353);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (4, 1, '타자5 Sarah', 0.383);
INSERT INTO player (team_id, type, name, batting_average)
VALUES (4, 1, '타자6 javajigi', 0.373);

INSERT INTO game (away_id, home_id, away_user, home_user)
VALUES (1, 2, 'dan@gmail.com', 'sigrid@naver.com');

INSERT INTO game (away_id, home_id)
VALUES (1, 3);

INSERT INTO game (away_id, home_id)
VALUES (1, 4);

INSERT INTO game (away_id, home_id)
VALUES (2, 3);

INSERT INTO game (away_id, home_id)
VALUES (2, 4);

INSERT INTO game (away_id, home_id)
VALUES (3, 4);


