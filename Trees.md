## Trees


#### 530. Minimum Absolute Difference in BST

Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

 
Example 1:

```
Input: root = [4,2,6,1,3]
Output: 1
```

Example 2:

```
Input: root = [1,0,48,null,null,12,49]
Output: 1
```

The idea is to **in-order** to get sorted array, and then return abs(array[0] - array[1])

```
getMinDifference(root.left);

// process the root
min_diff = Math.min(min_diff, root.val - prev;

prev = root.val;

getMinDifference(root.right);
```


#### 543. Diameter of the Binary tree

![alt text](images/diamtree.jpg "diameter of btree")


Input: root = ``[1,2,3,4,5]``

Output: ``3``

Explanation: ``3`` is the length of the path ``[4,2,1,3]`` or ``[5,2,1,3]``.

Example 2:

Input: root = ``[1,2] ``

Output: 1



```
Height = 1 + Max(left, right)
Diameter = left_height + right_height + 2
```

```
left = dfs(root.left)
right = dfs(root.right)

res = Math.max(res, 2 + left + right)

height = 1 + Math.max(left, right)
```

#### 573. Subtree of Another Tree

Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

![alt text](images/subtree1-tree.jpg "sub tree")

Input: root = ``[3,4,5,1,2]``, subRoot = ``[4,1,2]``

Output: ``true``

The idea is so have two functions: 1. sameTree which takes two roots s and t and returns True of they are the same, or False otherwise.


#### 589. N-ary Tree Preorder Traversal

Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

![alt text](https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png "pre-order n-ary tree")

The idea to use stack, put there a root, than go through children and keep their values onto the list.


```
Stack<Node> stack = new Stack<Node>();
List<Integer> result = new ArrayList<Node>();

if(root == null)
    return result;
    
stack.push(root);

while(!stack.isEmpty()) {
    Node curNode = stack.pop();
    result.add(curNode.val);
    
    Collections.reverse(curNode.children);
    for(Node child : curNode.children) {
        stack.push(child);
    }
    
    return result;
}
```

