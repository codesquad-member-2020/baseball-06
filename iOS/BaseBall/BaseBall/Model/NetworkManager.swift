//
//  NetworkManager.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/08.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import Foundation

enum NetworkError: Error {
    case URLError
    case DataNotFound
    case DecodingError
}

struct NetworkManager {
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
