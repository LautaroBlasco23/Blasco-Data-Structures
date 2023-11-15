#[allow(unused_imports)]
use crate::implementations::Tree::Tree;
#[allow(unused_imports)]
use crate::interfaces::LinkedListInterface::LinkedListInterface;
#[allow(unused_imports)]
use crate::interfaces::TreeInterface::TreeInterface;
#[allow(unused_imports)]
use crate::implementations::TreeNode::TreeNode;
#[allow(unused_imports)]
use crate::interfaces::TreeNodeInterface::TreeNodeInterface;


#[test]
fn tree_creation() {
    let new_tree: Tree<TreeNode<i32>> = Tree::new();

    assert_eq!(new_tree.get_root(), None);
}

#[test]
fn tree_set_root() {
    let mut new_tree: Tree<i32> = Tree::new();

    new_tree.set_root(2);

    let new_root = match new_tree.get_root() {
        Some(root) => {
            unsafe {
                *(*root).get_value()
            }
        }
        None => panic!("error setting new root")
    };

    assert_eq!(new_root, 2);
}

#[test]
fn is_empty() {
    let mut new_tree: Tree<i32> = Tree::new();

    assert_eq!(new_tree.is_empty(), true);

    new_tree.set_root(1);

    assert_eq!(new_tree.is_empty(), false);
}

#[test]
fn positions() {
    let mut new_tree: Tree<isize> = Tree::new();

    for i in 1..=50 {
        let mut new_tree_node = TreeNode::new(i);
        new_tree.insert_node(&mut new_tree_node);
    }

    let mut positions = new_tree.positions();

    for i in 1..=50 {
        if let Some(pos) = positions.pop_back() {
            assert_eq!(pos.get_value(), &i);
        }
    }

}

#[test]
fn replace() {
    let mut new_tree: Tree<isize> = Tree::new();

    // First we test the positions of the tree
    for i in 1..=50 {
        let mut new_tree_node = TreeNode::new(i);
        new_tree.insert_node(&mut new_tree_node)
    }

    let mut positions = new_tree.positions();

    // Then we replace the positions with new ones.
    for i in (1..=50).rev() {
        let new_tree_node = TreeNode::new(i);

        if let Some(pos) = positions.pop_front() {
            assert_eq!(pos.get_value(), new_tree_node.get_value());
            new_tree.replace(*pos, new_tree_node)
        }
    }

    for i in 1..=50 {
        let new_tree_node = TreeNode::new(i);
        
        if let Some(pos) = positions.pop_back() {
            assert_eq!(pos.get_value(), new_tree_node.get_value());
        }
    }
}

#[test]
fn add_after_and_before() {
    let mut new_tree: Tree<isize> = Tree::new();
    let mut new_node = TreeNode::new(0);

    new_tree.insert_node(&mut new_node);

    for i in 1..=5 {
        if i < 6 {
            new_tree.add_before(new_node, i);
        } else {
            new_tree.add_after(new_node, i);
        }
    }
}

#[test]
fn is_root() {
    let mut new_tree: Tree<isize> = Tree::new();
    let mut new_node = TreeNode::new(0);

    new_tree.insert_node(&mut new_node);
    assert!(new_tree.is_root(&mut new_node));
}

#[test]
fn is_internal_or_external() {
    let mut new_tree: Tree<isize> = Tree::new();
    let mut new_node = TreeNode::new(0);
    new_tree.insert_node(&mut new_node);

    let mut second_node = TreeNode::new(2);
    new_tree.insert_node(&mut second_node);

    // Must be true
    assert!(new_tree.is_internal(&mut new_node));
    // Must be false
    assert!(!new_tree.is_external(&mut new_node));

    // Must be false
    assert!(!new_tree.is_internal(&mut second_node));
    // Must be true 
    assert!(new_tree.is_external(&mut second_node));
}
