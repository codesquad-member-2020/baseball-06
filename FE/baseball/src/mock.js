export const mock = {
  playingStatus: "BALL",
  inningStatus: {
    inningNum: 1,
    inningType: "초", //HomeTeam은 무조건 초에 공격, AwayTeam은 말에 공격
    strike: 1,
    ball: 3,
    out: 2,
  },
  updatedBaseman: {
    "1B": {
      name: "Aurora",
      id: 2,
    },
    "2B": {
      name: "Amanda Tenjford",
      id: 3,
    },
    "3B": {
      name: null, //현재 3루에 타자가 진출하지 않았다는 의미
      id: null,
    },

    updatedScore: {
      Home: 2, //homeTeam은 인덱스가 0
      Away: 2, //awayTeam은 인덱스가 1
    },
    updatedPlayer: [
      //왜 updatedBaseman안에 존재하는가? 따로 분리 가능한가?
      //객체로 줄수 있을까?
      {
        id: 0,
        name: "Dan",
        type: "Pitcher",
        teamType: "Home",
        pitches: 39,
      },
      {
        id: 2,
        name: "Sigrid",
        type: "Batter",
        bat: 1,
        hit: 0,
        teamType: "Away",
      },
    ],
  },
};
