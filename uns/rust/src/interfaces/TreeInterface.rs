use crate::implementations::TreeNode::TreeNode;
use crate::implementations::LinkedList::LinkedList;

pub trait TreeInterface<T: PartialEq + Copy> {
    // Constructor
    fn new() -> Self;
    fn new_with_root(root_node: *mut TreeNode<T>) -> Self;
    // booleans
    fn is_empty(&self) -> bool;
    fn is_internal(&self, node: *mut TreeNode<T>) -> bool;
    fn is_external(&self, node: *mut TreeNode<T>) -> bool;
    fn is_root(&self, node: *mut TreeNode<T>) -> bool;
    // getters
    fn get_root(&self) -> Option<*mut TreeNode<T>>;
    fn get_all_elements(&self) -> LinkedList<&T>;
    fn insert_node(&mut self, node: &mut TreeNode<T>);
    fn positions(&self) -> LinkedList<TreeNode<T>>;
    fn replace(&self, position: TreeNode<T>, new_node: TreeNode<T>);
    // setters
    fn set_root(&mut self, root_value: T);
    fn add_first_child(&mut self, position: TreeNode<T>, value: T);
    fn add_last_child(&mut self, position: TreeNode<T>, value: T);
    fn add_before(&mut self, position: TreeNode<T>, value: T);
    fn add_after(&mut self, position: TreeNode<T>, value: T);
}
