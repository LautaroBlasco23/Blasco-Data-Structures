// Linked List
use crate::implementations::LinkedList::LinkedList;
use crate::interfaces::LinkedListInterface::LinkedListInterface;
// Tree
use crate::interfaces::TreeInterface::TreeInterface;
// TreeNode
use crate::implementations::TreeNode::TreeNode;
use crate::interfaces::TreeNodeInterface::TreeNodeInterface;

#[derive(Copy, Clone, Debug)]
pub struct Tree<T: PartialEq + Copy> {
root: Option<*mut TreeNode<T>>,
len: usize,
}

impl<T: PartialEq + Copy> TreeInterface<T> for Tree<T> {
    // Constructor
    fn new() -> Self {
        Tree { 
            root: None,
            len: 0,
        }
    }

    fn new_with_root(root_node: *mut TreeNode<T>) -> Self {
        Tree {
            root: Some(root_node),
            len: 1,
        }
    }

    // booleans
    fn is_empty(&self) -> bool {
        self.len == 0
    }

    fn is_internal(&self, node: *mut TreeNode<T>) -> bool {
        let mut result = false;
        if self.root.is_some() {
            for pos in self.positions().iterator() {
                unsafe {
                    if pos == *node {
                        if (*pos.get_children()).get_size() == 0 {
                            result = true;
                        }
                    }
                }
            }
        }
        result
    }

    fn is_external(&self, node: *mut TreeNode<T>) -> bool {
        let mut result = true;
        if self.root.is_some() {
            for pos in self.positions().iterator() {
                unsafe {
                    if pos == *node {
                        if (*pos.get_children()).get_size() == 0 {
                            result = false;
                        }
                    }
                }
            }
        }
        result
    }

    fn is_root(&self, node: *mut TreeNode<T>) -> bool {
        let mut result = false;
        if self.root.is_some() {
            unsafe {
                if *self.root.unwrap() == *node {
                    result = true; 
                }
            }
        }
        result
    }

    // getters
    fn get_root(&self) -> Option<*mut TreeNode<T>> {
        self.root
    }

    fn get_all_elements(&self) -> LinkedList<&T> {
        let mut remaining_nodes: LinkedList<TreeNode<T>> = LinkedList::new();
        let mut result_list: LinkedList<&T> = LinkedList::new();
        let mut current_node = self.root;

        unsafe {
            while let Some(node) = current_node {
                // First, we push the current node value into our result list.
                result_list.push_back((*node).get_value());
                // Then we get an iterator for the node's children list. 
                let children = (*(*node).get_children()).iterator();
                
                // Pushing all the node's children into the remaining nodes list.
                for node in children {
                    remaining_nodes.push_back(node);
                }

                // updating current_node to be the next in the remaining list.
                if remaining_nodes.get_size() > 0 {
                    current_node = Some(Box::into_raw(Box::new(*remaining_nodes.pop_front().unwrap())));
                } else {
                    current_node = None;
                }
            }
        }
        result_list
    }

    fn insert_node(&mut self, node: &mut TreeNode<T>) {
        // We'll insert the node in the root of the three.
        match self.root {
            Some(old_root) => {
                unsafe {
                    node.push_child_front(*old_root);
                    self.root = Some(Box::into_raw(Box::new(*node)));
                    self.len += 1;
                }
            }
            None => {
                self.root = Some(Box::into_raw(Box::new(*node)));
                self.len += 1;
            }
        }
    }

    fn positions(&self) -> LinkedList<TreeNode<T>> {
        let mut result_list: LinkedList<TreeNode<T>> = LinkedList::new();
        if self.get_root().is_some() {
            unsafe {
                result_list.push_back(*self.get_root().unwrap());
                let node_children = *(*self.get_root().unwrap()).get_children();

                if node_children.get_size() > 0 {
                    for mut pos in node_children.iterator() {
                        self.child_positions(&mut pos, &mut result_list);
                    }
                }
            }
        }
        result_list
    }




    fn replace(&self, position: TreeNode<T>, new_node: TreeNode<T>) {
        // To replace a node, we're going to remove it from the parent's children list. and add the
        // new node in the same position of the list.
        if self.root.is_some() {
            unsafe {
                for node in self.positions().iterator() {
                    for child in (*node.get_children()).iterator() {
                        if child == position {
                            (*node.get_children()).push_front(new_node);
                            return;
                            }
                        } 
                    }
                }
        }
    }

    // setters
    fn set_root(&mut self, root_value: T) {
        if self.root.is_none() {
            self.len += 1;
        }

        let new_root = Some(Box::into_raw(Box::new(TreeNode::new(root_value))));
        self.root = new_root;
    }

    fn add_first_child(&mut self, position: TreeNode<T>, value: T) {
        if self.root.is_some() {
            let list_of_nodes = self.positions();
            let new_child = TreeNode::new(value);

            for mut node in list_of_nodes.iterator() {
                if position == node {
                    node.push_child_front(new_child);
                    break;
                }
            }
            self.len += 1;
        }
    }

    fn add_last_child(&mut self, position: TreeNode<T>, value: T) {
        if self.root.is_some() {
            let list_of_nodes = self.positions();
            let new_child = TreeNode::new(value);

            for mut node in list_of_nodes.iterator() {
                if position == node {
                    node.push_child_back(new_child);
                    break;
                }
            }
            self.len += 1;
        }
    }

    fn add_before(&mut self, position: TreeNode<T>, value: T) {
        if self.root.is_some() {
            let list_of_nodes = self.positions();
            let new_child = TreeNode::new(value);

            for mut node in list_of_nodes.iterator() {
                if position.get_value() == node.get_value() {
                    node.push_child_front(new_child);
                    break;
                }
            }
        }
    }

    fn add_after(&mut self, position: TreeNode<T>, value: T) {
        if self.root.is_some() {
            let list_of_nodes = self.positions();
            let new_child = TreeNode::new(value);

            for mut node in list_of_nodes.iterator() {
                if position.get_value() == node.get_value() {
                    node.push_child_back(new_child);
                    break;
                }
            }
        }
    }
}

// Method developed to add the remaining nodes inside the list passed by parameter.
impl<T: Copy + PartialEq> Tree<T> {
    fn child_positions(&self, new_root: *mut TreeNode<T>, list_of_nodes: *mut LinkedList<TreeNode<T>>)  {
        unsafe {
            let node_children = *(*new_root).get_children();
            (*list_of_nodes).push_back(*new_root);
            if node_children.get_size() > 0 {
                for mut child in node_children.iterator() {
                    self.child_positions(&mut child, list_of_nodes);
                }
            }
        }
    } 
}
