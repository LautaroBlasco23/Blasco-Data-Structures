use crate::implementations::LinkedList::LinkedList;
use crate::implementations::TreeNode::TreeNode;

pub trait TreeNodeInterface<E: PartialEq> {
    // Constructor
    fn new(value: E) -> Self;
    // Getters
    fn get_value(&self) -> &E;
    fn get_children(&self) -> &LinkedList<TreeNode<E>>;
    // Setters
    fn set_value(&mut self, new_element: E);
    fn push_child_front(&mut self, element: E);
    fn push_child_back(&mut self, element: E);
    fn pop_child_front(&mut self);
    fn pop_child_back(&mut self);
}
