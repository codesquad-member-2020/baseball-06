DROP TABLE IF EXISTS game;
CREATE TABLE IF NOT EXISTS game
(
    id         INT         NOT NULL AUTO_INCREMENT,
    home       INT         NOT NULL,
    away       INT         NOT NULL,
    home_user  VARCHAR(45) NULL,
    away_user  VARCHAR(45) NULL,
    end        TINYINT     NOT NULL,
    created_at DATETIME    NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS inning;
CREATE TABLE IF NOT EXISTS inning
(
    id         INT      NOT NULL AUTO_INCREMENT,
    game_id    INT      NOT NULL,
    type       INT      NOT NULL,
    score      INT      NOT NULL,
    end        TINYINT  NOT NULL,
    created_at DATETIME NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS detail_plate_appearance;
CREATE TABLE IF NOT EXISTS detail_plate_appearance
(
    id         INT      NOT NULL AUTO_INCREMENT,
    result     INT      NOT NULL,
    created_at DATETIME NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS plate_appearance;
CREATE TABLE IF NOT EXISTS plate_appearance
(
    id                         INT      NOT NULL AUTO_INCREMENT,
    inning_id                  INT      NOT NULL,
    pitcher                    INT      NOT NULL,
    batter                     INT      NOT NULL,
    batter_index               INT      NOT NULL,
    result                     INT      NULL,
    created_at                 DATETIME NOT NULL,
    end                        TINYINT  NOT NULL,
    detail_plate_appearance_id INT      NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS team;
CREATE TABLE IF NOT EXISTS team
(
    id   INT         NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS player;
CREATE TABLE IF NOT EXISTS player
(
    id              INT         NOT NULL AUTO_INCREMENT,
    team_id         INT         NOT NULL,
    type            INT         NOT NULL,
    name            VARCHAR(45) NOT NULL,
    batting_average DECIMAL     NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS base_status;
CREATE TABLE IF NOT EXISTS base_status
(
    id          INT NOT NULL AUTO_INCREMENT,
    first_base  INT NULL,
    second_base INT NULL,
    third_base  INT NULL,
    inning_id   INT NOT NULL,
    PRIMARY KEY (inning_id)
);

DROP TABLE IF EXISTS inning_status;
CREATE TABLE IF NOT EXISTS inning_status
(
    id           INT NOT NULL AUTO_INCREMENT,
    strike_count INT NOT NULL,
    ball_count   INT NOT NULL,
    out_count    INT NOT NULL,
    inning_id    INT NOT NULL,
    PRIMARY KEY (inning_id)
);
