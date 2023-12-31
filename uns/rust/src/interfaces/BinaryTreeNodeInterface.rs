use crate::implementations::BinaryTreeNode::BinaryTreeNode;

pub trait BinaryTreeNodeInterface<T> {
    // Constructor
    fn new(value: T) -> Self;
    // Setters
    fn set_value(&mut self, new_value: T);
    fn set_left_child(&mut self, child: *mut BinaryTreeNode<T>);
    fn set_right_child(&mut self, child: *mut BinaryTreeNode<T>);
    fn remove_left_child(&mut self);
    fn remove_right_child(&mut self);
    // Getters
    fn get_value(&self) -> T;
    fn get_left_child(&self) -> Option<*mut BinaryTreeNode<T>>;
    fn get_right_child(&self) -> Option<*mut BinaryTreeNode<T>>;
}
