#[allow(unused_imports)]
use crate::implementations::BinaryTreeNode::BinaryTreeNode;
#[allow(unused_imports)]
use crate::interfaces::BinaryTreeNodeInterface::BinaryTreeNodeInterface;
#[allow(unused_imports)]
use crate::interfaces::BinaryTreeInterface::BinaryTreeInterface;

#[test]
fn node_creation_and_value_methods() {
    let mut new_btree_node = BinaryTreeNode::new(1);
    assert_eq!(new_btree_node.get_value(), 1);

    new_btree_node.set_value(2);
    assert_eq!(new_btree_node.get_value(), 2);
}

#[test]
fn node_setters_and_getters() {
    // Node creation
    let mut new_btree_node = BinaryTreeNode::new(1);
    // Children creation
    let left_node_ptr = Box::into_raw(Box::new(BinaryTreeNode::new(2)));
    let right_node_ptr = Box::into_raw(Box::new(BinaryTreeNode::new(3)));

    assert_eq!(new_btree_node.get_left_child(), None);
    assert_eq!(new_btree_node.get_right_child(), None);

    new_btree_node.set_left_child(left_node_ptr);
    new_btree_node.set_right_child(right_node_ptr);

    assert_eq!(new_btree_node.get_left_child(), Some(left_node_ptr));
    assert_eq!(new_btree_node.get_right_child(), Some(right_node_ptr));
}
