SET foreign_key_checks = 0;
DROP TABLE IF EXISTS game;
DROP TABLE IF EXISTS half_inning;
DROP TABLE IF EXISTS plate_appearance;
DROP TABLE IF EXISTS detail_plate_appearance;
DROP TABLE IF EXISTS team;
DROP TABLE IF EXISTS player;
DROP TABLE IF EXISTS base_status;
DROP TABLE IF EXISTS inning_status;
SET foreign_key_checks = 1;

CREATE TABLE game
(
    id         INT         NOT NULL AUTO_INCREMENT,
    away_id    INT         NOT NULL,
    home_id    INT         NOT NULL,
    away_user  VARCHAR(45) NULL     DEFAULT NULL,
    home_user  VARCHAR(45) NULL     DEFAULT NULL,
    end        TINYINT     NOT NULL DEFAULT 0,
    created_at TIMESTAMP            DEFAULT NOW(),
    PRIMARY KEY (id)
);

CREATE TABLE half_inning
(
    id           INT     NOT NULL AUTO_INCREMENT,
    game_id      INT     NOT NULL,
    inning_index INT     NOT NULL,
    type         TINYINT NOT NULL,
    score        INT     NOT NULL DEFAULT 0,
    end          TINYINT NOT NULL DEFAULT 0,
    created_at   TIMESTAMP        DEFAULT NOW(),
    PRIMARY KEY (id)
);

CREATE TABLE plate_appearance
(
    id             INT     NOT NULL AUTO_INCREMENT,
    half_inning_id INT     NOT NULL,
    pitcher        INT     NOT NULL,
    batter         INT     NOT NULL,
    batter_index   INT     NOT NULL DEFAULT 0,
    result         INT     NULL     DEFAULT NULL,
    created_at     TIMESTAMP        DEFAULT NOW(),
    end            TINYINT NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
);

CREATE TABLE detail_plate_appearance
(
    id                  INT NOT NULL AUTO_INCREMENT,
    result              INT NOT NULL,
    created_at          TIMESTAMP DEFAULT NOW(),
    plate_appearance_id INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE team
(
    id   INT         NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE player
(
    id              INT         NOT NULL AUTO_INCREMENT,
    team_id         INT         NOT NULL,
    type            TINYINT     NOT NULL,
    name            VARCHAR(45) NOT NULL,
    batting_average DECIMAL     NULL,
    PRIMARY KEY (id)
);

CREATE TABLE base_status
(
    id             INT NOT NULL AUTO_INCREMENT,
    first_base     INT NULL,
    second_base    INT NULL,
    third_base     INT NULL,
    half_inning_id INT NOT NULL,
    CONSTRAINT half_inning_id_constraint_base_status FOREIGN KEY (half_inning_id) REFERENCES half_inning (id),
    PRIMARY KEY (id)
);

CREATE TABLE inning_status
(
    id             INT NOT NULL AUTO_INCREMENT,
    half_inning_id INT NOT NULL,
    strike_count   INT NOT NULL DEFAULT 0,
    ball_count     INT NOT NULL DEFAULT 0,
    out_count      INT NOT NULL DEFAULT 0,
    CONSTRAINT strike_count_ck CHECK (strike_count IN (0, 1, 2, 3)),
    CONSTRAINT ball_count_ck CHECK (ball_count IN (0, 1, 2, 3)),
    CONSTRAINT out_count_ck CHECK (out_count IN (0, 1, 2, 3)),
    CONSTRAINT half_inning_id_constraint_inning_status FOREIGN KEY (half_inning_id) REFERENCES half_inning (id),
    PRIMARY KEY (id)
);
