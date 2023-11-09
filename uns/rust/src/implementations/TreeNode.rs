use crate::{implementations::LinkedList::LinkedList, interfaces::{TreeNodeInterface::TreeNodeInterface, LinkedListInterface::LinkedListInterface}};

#[derive(PartialEq)]
pub struct TreeNode<E: PartialEq> {
    value: E,
    children: LinkedList<TreeNode<E>>,
}

impl<E: PartialEq> TreeNodeInterface<E> for TreeNode<E> {

    // Constructor
    fn new(value: E) -> Self {
        TreeNode {
            value: value,
            children: LinkedList::new(),
        }
    }

    // Getters
    fn get_value(&self) -> &E {
        &self.value
    }

    fn get_children(&self) -> &LinkedList<TreeNode<E>> {
        &self.children
    }

    // Setters
    fn set_value(&mut self, new_element: E) {
        self.value = new_element;
    }

    fn push_child_front(&mut self, element: E) {
        let new_tree_node = TreeNode::new(element);
        self.children.push_front(new_tree_node);
    }

    fn push_child_back(&mut self, element: E) {
        let new_tree_node = TreeNode::new(element);
        self.children.push_back(new_tree_node);
    }

    fn pop_child_front(&mut self) {
        self.children.pop_front();
    }

    fn pop_child_back(&mut self) {
        self.children.pop_back();
    }
}
