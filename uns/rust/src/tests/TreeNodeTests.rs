#[allow(unused_imports)]
use crate::implementations::TreeNode::TreeNode;
#[allow(unused_imports)]
use crate::interfaces::TreeNodeInterface::TreeNodeInterface;

#[test]
fn tree_node_creation() {
    let new_tree_node = TreeNode::new(1);
    let other_tree_node = TreeNode::new(2);
    
    assert_eq!(new_tree_node.get_value(), &1);
    assert_eq!(other_tree_node.get_value(), &2);
}


#[test]
fn tree_node_value() {
    let mut new_tree_node = TreeNode::new(1);
    let mut other_tree_node = TreeNode::new(2);

    new_tree_node.set_value(500);
    other_tree_node.set_value(4);
    
    assert_eq!(new_tree_node.get_value(), &500);
    assert_eq!(other_tree_node.get_value(), &4);
}


#[test]
fn tree_node_children_operations() {
    let mut new_tree_node = TreeNode::new(1);

    // Testing push front
    for i in 1..=10 {
        let new_child = TreeNode::new(i);
        new_tree_node.push_child_front(new_child);
    }

    // Testing pop front
    for i in (1..=10).rev() {
        match new_tree_node.pop_child_front() {
            Some(child) => {
                assert_eq!(child.get_value(), &i);
            }
            None => {}
        }
    }

    // Testing push back 
    for i in 1..=10 {
        let new_child = TreeNode::new(i);
        new_tree_node.push_child_back(new_child);
    }

    // Testing pop back 
    for i in (1..=10).rev() {
        match new_tree_node.pop_child_back() {
            Some(child) => {
                assert_eq!(child.get_value(), &i);
            }
            None => {}
        }
    }
}
