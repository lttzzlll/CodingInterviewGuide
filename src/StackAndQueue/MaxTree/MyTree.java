package StackAndQueue.MaxTree;

/**
 * Created by 10609 on 2017/3/30.
 */
public class MyTree {

    public static boolean contains(int[] arr, int e) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == e) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    public static Node find(Node root, int value) {
        if (root != null) {
            if (value < root.value) {
                return find(root.left, value);
            } else if (value > root.value) {
                return find(root.right, value);
            } else {
                return root;
            }
        }
        return null;
    }

    public static Node find(Node root, Node cur) {
        if (root != null) {
            if (cur.value < root.value) {
                return find(root.left, cur);
            } else if (cur.value > root.value) {
                return find(root.right, cur);
            } else {
                return root;
            }
        }
        return null;
    }


    public static Node[] generateNode(int[] arr) {
        Node[] res = new Node[arr.length];
        int index = 0;
        for (int i : arr) {
            res[index++] = new Node(i);
        }
        return res;
    }

    public static void preOrder(Node root) {
        if (root != null) {
            visit(root);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            visit(root);
            inOrder(root.right);
        }
    }

    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            visit(root);
        }
    }

    public static int counter;

    public static void visit(Node node) {
        System.out.println(node.value + " | " + (++counter));
    }

    public static int[] arrCopy(int[] arr, int left, int right) {
        int[] retArr = new int[right - left + 1];
        int index = 0;
        for (int i = left; i <= right; i++) {
            retArr[index++] = arr[i];
        }
        return retArr;
    }

    public static void process(Node root, int[] arr) {
        for (int i : arr) {
//            insert(root, i);
            add(root, i);
        }
    }

    public static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        } else {
            if (value < root.value) {
                if (root.left == null) {
                    root.left = new Node(value);
                    return root.left;
                } else {
                    return insert(root.left, value);
                }
            } else if (value > root.value) {
                if (root.right == null) {
                    root.right = new Node(value);
                    return root.right;
                } else {
                    return insert(root.right, value);
                }
            } else {
                throw new RuntimeException("Element repeated!");
            }
        }
    }

    public static void add(Node root, int value) {
        if (value < root.value) {
            if (root.left == null) {
                root.left = new Node(value);
            } else {
                add(root.left, value);
            }
        } else if (value > root.value) {
            if (root.right == null) {
                root.right = new Node(value);
            } else {
                add(root.right, value);
            }
        } else {
            throw new RuntimeException("Element repeated!");
        }
    }

    public static void process(Node root, Node[] nodes) {

    }

    public static Node generate(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Node root = new Node(arr[0]);
        int[] copyArr = arrCopy(arr, 1, arr.length - 1);
//        Node[] nodes = generateNode(copyArr);
        process(root, copyArr);
        return root;
    }

    public static int[] generateArr(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            while (true) {
                int temp = (int) (Math.random() * 10000) % (arr.length * arr.length);
                if (!contains(arr, temp)) {
                    arr[i] = temp;
                    break;
                }
            }
        }
        return arr;
    }

    public static void test(int n) {
        int[] arr = generateArr(n);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
        Node root = generate(arr);
        preOrder(root);
        System.out.println("----------------");
        inOrder(root);
        System.out.println("----------------");
        postOrder(root);
        System.out.println("----------------");
    }

    public static void main(String[] args) {
        test(10);
    }
}
