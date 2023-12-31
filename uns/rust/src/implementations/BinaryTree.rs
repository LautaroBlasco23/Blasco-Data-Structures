use crate::interfaces::{BinaryTreeInterface::BinaryTreeInterface, LinkedListInterface::LinkedListInterface, BinaryTreeNodeInterface::BinaryTreeNodeInterface};
use super::{BinaryTreeNode::BinaryTreeNode, LinkedList::LinkedList, LinkedListIterator::LinkedListIterator};

#[derive(Debug)]
pub struct BinaryTree<T: Copy + PartialEq> {
    root: Option<*mut BinaryTreeNode<T>>,
    size: usize,
}

// Recursive functions
impl<T: Copy + PartialEq> BinaryTree<T> {
    fn recursive_iterator(&self, node: *mut BinaryTreeNode<T>, mut list: LinkedList<T>) {
        unsafe {
            if (*node).get_left_child().is_some() {
                self.recursive_iterator((*node).get_left_child().unwrap(), list);
            }
            if (*node).get_right_child().is_some() {
                self.recursive_iterator((*node).get_right_child().unwrap(), list);
            }
            list.push_back((*node).get_value());
        }
    }

    fn recursive_positions(&self, node: *mut BinaryTreeNode<T>, mut list: LinkedList<*mut BinaryTreeNode<T>>) {
        unsafe {
            if (*node).get_left_child().is_some() {
                self.recursive_positions((*node).get_left_child().unwrap(), list);
            }
            if (*node).get_right_child().is_some() {
                self.recursive_positions((*node).get_right_child().unwrap(), list);
            }
            list.push_back(node);
        }
    }
}

impl<T: Copy + PartialEq> BinaryTreeInterface<T> for BinaryTree<T> {
    fn new(root: *mut BinaryTreeNode<T>) -> Self {
        BinaryTree {
            root: Some(root),
            size: 1,
        }
    }

    // Booleans
    fn is_empty(&self) -> bool {
        self.size == 0
    }

    fn is_internal(&self, node: *mut BinaryTreeNode<T>) -> bool {
        unsafe {
            if (*node).get_left_child().is_none() && (*node).get_right_child().is_none() {
                false 
            } else {
                true
            }
        }
    }

    fn is_external(&self, node: *mut BinaryTreeNode<T>) -> bool {
        unsafe {
            if (*node).get_left_child().is_none() && (*node).get_right_child().is_none() {
                true
            } else {
                false
            }
        }
    }

    fn is_root(&self, node: *mut BinaryTreeNode<T>) -> bool {
        match self.root {
            Some(root_ptr) => root_ptr == node,
            None => false,
        }
    }

    // Setters
    fn set_root(&mut self, new_root: *mut BinaryTreeNode<T>) {
        match self.root {
            Some(old_root_ptr) => {
                unsafe {
                    (*new_root).set_left_child(old_root_ptr);
                    self.root = Some(new_root);
                }
            }
            None => {
                self.root = Some(new_root);
            }
        }
    }

    fn add_node(&mut self, node: *mut BinaryTreeNode<T>) {
        let list_of_positions = self.positions().iterator();

        for position in list_of_positions {
            unsafe {
                if (*position).get_left_child().is_none() {
                    (*position).set_left_child(node);
                    return
                } else if (*position).get_right_child().is_none() {
                    (*position).set_right_child(node);
                    return
                }
            }
        }

    }

    fn replace(&mut self, node: *mut BinaryTreeNode<T>, element: T) {
        let list_of_positions = self.positions();

        for position in list_of_positions.iterator() {
            unsafe {
                if position == node {
                    (*position).set_value(element);
                }
            }
        }
    }

    fn add_first_child(&mut self, node: *mut BinaryTreeNode<T>, element: T) -> Option<*mut BinaryTreeNode<T>> {
        let list_of_positions = self.positions();

        for position in list_of_positions.iterator() {
            unsafe {
                if position == node {
                    match (*position).get_left_child() {
                        Some(left_child_ptr) => {
                            (*left_child_ptr).set_value(element);
                            return Some(left_child_ptr);
                        }
                        None => {
                            let new_left_child = Box::into_raw(Box::new(BinaryTreeNode::new(element)));
                            (*position).set_left_child(new_left_child);
                            return Some(new_left_child);
                        }
                    }
                }
            }
        }
        None
    }

    fn add_last_child(&mut self, node: *mut BinaryTreeNode<T>, element: T) -> Option<*mut BinaryTreeNode<T>> {
        let list_of_positions = self.positions();

        for position in list_of_positions.iterator() {
            unsafe {
                if position == node {
                    match (*position).get_right_child() {
                        Some(right_child_ptr) => {
                            (*right_child_ptr).set_value(element);
                            return Some(right_child_ptr);
                        }
                        None => {
                            let new_right_child = Box::into_raw(Box::new(BinaryTreeNode::new(element)));
                            (*position).set_right_child(new_right_child);
                            return Some(new_right_child);
                        }
                    }
                }
            }
        }
        None
    }

    fn add_before(&mut self, node: *mut BinaryTreeNode<T>, element: T) -> Option<*mut BinaryTreeNode<T>> {
        let position_list = self.positions();
        let mut new_node = BinaryTreeNode::new(element);

        for position in position_list.iterator() {
            unsafe {
                let left_child = (*position).get_left_child();
                let right_child = (*position).get_right_child();

                if let Some(child) = left_child {
                    if child == node {
                        (*position).set_left_child(&mut new_node);
                        new_node.set_left_child(child);
                        return Some(&mut new_node)
                    }
                }

                if let Some(child) = right_child {
                    if child == node {
                        (*position).set_right_child(&mut new_node);
                        new_node.set_left_child(child);
                        return Some(&mut new_node);
                    }
                }
            }
        }
        None
    }

    fn remove_external_node(&mut self, node: *mut BinaryTreeNode<T>) {
        let position_list = self.positions();

        for position in position_list.iterator() {
            unsafe {
                let left_child = (*position).get_left_child();
                let right_child = (*position).get_right_child();

                if let Some(child) = left_child {
                    if child == node {
                        (*position).remove_left_child();
                    }
                }
                if let Some(child) = right_child {
                    if child == node {
                        (*position).remove_right_child();
                    }
                }
            }
        }
    }

    fn remove_internal_node(&mut self, node: *mut BinaryTreeNode<T>) {
        let position_list = self.positions();

        for position in position_list.iterator() {
            unsafe {
                let left_child = (*position).get_left_child();
                let right_child = (*position).get_right_child();

                if let Some(child) = left_child {
                    if child == node {
                        (*position).remove_left_child();
                    }
                }
                if let Some(child) = right_child {
                    if child == node {
                        (*position).remove_right_child();
                    }
                }
            }
        }
    }

    fn remove_node(&mut self, node: *mut BinaryTreeNode<T>) {
        let position_list = self.positions();

        for position in position_list.iterator() {
            unsafe {
                let left_child = (*position).get_left_child();
                let right_child = (*position).get_right_child();

                if let Some(child) = left_child {
                    if child == node {
                        (*position).remove_left_child();
                    }
                }
                if let Some(child) = right_child {
                    if child == node {
                        (*position).remove_right_child();
                    }
                }
            }
        }
    }

    // Getters
    fn get_root(&self) -> Option<*mut BinaryTreeNode<T>> {
        self.root
    }

    fn get_size(&self) -> usize {
        self.size
    }

    fn parent(&self, node: *mut BinaryTreeNode<T>) -> Option<*mut BinaryTreeNode<T>> {
        let position_list = self.positions();
        let mut result = None;

        for position in position_list.iterator() {
            unsafe {
                let left_child = (*position).get_left_child();
                let right_child = (*position).get_right_child();

                if let Some(child) = left_child {
                    if child == node {
                        result = Some(position);
                    }
                }
                if let Some(child) = right_child {
                    if child == node {
                        result = Some(position);
                    }
                }
            }
        }

        result
    }

    // Iterables 
    fn iterator(&self) -> LinkedListIterator<T> {
        let current_node = self.root;
        let list_of_values = LinkedList::new();

        if let Some(curr_node_ptr) = current_node {
            self.recursive_iterator(curr_node_ptr, list_of_values);
        }

        list_of_values.iterator()
    }

    fn positions(&self) -> LinkedList<*mut BinaryTreeNode<T>> {
        let current_node = self.root;
        let mut list_of_values = LinkedList::new();

        unsafe {
            if let Some(curr_node_ptr) = current_node {
                list_of_values.push_back(curr_node_ptr);
                if (*curr_node_ptr).get_left_child().is_some() {
                    self.recursive_positions((*curr_node_ptr).get_left_child().unwrap(), list_of_values);
                }
                if (*curr_node_ptr).get_right_child().is_some() {
                    self.recursive_positions((*curr_node_ptr).get_right_child().unwrap(), list_of_values);
                }
            }
        }

        list_of_values
    }

    fn children(&self, node: *mut BinaryTreeNode<T>) -> LinkedList<T> {
        let children = LinkedList::new();
        self.recursive_iterator(node, children);
        children
    }
}
