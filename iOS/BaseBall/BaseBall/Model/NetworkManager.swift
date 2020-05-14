//
//  NetworkManager.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/08.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import Foundation

protocol NetworkManageable {
    func getResource(from: String, handler: @escaping ((Result<Data, NetworkError>) -> Void))
}

enum NetworkError: Error {
    case URLError
    case DataNotFound
    case DecodingError
}

struct NetworkManager: NetworkManageable {
    enum EndPoints {
        static let Pitch = "http://15.164.101.161:8080/dev/dotest"
    }
    
    func getResource(from urlString: String, handler: @escaping ((Result<Data, NetworkError>) -> Void)) {
        guard let url = URL(string: urlString) else {
            handler(.failure(.URLError))
            return
        }
        URLSession.shared.dataTask(with: url) { (data, response, error) in
            guard let data = data else {
                handler(.failure(.DataNotFound))
                return
            }
            handler(.success(data))
        }.resume()
    }
}

struct MockNetworkSuccessStub: NetworkManageable {
    func getResource(from: String, handler: @escaping ((Result<Data, NetworkError>) -> Void)) {
        let result = PitchResponse.init(body: PitchResult.init(inningStatus: InningStatus.init(inningNum: 1,
                                                                                               inningType: "초",
                                                                                               strike: 1,
                                                                                               ball: 1,
                                                                                               out: 1),
                                                               updatedBaseman: Base.init(firstBase: BaseInfo.init(name: "a",
                                                                                                                  id: 1),
                                                                                         secondBase: BaseInfo.init(name: nil,
                                                                                                                   id: nil),
                                                                                         thirdBase: BaseInfo.init(name: nil,
                                                                                                                  id: nil)),
                                                               updatedScore: Score.init(home: 1, away: 2),
                                                               updatedPlayer: [Player.init(id: 1,
                                                                                           name: "투수임",
                                                                                           type: "투수",
                                                                                           teamType: "Home",
                                                                                           teamName: "A팀"),
                                                                               Player.init(id: 2,
                                                                                           name: "타자임",
                                                                                           type: "타자",
                                                                                           teamType: "Away",
                                                                                           teamName: "B팀")]))
        let encoder = JSONEncoder()
        guard let data = try? encoder.encode(result) else { return }
        handler(.success(data))
    }
}

struct MockNetworkFailureStub: NetworkManageable {
    func getResource(from: String, handler: @escaping ((Result<Data, NetworkError>) -> Void)) {
        handler(.failure(.DataNotFound))
    }
}

struct MockNetworkInvalidURLStub: NetworkManageable {
    func getResource(from: String, handler: @escaping ((Result<Data, NetworkError>) -> Void)) {
        handler(.failure(.URLError))
    }
}
