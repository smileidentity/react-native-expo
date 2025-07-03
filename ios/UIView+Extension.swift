import UIKit

extension UIView {

    /// Fills the entire superview with equal top, leading, trailing, and bottom constraints
    func fillSuperview() {
        guard let superview = superview else {
            assertionFailure("View must have a superview before calling fillSuperview()")
            return
        }

        translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            topAnchor.constraint(equalTo: superview.topAnchor),
            leadingAnchor.constraint(equalTo: superview.leadingAnchor),
            trailingAnchor.constraint(equalTo: superview.trailingAnchor),
            bottomAnchor.constraint(equalTo: superview.bottomAnchor),
        ])
    }

    /// Fills the superview with specified padding on all sides
    func fillSuperview(padding: UIEdgeInsets) {
        guard let superview = superview else {
            assertionFailure("View must have a superview before calling fillSuperview(padding:)")
            return
        }

        translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            topAnchor.constraint(equalTo: superview.topAnchor, constant: padding.top),
            leadingAnchor.constraint(equalTo: superview.leadingAnchor, constant: padding.left),
            trailingAnchor.constraint(equalTo: superview.trailingAnchor, constant: -padding.right),
            bottomAnchor.constraint(equalTo: superview.bottomAnchor, constant: -padding.bottom),
        ])
    }

    /// Fills the safe area of the superview
    func fillSafeArea() {
        guard let superview = superview else {
            assertionFailure("View must have a superview before calling fillSafeArea()")
            return
        }

        translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            topAnchor.constraint(equalTo: superview.safeAreaLayoutGuide.topAnchor),
            leadingAnchor.constraint(equalTo: superview.safeAreaLayoutGuide.leadingAnchor),
            trailingAnchor.constraint(equalTo: superview.safeAreaLayoutGuide.trailingAnchor),
            bottomAnchor.constraint(equalTo: superview.safeAreaLayoutGuide.bottomAnchor),
        ])
    }

    /// Centers the view in its superview
    func centerInSuperview() {
        guard let superview = superview else {
            assertionFailure("View must have a superview before calling centerInSuperview()")
            return
        }

        translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            centerXAnchor.constraint(equalTo: superview.centerXAnchor),
            centerYAnchor.constraint(equalTo: superview.centerYAnchor),
        ])
    }

    /// Sets the view's size constraints
    func setSize(width: CGFloat? = nil, height: CGFloat? = nil) {
        translatesAutoresizingMaskIntoConstraints = false
        var constraints: [NSLayoutConstraint] = []

        if let width = width {
            constraints.append(widthAnchor.constraint(equalToConstant: width))
        }

        if let height = height {
            constraints.append(heightAnchor.constraint(equalToConstant: height))
        }

        NSLayoutConstraint.activate(constraints)
    }
}
