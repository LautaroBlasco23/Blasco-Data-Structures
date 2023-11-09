use crate::implementations::TreeNode::TreeNode;
use crate::implementations::LinkedList::LinkedList;

pub trait TreeInterface<E: PartialEq> {
    // Constructor
    fn new() -> Self;
    // booleans
    fn is_empty(&self) -> bool;
    fn is_internal(&self, node: TreeNode<E>);
    fn is_external(&self, node: TreeNode<E>);
    fn is_root(&self, node: TreeNode<E>);
    // getters
    fn get_root(&self) -> TreeNode<E>;
    fn get_all_nodes(&self) -> LinkedList<TreeNode<E>>;
    fn insert_node(&self, node: TreeNode<E>);
    fn positions(&self) -> LinkedList<TreeNode<E>>;
    fn replace(&self, position: TreeNode<E>, new_node: TreeNode<E>);
    // setters
    fn set_root(&mut self, root_value: E);
    fn add_first_child(position: TreeNode<E>, value: E);
    fn add_last_child(position: TreeNode<E>, value: E);
    fn add_before(position: TreeNode<E>, value: E);
    fn add_after(position: TreeNode<E>, value: E);
    fn remove_external(position: TreeNode<E>) -> Option<E>;
    fn remove_internal(position: TreeNode<E>) -> Option<E>;
    fn remove_node(position: TreeNode<E>) -> Option<E>;
}
