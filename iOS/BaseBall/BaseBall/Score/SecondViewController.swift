//
//  SecondViewController.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/04.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

class SecondViewController: UIViewController, UITableViewDelegate {
    @IBOutlet weak var scoreTableView: UITableView!
    
    private let scoreDataSource = ScoreDataSource()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        scoreTableView.dataSource = scoreDataSource
        scoreTableView.delegate = self
    }
    
    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: ScoreCell.identifier) as? ScoreCell else { return nil }
        cell.backgroundColor = .opaqueSeparator
        return cell
    }
}
