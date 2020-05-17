//
//  PitchResponse.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/08.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import Foundation

struct PitchResponse: Codable {
    var body: PitchResult
}

struct PitchResult: Codable {
    var battingResult: String
}

struct GameInfoResponse: Codable {
    var body: GameInfo
}

struct GameInfo: Codable, Equatable {
    var earlyInningList: [InningInfo]
    var lateInningList: [InningInfo]
    var inningStatus: InningStatus
    var baseStatus: BaseStatus
}

struct InningInfo: Codable, Equatable {
    var index: Int
    var type: String
    var score: Int
    var end: Bool
}

struct InningStatus: Codable, Equatable {
    var strike: Int
    var ball: Int
    var out: Int
}

struct Player: Codable, Equatable {
    var id: Int
    var name: String
    var type: String
    var teamType: String
    var teamName: String
}

struct BaseStatus: Codable, Equatable {
    var firstBase: Bool
    var secondBase: Bool
    var thirdBase: Bool
}
