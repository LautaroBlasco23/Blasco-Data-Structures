use crate::implementations::LinkedList::LinkedList;
use crate::implementations::TreeNode::TreeNode;

pub trait TreeNodeInterface<T: PartialEq + Copy> {
    // Constructor
    fn new(value: T) -> Self;
    // Getters
    fn get_value(&self) -> &T;
    fn get_children(&self) -> *mut LinkedList<TreeNode<T>>;
    // Setters
    fn set_value(&mut self, new_element: T);
    fn push_child_front(&mut self, new_child: TreeNode<T>);
    fn push_child_back(&mut self, new_child: TreeNode<T>);
    fn pop_child_front(&mut self) -> Option<&TreeNode<T>>;
    fn pop_child_back(&mut self) -> Option<&TreeNode<T>>;
}
