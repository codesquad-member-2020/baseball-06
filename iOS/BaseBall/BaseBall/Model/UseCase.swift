//
//  UseCase.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/08.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import Foundation

struct PitchUseCase {
    static func pitch(with manager: NetworkManageable, completion: @escaping (Result<PitchResult, NetworkError>) -> ()) {
        manager.getResource(from: NetworkManager.EndPoints.Pitch, handler: { result in
            switch result {
            case .success(let data):
                guard let response = try? JSONDecoder().decode(PitchResponse.self, from: data) else {
                    completion(.failure(.DecodingError))
                    return
                }
                completion(.success(response.body))
            case .failure(let error):
                completion(.failure(error))
            }
        })
    }
}

struct GameInfoUseCase {
    static func gameInfo(with manager: NetworkManageable, completion: @escaping (Result<GameInfo, NetworkError>) -> ()) {
        manager.getResource(from: NetworkManager.EndPoints.GameInfo, handler: { result in
            switch result {
            case .success(let data):
                guard let response = try? JSONDecoder().decode(GameInfoResponse.self, from: data) else {
                    completion(.failure(.DecodingError))
                    return
                }
                completion(.success(response.body))
            case .failure(let error):
                completion(.failure(error))
            }
        })
    }
}

