use crate::interfaces::BinaryTreeNodeInterface::BinaryTreeNodeInterface;

#[derive(Clone, Copy, PartialEq)]
pub struct BinaryTreeNode<T> {
    value: T,
    left_child: Option<*mut BinaryTreeNode<T>>,
    right_child: Option<*mut BinaryTreeNode<T>>,
}

impl<T: Copy + PartialEq> BinaryTreeNodeInterface<T> for BinaryTreeNode<T> {
    // Constructor
    fn new(value: T) -> Self {
        BinaryTreeNode { 
            value, 
            left_child: None, 
            right_child: None 
        }
    }

    // Setters
    fn set_value(&mut self, new_value: T) {
        self.value = new_value;
    }

    fn set_left_child(&mut self, child: *mut BinaryTreeNode<T>) {
        self.left_child = Some(child);
    }

    fn set_right_child(&mut self, child: *mut BinaryTreeNode<T>) {
        self.right_child = Some(child);
    }

    fn remove_left_child(&mut self) {
        self.left_child = None;
    }

    fn remove_right_child(&mut self) {
        self.right_child = None;
    }

    // Getters
    fn get_value(&self) -> T {
        self.value
    }

    fn get_left_child(&self) -> Option<*mut BinaryTreeNode<T>> {
        self.left_child
    }

    fn get_right_child(&self) -> Option<*mut BinaryTreeNode<T>> {
        self.right_child
    }
}
