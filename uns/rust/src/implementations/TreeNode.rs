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
            value,
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

    fn pop_child_front(&mut self) -> Option<&TreeNode<E>> {
        self.children.pop_front()
    }

    fn pop_child_back(&mut self) -> Option<&TreeNode<E>> {
        self.children.pop_back()
    }

    // Setters
    fn set_value(&mut self, new_element: E) {
        self.value = new_element;
    }

    fn push_child_front(&mut self, new_child: TreeNode<E>) {
        self.children.push_front(new_child);
    }

    fn push_child_back(&mut self, new_child: TreeNode<E>) {
        self.children.push_back(new_child);
    }
}
