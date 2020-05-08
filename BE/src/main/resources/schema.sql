DROP TABLE IF EXISTS game;
DROP TABLE IF EXISTS half_inning;
DROP TABLE IF EXISTS plate_appearance;
DROP TABLE IF EXISTS detail_plate_appearance;
DROP TABLE IF EXISTS team;
DROP TABLE IF EXISTS player;
DROP TABLE IF EXISTS base_status;
DROP TABLE IF EXISTS inning_status;

CREATE TABLE game
(
    id         INT         NOT NULL AUTO_INCREMENT,
    home       INT         NOT NULL,
    away       INT         NOT NULL,
    home_user  VARCHAR(45) NULL,
    away_user  VARCHAR(45) NULL,
    end        TINYINT     NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    PRIMARY KEY (id)
);

CREATE TABLE half_inning
(
    id           INT      NOT NULL AUTO_INCREMENT,
    game_id      INT      NOT NULL,
    inning_index INT      NOT NULL,
    type         TINYINT  NOT NULL,
    score        INT      NOT NULL,
    end          TINYINT  NOT NULL,
    created_at   TIMESTAMP DEFAULT NOW(),
    PRIMARY KEY (id)
);

CREATE TABLE plate_appearance
(
    id           INT     NOT NULL AUTO_INCREMENT,
    inning_id    INT     NOT NULL,
    pitcher      INT     NOT NULL,
    batter       INT     NOT NULL,
    batter_index INT     NOT NULL,
    result       INT     NULL,
    created_at   TIMESTAMP DEFAULT NOW(),
    end          TINYINT NOT NULL,
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
    id          INT NOT NULL AUTO_INCREMENT,
    first_base  INT NULL,
    second_base INT NULL,
    third_base  INT NULL,
    inning_id   INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE inning_status
(
    id           INT NOT NULL AUTO_INCREMENT,
    strike_count INT NOT NULL,
    ball_count   INT NOT NULL,
    out_count    INT NOT NULL,
    inning_id    INT NOT NULL,
    PRIMARY KEY (id)
);
