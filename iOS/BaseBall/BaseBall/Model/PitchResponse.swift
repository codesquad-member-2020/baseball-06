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
    var inningStatus: InningStatus
    var updatedBaseman: Base
    var updatedScore: Score
    var updatedPlayer: [Player]
}

struct InningStatus: Codable {
    var inningNum: Int
    var inningType: String
    var strike: Int
    var ball: Int
    var out: Int
}

struct Base: Codable {
    var firstBase: BaseInfo
    var secondBase: BaseInfo
    var thirdBase: BaseInfo
    
    enum CodingKeys: String, CodingKey {
        case firstBase = "1B"
        case secondBase = "2B"
        case thirdBase = "3B"
    }
}

struct BaseInfo: Codable {
    var name: String?
    var id: Int?
}

struct Score: Codable {
    var home: Int
    var away: Int
}

struct Player: Codable {
    var id: Int
    var name: String
    var type: String
    var teamType: String
    var teamName: String
}
