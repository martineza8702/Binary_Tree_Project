
// Simple binary tree class that includes methods to construct a
// tree of ints, to print the structure, and to print the data
// using a preorder, inorder or postorder traversal.  The trees
// built have nodes numbered starting with 1 and numbered
// sequentially level by level with no gaps in the tree. 
// The documentation refers to these as "sequential trees."

import java.util.*;
public class IntTree 
{    private IntTreeNode overallRoot; 
// pre : max > 0
// post: constructs a sequential tree with given number of
//       nodes 
public IntTree(int max)
{        
	if (max <= 0) 
	{           
		throw new IllegalArgumentException("max: " + max);
		}       
	overallRoot = buildTree(1, max);   
	}

/*
//depthSum
public int depthSum()
{
	return depthSum(overallRoot, 1); //calls helper method to assist root node and level 1 returning a value
}
private int depthSum(IntTreeNode node, int level)
{
	if(node == null)
	{
		return 0;
	}
	int sum = level*node.data;
	return sum + depthSum(node.left, level + 1) + depthSum(node.right, level + 1);
}

*/




// post: returns a sequential tree with n as its root unless
//       n is greater than max, in which case it returns an  
//       empty tree   
private IntTreeNode buildTree(int n, int max)
{       
	if (n > max)
	{            
		return null;      
		} 
	else 
	{           
		return new IntTreeNode(n, buildTree(2 * n, max), 
				buildTree(2 * n + 1, max));  
		}   
	}
// post: prints the tree contents using a preorder traversal  
public void printPreorder() 
{       
	System.out.print("preorder:");
	printPreorder(overallRoot);      
	System.out.println();   
	}   
// post: prints the tree contents using a preorder traversal
// post: prints in preorder the tree with given root  
private void printPreorder(IntTreeNode root) 
{       
	if (root != null)
	{
		System.out.print(" " + root.data);  
		printPreorder(root.left);        
		printPreorder(root.right);       
		}  
	}
// post: prints the tree contents using a inorder traversal    
public void printInorder() 
{       
	System.out.print("inorder:");      
	printInorder(overallRoot);       
	System.out.println(); 
	}

    // post: prints in inorder the tree with given root   
private void printInorder(IntTreeNode root)
{       
	if (root != null)
	{           
		printInorder(root.left);    
		System.out.print(" " + root.data);    
		printInorder(root.right);      
		}  
	}  
// post: prints the tree contents using a postorder traversal  
public void printPostorder()
{     
	System.out.print("postorder:");     
	printPostorder(overallRoot);    
	System.out.println(); 
	}    
// post: prints in postorder the tree with given root  
private void printPostorder(IntTreeNode root) 
{     
	if (root != null)
	{            
		printPostorder(root.left);  
		printPostorder(root.right);        
		System.out.print(" " + root.data);        
		} 
	}
// post: prints the tree contents, one per line, following an 
//       inorder traversal and using indentation to indicate   
//       node depth; prints right to left so that it looks   
//       correct when the output is rotated.  

/*
//countLeftNodes
public int countLeftNodes ()
{
	return countLeftNodes(overallRoot);
}
private int countLeftNodes(IntTreeNode root)
{
	if (root == null)
	{
		return 0;
	}
	
	else
	{
	int count=1;
	count = count + countLeftNodes(root.left);
	if(root.right != null)
	{
		root = root.right;
		count =	count +
		countLeftNodes(root.left);
	}
	return count;
}
}
*/

public void printSideways() 
{     
	printSideways(overallRoot, 0); 
} 
// post: prints in reversed preorder the tree with given   
//       root, indenting each line to the given level   
private void printSideways(IntTreeNode root, int level)
{
	if (root != null) 
	{           
		printSideways(root.right, level + 1);  
		for (int i = 0; i < level; i++) 
		{
			System.out.print("    ");   
			}
		System.out.println(root.data);   
		printSideways(root.left, level + 1);  
		}
	}
/*
//countEmpty
public int countEmpty()
{
	return countEmpty(overallRoot);
}
int count = 0;
private int countEmpty(IntTreeNode root)
{
	if(root == null)
	{
		return 1;
	}
	else
	{
		if(root.left != null)
		{
			if(root.left.left != null || root.left.right != null)
			{
				countEmpty(root.left);
			}
			else
			{
				count = count + 2;
			}
		}
			else
			{
				count = count + 1;
			}
			if(root.right != null)
			{
				if(root.right.left != null || root.right.right != null)
				{
					countEmpty(root.right);
				}
				else
				{
					count = count + 2;
				}
			}
			else
			{
				count = count + 1;
			}
	}
	return count;
		}
	
*/

/*
//countEvenBranches
 int countEvenBranches(IntTreeNode root)
{
	if(root == null)
	{
		return 0;
	}
	else if (root.data % 2 == 1 || root.left == null && root.right == null)
	{
		return countEvenBranches(root.left) + countEvenBranches(root.right);
	}
	else 
	{
		return 1 + countEvenBranches(root.left) + countEvenBranches(root.right);
	}
}
*/

public int matches(IntTree other) 
{  
	return matches(overallRoot, other.overallRoot); 
	}
private int matches(IntTreeNode myRoot, IntTreeNode otherRoot) 
{
	if (myRoot == null || otherRoot == null)
	{
		return 0;     
		}
	else if (myRoot.data == otherRoot.data)
	{            
		return 1 + matches(myRoot.left, otherRoot.left)  
		+ matches(myRoot.right, otherRoot.right);       
		}
	else
	{
		return matches(myRoot.left, otherRoot.left)   
				+ matches(myRoot.right, otherRoot.right);
		
        }    
	}

}



































