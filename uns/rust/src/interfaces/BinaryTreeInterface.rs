use crate::implementations::{BinaryTreeNode::BinaryTreeNode, LinkedListIterator::LinkedListIterator, LinkedList::LinkedList};

pub trait BinaryTreeInterface<T: Copy + PartialEq> {
    // Constructor
    fn new(root: *mut BinaryTreeNode<T>) -> Self;

    // Booleans
    fn is_empty(&self) -> bool;
    fn is_internal(&self, node: *mut BinaryTreeNode<T>) -> bool;
    fn is_external(&self, node: *mut BinaryTreeNode<T>) -> bool;
    fn is_root(&self, node: *mut BinaryTreeNode<T>) -> bool;

    // Setters
    fn set_root(&mut self, new_root: *mut BinaryTreeNode<T>);
    fn add_node(&mut self, node: *mut BinaryTreeNode<T>);
    fn replace(&mut self, node: *mut BinaryTreeNode<T>, element: T);
    fn add_first_child(&mut self, node: *mut BinaryTreeNode<T>, element: T) -> Option<*mut BinaryTreeNode<T>>;
    fn add_last_child(&mut self, node: *mut BinaryTreeNode<T>, element: T) -> Option<*mut BinaryTreeNode<T>>;
    fn add_before(&mut self, node: *mut BinaryTreeNode<T>, element: T) -> Option<*mut BinaryTreeNode<T>>;
    fn remove_external_node(&mut self, node: *mut BinaryTreeNode<T>);
    fn remove_internal_node(&mut self, node: *mut BinaryTreeNode<T>);
    fn remove_node(&mut self, node: *mut BinaryTreeNode<T>);

    // Getters
    fn get_root(&self) -> Option<*mut BinaryTreeNode<T>>;
    fn get_size(&self) -> usize;
    fn parent(&self, node: *mut BinaryTreeNode<T>) -> Option<*mut BinaryTreeNode<T>>;

    // Iterables 
    fn iterator(&self) -> LinkedListIterator<T>; 
    fn positions(&self) -> LinkedList<*mut BinaryTreeNode<T>>;
    fn children(&self, node: *mut BinaryTreeNode<T>) -> LinkedList<T>;
}
