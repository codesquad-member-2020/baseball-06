//
//  FirstViewController.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/04.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

class PlayViewController: UIViewController, UITableViewDataSource {
    @IBOutlet weak var playerInfoTableView: PlayerInfoTableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        playerInfoTableView.dataSource = self
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 2
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: PlayerInfoCell.identifier, for: indexPath) as? PlayerInfoCell else {
            return UITableViewCell()
        }
        return cell
    }
}

class PlayerInfoTableView: UITableView {
    private let borderWidth: CGFloat = 2
    
    override init(frame: CGRect, style: UITableView.Style) {
        super.init(frame: frame, style: style)
        setProperties()
        setBottomBorder()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setProperties()
        setBottomBorder()
    }
    
    private func setProperties() {
        isScrollEnabled = false
        allowsSelection = false
    }
    
    private func setBottomBorder() {
        let border = CALayer()
        border.backgroundColor = UIColor.darkGray.cgColor
        border.frame = CGRect.init(x: frame.minX, y: frame.height - borderWidth, width: frame.width, height: borderWidth)
        layer.addSublayer(border)
    }
}
