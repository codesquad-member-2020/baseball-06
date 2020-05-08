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
    var inningStatus: String
}
