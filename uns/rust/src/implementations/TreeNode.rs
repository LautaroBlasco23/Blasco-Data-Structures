use crate::{implementations::LinkedList::LinkedList, interfaces::TreeNodeInterface::TreeNodeInterface};

pub struct TreeNode<E> {
    value: E,
    children: LinkedList<TreeNode<E>>,
}

impl<E> TreeNodeInterface<E> for TreeNode<E> {
    
}
