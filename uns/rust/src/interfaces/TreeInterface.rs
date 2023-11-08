use crate::implementations::TreeNode::TreeNode;
use crate::implementations::LinkedList::LinkedList;

pub trait TreeInterface<E> {
    // Constructor
    fn new() -> Self;
    // booleans
    fn is_empty(&self) -> bool;
    fn isInternal(&self, node: TreeNode<E>);
    fn isExternal(&self, node: TreeNode<E>);
    fn isRoot(&self, node: TreeNode<E>);
    // getters
    fn get_root(&self) -> TreeNode<E>;
    fn get_all_nodes(&self) -> LinkedList<TreeNode<E>>;
    fn insert_node(&self, node: TreeNode<E>);
    fn positions(&self) -> LinkedList<TreeNode<E>>;
    fn replace(&self, position: TreeNode<E>, new_node: TreeNode<E>);
    // setters
    fn set_root(&mut self, root_value: E);
    fn addFirstChild(position: TreeNode<E>, value: E);
    fn addLastChild(position: TreeNode<E>, value: E);
    fn addBefore(position: TreeNode<E>, value: E);
    fn addAfter(position: TreeNode<E>, value: E);
    fn removeExternal(position: TreeNode<E>) -> Option<E>;
    fn removeInternal(position: TreeNode<E>) -> Option<E>;
    fn removeNode(position: TreeNode<E>) -> Option<E>;
}
