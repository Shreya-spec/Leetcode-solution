class Solution {
    public boolean isValidSerialization(String preorder) { // TC: O(n) SC: O(1)
        // for a valid preorder traversal, the null node count should be equal to non-null node count + 1
        String[] preorderArray = preorder.split(",");
        int n = preorderArray.length, nodeCount = 1;
        for (int i=0; i<n; i++) {
            if (!preorderArray[i].equals("#")) nodeCount++;
            else { // null node
                if (nodeCount <= 1 && i != n-1) return false; // early stop here
                nodeCount--;
            }
        }
        return nodeCount == 0;
    }
}