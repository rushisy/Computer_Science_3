package practice_lab;

public class Practice_Lab {
	/*
	// SIZE

	private int counter = 0;

	public int size() {
		if (overallRoot == null) {
			return 0;
		}
		int size = helper(overallRoot);
		return size;
	}

	private int helper(IntTreeNode root) {
		if (root != null) {
			helper(root.left);
			counter++;
			helper(root.right);
		}
		return counter;
	}

	// COUNTLEAVES

	private int counter = 0;

	public int countLeaves() {
	    if(overallRoot == null) {
	        return 0;
	    }
	    int size = helper(overallRoot);
	    return size;
	}

	private int helper(IntTreeNode root) {
        if(root == null)
            return counter;
        else if(root.left == null && root.right == null) 
            counter++;
        else {
            helper(root.left);
            helper(root.right);
      	}
        return counter;
    }

	// SUM

	private int counter = 0;

	public int sum() {
		if (overallRoot == null) {
			return 0;
		}
		int size = helper(overallRoot);
		return size;
	}

	private int helper(IntTreeNode root) {
		if (root != null) {
			helper(root.left);
			counter += root.data;
			helper(root.right);
		}
		return counter;
	}

	// DEPTH SUM

	private int counter = 0;

	public int depthSum() {
	    if(overallRoot == null) {
	        return 0;
	    }
	    int size = helper(overallRoot, 1);
	    return size;
	}

	private int helper(IntTreeNode root, int level) {
        if(root == null)
            return 0;
        else {
            int leftSum = helper(root.left, level+1);
            int rightSum = helper(root.right, level+1);
            int current = root.data * level;
            return leftSum + rightSum + current;
        }
            
	}
	
	// NUM EMPTY

	private int counter = 0;

	public int numEmpty() {
	    if(overallRoot == null) {
	        return 1;
	    }
	    int size = helper(overallRoot);
	    return size;
	}

	private int helper(IntTreeNode root) {
        if(root == null)
            return 1;
        else {
            int left = helper(root.left);
            int right = helper(root.right);
            return left + right;
        }
            
	}
	
	// HEIGHT

	public int height() {
	    if(overallRoot == null) {
	        return 0;
	    }
	    int size = helper(overallRoot);
	    return size;
	}

	private int helper(IntTreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int left = helper(root.left) + 1;
            int right = helper(root.right) + 1;
            if(left > right) {
                return left;
            } else {
                return right;
            }
        }
	}

	// PRINT LEVEL

	public void printLevel(int key) {
		if (key > 0) {
			printLevel(overallRoot, key, 1);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void printLevel(IntTreeNode root, int key, int position) {
		if (root == null) {
			return;
		}
		if (key == position) {
			System.out.println(root.data);
		} else if (key > position) {
			printLevel(root.left, key, position + 1);
			printLevel(root.right, key, position + 1);
		} else {
			printLevel(root, key, position);
		}
	}*/
}
