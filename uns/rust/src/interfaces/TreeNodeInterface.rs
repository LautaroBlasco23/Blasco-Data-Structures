use crate::implementations::LinkedList::LinkedList;

use crate::implementations::TreeNode::TreeNode;

pub trait TreeNodeInterface<E> {
    fn new(value: E) -> Self;
    fn get_value(&self) -> Option<E>;
    fn get_children(&self) -> LinkedList<TreeNode<E>>;
}
