use crate::{implementations::LinkedList::LinkedList, interfaces::{TreeNodeInterface::TreeNodeInterface, LinkedListInterface::LinkedListInterface}};

#[derive(PartialEq, Copy, Clone, Debug)]
pub struct TreeNode<T: PartialEq + Copy> {
    value: T,
    children: LinkedList<TreeNode<T>>,
}

impl<T: PartialEq + Copy> TreeNodeInterface<T> for TreeNode<T> {

    // Constructor
    fn new(value: T) -> Self {
        TreeNode {
            value,
            children: LinkedList::new(),
        }
    }

    // Getters
    fn get_value(&self) -> &T {
        &self.value
    }

    fn get_children(&self) -> *mut LinkedList<TreeNode<T>> {
        Box::into_raw(Box::new(self.children))
    }

    fn pop_child_front(&mut self) -> Option<&TreeNode<T>> {
        self.children.pop_front()
    }

    fn pop_child_back(&mut self) -> Option<&TreeNode<T>> {
        self.children.pop_back()
    }

    // Setters
    fn set_value(&mut self, new_element: T) {
        self.value = new_element;
    }

    fn push_child_front(&mut self, new_child: TreeNode<T>) {
        self.children.push_front(new_child);
    }

    fn push_child_back(&mut self, new_child: TreeNode<T>) {
        self.children.push_back(new_child);
    }
}
