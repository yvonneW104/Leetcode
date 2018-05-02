/*
* Tree Traversals:
* Inorder: (Left, Root, Right)
* Preorder: (Root, Left, Right) 
* Postorder (Left, Right, Root) 
*/

/*
		1
	   / \
	  2   3
	 / \ 
	4   5  
Inorder: 4 2 5 1 3
Preorder: 1 2 4 5 3
Postorder: 4 5 2 3 1	
*/

/*
Algorithm Inorder(tree)
	1. Traverse the left subtree, i.e., call Inorder(left-subtree)
	2. Visit the root.
	3. Traverse the right subtree, i.e., call Inorder(right-subtree)
*/
void printInorder(Node node) {
    if (node == null)
        return;
    /* first recur on left child */
    printInorder(node.left);
    /* then print the data of node */
    System.out.print(node.key + " ");
    /* now recur on right child */
    printInorder(node.right);
}

/*
Algorithm Preorder(tree)
	1. Visit the root.
	2. Traverse the left subtree, i.e., call Preorder(left-subtree)
	3. Traverse the right subtree, i.e., call Preorder(right-subtree) 
*/
void printPreorder(Node node) {
    if (node == null)
        return;
    /* first print data of node */
    System.out.print(node.key + " ");
    /* then recur on left sutree */
    printPreorder(node.left);
    /* now recur on right subtree */
    printPreorder(node.right);
}

/*
Algorithm Postorder(tree)
	1. Traverse the left subtree, i.e., call Postorder(left-subtree)
	2. Traverse the right subtree, i.e., call Postorder(right-subtree)
	3. Visit the root.
*/
void printPostorder(Node node) {
    if (node == null)
        return;
    // first recur on left subtree
    printPostorder(node.left);
    // then recur on right subtree
    printPostorder(node.right);
    // now deal with the node
    System.out.print(node.key + " ");
}