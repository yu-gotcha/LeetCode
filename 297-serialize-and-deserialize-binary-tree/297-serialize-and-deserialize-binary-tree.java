import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            if (tmp == null) {
                list.add("#");
            } else {
                list.add("" + tmp.val);
                q.offer(tmp.left);
                q.offer(tmp.right);
            }
        }

        return String.join(",", list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if (arr[0].equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            if (tmp != null) {
                TreeNode left = null;
                if (!arr[i].equals("#")) {
                    left = new TreeNode(Integer.parseInt(arr[i]));
                }
                tmp.left = left;
                q.offer(left);
                i++;

                TreeNode right = null;
                if (!arr[i].equals("#")) {
                    right = new TreeNode(Integer.parseInt(arr[i]));
                }
                tmp.right = right;
                q.offer(right);
                i++;
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));