#[allow(unused_imports)]
use crate::implementations::{BinaryTree::BinaryTree, BinaryTreeNode::BinaryTreeNode};
#[allow(unused_imports)]
use crate::interfaces::LinkedListInterface::LinkedListInterface;
#[allow(unused_imports)]
use crate::interfaces::{BinaryTreeInterface::BinaryTreeInterface, BinaryTreeNodeInterface::BinaryTreeNodeInterface};

#[test]
fn constructor_and_root() {
    let new_node_ptr = Box::into_raw(Box::new(BinaryTreeNode::new(1)));
    
    let mut new_tree = BinaryTree::new(new_node_ptr);
    assert_eq!(new_tree.get_root(), Some(new_node_ptr));

    let new_root_ptr = Box::into_raw(Box::new(BinaryTreeNode::new(2)));
    new_tree.set_root(new_root_ptr);
    assert_eq!(new_tree.get_root(), Some(new_root_ptr));
    assert_eq!(new_tree.get_size(), 1);
}

#[test]
fn booleans() {
    // Tree Creation
    let new_node_ptr = Box::into_raw(Box::new(BinaryTreeNode::new(1)));
    let new_tree = BinaryTree::new(new_node_ptr);

    assert!(!new_tree.is_empty());
    assert!(!new_tree.is_internal(new_node_ptr));
    assert!(new_tree.is_external(new_node_ptr));
    assert!(new_tree.is_root(new_node_ptr));
}

#[test]
fn setters() {
    // Create Tree and set root.
    let new_node_ptr = Box::into_raw(Box::new(BinaryTreeNode::new(1)));
    let mut new_tree = BinaryTree::new(new_node_ptr);
    assert!(new_tree.is_root(new_node_ptr));

    // Replace.
    new_tree.replace(new_tree.get_root().unwrap(), 2);
    unsafe {
        assert_eq!((*new_tree.get_root().unwrap()).get_value(), 2);
    }

    new_tree.add_first_child(new_node_ptr, 10);
    new_tree.add_last_child(new_node_ptr, 20);
    let mut positions = new_tree.positions().iterator();

    unsafe {
        assert_eq!(positions.next().unwrap(), new_node_ptr);
        assert_eq!((*positions.next().unwrap()).get_value(), 10);
        assert_eq!((*positions.next().unwrap()).get_value(), 20);
    }
    
    let mut positions = new_tree.positions().iterator();
    positions.next();
    // Testing the parent of the first child of the root (it must be the root).
    assert_eq!(new_node_ptr, new_tree.parent(positions.next().unwrap()).unwrap());
}

#[test]
fn iterables() {
    let new_root = Box::into_raw(Box::new(BinaryTreeNode::new(1)));
    let mut new_tree = BinaryTree::new(new_root);

    for i in 0..10 {
        let new_node_ptr = Box::into_raw(Box::new(BinaryTreeNode::new(i)));
        new_tree.add_node(new_node_ptr);
    }

    for pos in new_tree.positions().iterator() {
        unsafe {
            println!("{:?}", (*pos).get_value());
        }
    }
    // fn iterator(&self) -> LinkedListIterator<T>; 
    // fn positions(&self) -> LinkedList<*mut BinaryTreeNode<T>>;
    // fn children(&self, node: *mut BinaryTreeNode<T>) -> LinkedList<T>;
}

    // fn add_before(&mut self, node: *mut BinaryTreeNode<T>, element: T) -> Option<*mut BinaryTreeNode<T>>;
    // fn remove_external_node(&mut self, node: *mut BinaryTreeNode<T>);
    // fn remove_internal_node(&mut self, node: *mut BinaryTreeNode<T>);
    // fn remove_node(&mut self, node: *mut BinaryTreeNode<T>);

